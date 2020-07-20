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
public class Insurances {
    private int id;
    private String name;
    private double amount;
    private String comment;

    public Insurances() {
    }

    public Insurances(int id, String name, double amount, String comment) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
