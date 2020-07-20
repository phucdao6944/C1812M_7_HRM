/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import entities.LogWork;
import entities.Salary;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static models.LogWorkDao.conn;
import util.IDbHandler;

/**
 *
 * @author Admin
 */
public class SalaryDao implements IDbHandler<Salary, Integer>{
   
    
    public List<Salary> getSalary(int userId, boolean isDelete){
        List<Salary> salaries = new ArrayList<Salary>();
        PreparedStatement stm;
        try {
            String query = "Select sa.*, us.first_name, us.last_name, po.position_name as pos_name, po.id as pos_id,"
                    + "su.amount as sub_amount, su.id as sub_id, su.level as sub_level, up.deleted_at as pos_deleted from salaries sa "
                    + "INNER JOIN users us on sa.user_id = us.id "
                    + "LEFT JOIN user_positions up on sa.user_id = up.user_id "
                    + "LEFT JOIN positions po on up.position_id = po.id "
                    + "LEFT JOIN user_subsidize uss on sa.user_id = uss.user_id "
                    + "LEFT JOIN subsidize su on su.id = uss.subsidize_id "
                    + "where sa.id IS NOT NULL";
            if (isDelete) {
                query += " and up.deleted_at IS NULL";
            }
            if (userId > 0) {
                query += " and sa.user_id = ?";
            }
            stm = conn.prepareStatement(query);
            if (userId > 0) {
                stm.setObject(1, userId);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Salary sal = new Salary();
                sal.setId((int) rs.getObject("id"));
                sal.setUserId((int) rs.getObject("user_id"));
                sal.setUsername(rs.getObject("last_name") + " " + rs.getObject("first_name"));
                sal.setSalary(rs.getFloat("salary"));
                sal.setComment((String) rs.getObject("comment"));
                sal.setCreatedAt(rs.getTimestamp("created_at").toString());
                if (rs.getDate("deleted_at") != null) {
                    sal.setDeletedAt(rs.getTimestamp("deleted_at").toString());
                }
                sal.setSubId((int) rs.getObject("sub_id"));
                sal.setSubLevel(rs.getObject("sub_level").toString());
                sal.setSubAmount(rs.getFloat("sub_amount"));
                sal.setPositionId((int) rs.getObject("pos_id"));
                sal.setPositionName((String) rs.getObject("pos_name"));  
                if (rs.getDate("pos_deleted") != null) {
                    sal.setPositionDeletedAt(rs.getTimestamp("pos_deleted").toString());
                }
                salaries.add(sal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salaries;
    }
    
    public Float totalSalaryByInMonth(int userId, int month){
        GregorianCalendar gcLast = new GregorianCalendar(2020, month, 0);
        java.util.Date monthEndDate = new java.util.Date(gcLast.getTime().getTime());
        GregorianCalendar gcFirst = new GregorianCalendar(2020, month - 1, 1);
        java.util.Date monthFirstDate = new java.util.Date(gcFirst.getTime().getTime());
        LogWorkDao lwDao = new LogWorkDao();
        List<LogWork> logWorks = new ArrayList<LogWork>();
        List<Salary> salaries = new ArrayList<Salary>();
        logWorks = lwDao.getByCreatedAt(monthFirstDate, monthEndDate, userId);
        salaries = getSalary(userId, true);
        Salary salery = salaries.get(0);
        Float totalSalary = 0f;
        System.out.println(logWorks.size());
        if (logWorks.size() > 0) {
            totalSalary = (salery.getSalary() / lwDao.getTotalDaysOfMonth() * logWorks.size()) + salery.getSubAmount();
        }
        return totalSalary;
    }
    @Override
    public void insert(Salary entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Salary> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salary getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
