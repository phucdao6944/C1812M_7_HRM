/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ConnectionDb {

    public static Connection getConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/HRM","root","");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
