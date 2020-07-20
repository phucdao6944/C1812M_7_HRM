/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
import util.ConnectionDb;
import util.IDbHandler;

/**
 *
 * @author Administrator
 */
public class UserDAO implements IDbHandler<User, Integer> {

    static Connection conn = ConnectionDb.getConnect();

    public User login(User us) {
        try {
            User u = new User();
            PreparedStatement stm = conn.prepareStatement("select top 1 * from users where email = ? and password = ?");
            stm.setObject(1, us.getEmail());
            stm.setObject(2, us.getPassword());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFirst_name(rs.getString("first_name"));
                u.setLast_name(rs.getString("last_name"));
                u.setPhone_number(rs.getString("phone_number"));
                u.setDob(rs.getString("dob"));
                u.setIdentity_card(rs.getString("identity_card"));
                u.setAddress(rs.getString("address"));
                u.setStart_date(rs.getString("start_date"));
                u.setEnd_date(rs.getString("end_date"));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(User entity) {
        try {
            CallableStatement stm = conn.prepareCall("insert into users (first_name,last_name,email,phone_number,address,dob,identity_card,department_id,password,start_date) values (?,?,?,?,?,?,?,?,123456,?)");
            stm.setObject(1, entity.getFirst_name());
            stm.setObject(2, entity.getLast_name());
            stm.setObject(3, entity.getEmail());
            stm.setObject(4, entity.getPhone_number());
            stm.setObject(5, entity.getAddress());
            stm.setObject(6, entity.getDob());
            stm.setObject(7, entity.getIdentity_card());
            stm.setObject(8, entity.getDepartment_id());
            stm.setObject(9, entity.getStart_date());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getById(Integer id) {
        try {
            User u = new User();
            PreparedStatement stm = conn.prepareStatement("select top 1 * from users where id = ?");
            stm.setObject(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFirst_name(rs.getString("first_name"));
                u.setLast_name(rs.getString("last_name"));
                u.setPhone_number(rs.getString("phone_number"));
                u.setDob(rs.getString("dob"));
                u.setIdentity_card(rs.getString("identity_card"));
                u.setAddress(rs.getString("address"));
                u.setStart_date(rs.getString("start_date"));
                u.setEnd_date(rs.getString("end_date"));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(User entity) {
        try {
            CallableStatement stm = conn.prepareCall("update users set first_name = ? , last_name = ?, email = ?, phone_number = ?, address = ?, dob = ? , identity_card = ? where id = ?");
            stm.setObject(1, entity.getFirst_name());
            stm.setObject(2, entity.getLast_name());
            stm.setObject(3, entity.getEmail());
            stm.setObject(4, entity.getPhone_number());
            stm.setObject(5, entity.getAddress());
            stm.setObject(6, entity.getDob());
            stm.setObject(7, entity.getIdentity_card());
            stm.setObject(8, entity.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<User> getByDepartment(Integer id) {
        List<User> L = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from users where department_id = ?");
            stm.setObject(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFirst_name(rs.getString("first_name"));
                u.setLast_name(rs.getString("last_name"));
                u.setPhone_number(rs.getString("phone_number"));
                u.setDob(rs.getString("dob"));
                u.setIdentity_card(rs.getString("identity_card"));
                u.setAddress(rs.getString("address"));
                u.setStart_date(rs.getString("start_date"));
                u.setEnd_date(rs.getString("end_date"));
                L.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L;
    }

}
