/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Subsidize;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static models.InsurancesDao.conn;
import static models.LogWorkDao.conn;
import util.ConnectionDb;
import util.IDbHandler;

/**
 *
 * @author Admin
 */
public class SubsidizeDao implements IDbHandler<Subsidize, Integer>{
    static Connection conn = ConnectionDb.getConnect();
    @Override
    public void insert(Subsidize entity) {
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("INSERT INTO subsidize(level, amount, comment) VALUES(?,?,?)");
            stm.setObject(1, entity.getLevel());
            stm.setObject(2, entity.getAmount());
            if (entity.getComment() != null) {
                stm.setObject(3, entity.getComment());
            }else{
                stm.setObject(3, null);
            }
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubsidizeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Subsidize getByLevel(Integer level) {
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("Select * from subsidize where level = ?");
            stm.setObject(1, level);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Subsidize subsidize = new Subsidize();
                subsidize.setId((int) rs.getObject("id"));
                subsidize.setLevel((int) rs.getObject("level"));
                subsidize.setAmount((double) rs.getObject("amount"));
                subsidize.setComment((String) rs.getObject("comment"));
                return subsidize;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubsidizeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void delete(Integer id) {
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("DELETE FROM subsidize WHERE id = ? ");
            stm.setObject(1, id);
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubsidizeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Subsidize> getAll() {
        List<Subsidize> subsidizes = new ArrayList<Subsidize>();
        PreparedStatement stm;
        String query = "SELECT * FROM subsidize order by level DESC";
        try {
            stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Subsidize subsidize = new Subsidize();
                subsidize.setId((int) rs.getObject("id"));
                subsidize.setLevel((int) rs.getObject("level"));
                subsidize.setAmount((double) rs.getObject("amount"));
                subsidize.setComment((String) rs.getObject("comment"));
                subsidizes.add(subsidize);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubsidizeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subsidizes;
    }

    @Override
    public Subsidize getById(Integer id) {
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("Select * from subsidize where id = ?");
            stm.setObject(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Subsidize subsidize = new Subsidize();
                subsidize.setId((int) rs.getObject("id"));
                subsidize.setLevel((int) rs.getObject("level"));
                subsidize.setAmount((double) rs.getObject("amount"));
                subsidize.setComment((String) rs.getObject("comment"));
                return subsidize;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubsidizeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Subsidize entity) {
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("Update subsidize set level = ?, amount = ?, comment = ? where id = ?");
            stm.setObject(1, entity.getLevel());
            stm.setObject(2, entity.getAmount());
            stm.setObject(3, entity.getComment());
            stm.setObject(4, entity.getId());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsurancesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
