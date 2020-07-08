/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionDb;
import util.IDbHandler;

/**
 *
 * @author Administrator
 */
public class UserDAO implements IDbHandler<User, Integer>{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
