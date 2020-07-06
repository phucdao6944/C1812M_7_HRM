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
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionDb;

/**
 *
 * @author Administrator
 */
public class UserDAO {

    static Connection conn = ConnectionDb.getConnect();

    public User login(User us) {
        try {
            User u = new User();
            PreparedStatement stm = conn.prepareStatement("select * from users where username = ? and password = ? limit 1");
            stm.setObject(1, us.getUsername());
            stm.setObject(2, us.getPassword());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole_id(rs.getInt("role_id"));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
