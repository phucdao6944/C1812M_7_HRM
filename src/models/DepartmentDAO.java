/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Department;
import entities.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static models.UserDAO.conn;
import util.ConnectionDb;
import util.IDbHandler;

/**
 *
 * @author Queen
 */
public class DepartmentDAO implements IDbHandler<Department, Integer> {

    static Connection conn = ConnectionDb.getConnect();

    @Override
    public void insert(Department entity) {
        try {
            CallableStatement stm = conn.prepareCall("insert into departments (name,description) values (?,?)");
            stm.setObject(1, entity.getName());
            stm.setObject(2, entity.getDescription());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Department> getAll() {
        List<Department> L = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from departments");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Department d = new Department();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setDescription(rs.getString("description"));
                L.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L;
    }

    @Override
    public Department getById(Integer id) {
        try {
            Department d = new Department();
            PreparedStatement stm = conn.prepareStatement("select top 1 * from departments where id = ?");
            stm.setObject(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setDescription(rs.getString("description"));
            }
            return d;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Department entity) {
        try {
            CallableStatement stm = conn.prepareCall("update departments set name = ? , description = ? where id = ?");
            stm.setObject(1, entity.getName());
            stm.setObject(2, entity.getDescription());
            stm.setObject(3, entity.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
