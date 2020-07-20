/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Insurances;
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
 * @author Admin
 */
public class InsurancesDao implements IDbHandler<Insurances, Integer>{
    static Connection conn = ConnectionDb.getConnect();
    
    @Override
    public void insert(Insurances entity) {
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement("INSERT INTO insurances(name, amount, comment) VALUES(?,?,?)");
            stm.setObject(1, entity.getName());
            stm.setObject(2, entity.getAmount());
            if (entity.getComment() != null) {
                stm.setObject(3, entity.getComment());
            }else{
                stm.setObject(3, null);
            }
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsurancesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("DELETE FROM insurances WHERE id = ? ");
            stm.setObject(1, id);
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsurancesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Insurances> getAll() {
        List<Insurances> insus = new ArrayList<Insurances>();
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("Select * from insurances");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Insurances insurances = new Insurances();
                insurances.setId((int) rs.getObject("id"));
                insurances.setAmount((double) rs.getObject("amount"));
                insurances.setName((String) rs.getObject("name"));
                insurances.setComment((String) rs.getObject("comment"));
                insus.add(insurances);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsurancesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insus;
    }

    @Override
    public Insurances getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void update(Insurances ins){
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement("Update insurances set name = ?, amount = ?, comment = ? where id = ?");
            stm.setObject(1, ins.getName());
            stm.setObject(2, ins.getAmount());
            stm.setObject(3, ins.getComment());
            stm.setObject(4, ins.getId());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsurancesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
