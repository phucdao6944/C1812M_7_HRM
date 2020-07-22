/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Admin
 */
public class Subsidize {
    private int id;
    private int level;
    private double amount;
    private String comment;

    public Subsidize() {
    }

    public Subsidize(int id, int level, double amount, String comment) {
        this.id = id;
        this.level = level;
        this.amount = amount;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public double getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
