/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.LogWork;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static models.UserDAO.conn;
import sun.security.rsa.RSACore;
import util.ConnectionDb;
import util.IDbHandler;

/**
 *
 * @author Admin
 */
public class LogWorkDao implements IDbHandler<LogWork, Integer> {

    static Connection conn = ConnectionDb.getConnect();

    public List<LogWork> getByUser(int userId) {
        List<LogWork> logWorks = new ArrayList<LogWork>();
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("Select * From log_times lt inner join users us on lt.user_id = us.id where lt.user_id = ?");
            stm.setObject(1, userId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                LogWork logWork = new LogWork();
                logWork.setId((int) rs.getObject("id"));
                logWork.setUserId((int) rs.getObject("user_id"));
                logWork.setStartDate(rs.getTimestamp("start_date").toString());
                if (rs.getDate("end_date") != null) {
                    logWork.setEndDate(rs.getTimestamp("end_date").toString());
                }
                logWork.setComment((String) rs.getObject("comment"));
                logWork.setCreatedAt(rs.getDate("created_at").toString());
                logWork.setUserName((String) rs.getObject("first_name"));
                logWorks.add(logWork);
            }
            return logWorks;
        } catch (SQLException ex) {
            Logger.getLogger(LogWorkDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateEndDate(LogWork entity) {
        try {
            PreparedStatement stm = conn.prepareStatement("UPDATE log_times SET end_date = ? , comment = ? where id = ? ");
            stm.setObject(1, entity.getEndDate());
            stm.setObject(2, entity.getComment());
            stm.setObject(3, entity.getId());
            stm.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LogWorkDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void update(LogWork entity) {
        try {
            PreparedStatement stm = conn.prepareStatement("UPDATE log_times SET comment = ? where id = ? ");
            stm.setObject(1, entity.getComment());
            stm.setObject(2, entity.getId());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LogWorkDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Date getLastDayOfMonth() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        return lastDayOfMonth;
    }

    public Date getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDayOfMonth = calendar.getTime();
        return startDayOfMonth;
    }
    
    public int getTotalDaysOfMonth(){
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDay;
    }
    
    public List<LogWork> getByCreatedAt(Date createdAtStart, Date createdAtEnd, int userId) {
        List<LogWork> logWorks = new ArrayList<LogWork>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement stm;
        String startCreatedAt = formatter.format(createdAtStart) + " 00:00:00";
        String endCreatedAt = formatter.format(createdAtEnd) + " 23:59:59";
        try {
            String query = "SELECT * FROM log_times where (created_at BETWEEN ? AND ?)";
            if (userId > 0) {
                query += " and user_id = ?";
            }
            stm = conn.prepareStatement(query);
            stm.setObject(1, startCreatedAt);
            stm.setObject(2, endCreatedAt);
            if (userId > 0) {
                stm.setObject(3, userId);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                LogWork lw = new LogWork();
                lw.setId((int) rs.getObject("id"));
                lw.setUserId((int) rs.getObject("user_id"));
                lw.setStartDate(rs.getDate("start_date").toString());
                if (rs.getDate("end_date") != null) {
                    lw.setEndDate(rs.getDate("end_date").toString());
                }
                lw.setComment((String) rs.getObject("comment"));
                lw.setCreatedAt(rs.getDate("created_at").toString());
                logWorks.add(lw);
            }
            return logWorks;
        } catch (SQLException ex) {
            Logger.getLogger(LogWorkDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(LogWork entity) {
        PreparedStatement stm;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        try {
            stm = conn.prepareStatement("INSERT INTO log_times(user_id,start_date,comment,created_at) VALUES (?,?,?,?)");
            stm.setObject(1, entity.getUserId());
            stm.setObject(2, formatter.format(date));
            stm.setObject(3, entity.getComment());
            stm.setObject(4, formatter.format(date));
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LogWorkDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LogWork> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogWork getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
