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
public class Salary {
    private int id;
    private int userId;
    private String username;
    private Float salary;
    private String comment;
    private String createdAt;
    private String deletedAt;
    private String subLevel;
    private Float subAmount;
    private int subId;
    private String positionName;
    private int positionId;
    private String positionDeletedAt;

    public Salary() {
    }

    public Salary(int id, int userId, String username, Float salary, String comment, String createdAt, String deletedAt, String subLevel, Float subAmount, int subId, String positionName, int positionId, String positionDeletedAt) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.salary = salary;
        this.comment = comment;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.subLevel = subLevel;
        this.subAmount = subAmount;
        this.subId = subId;
        this.positionName = positionName;
        this.positionId = positionId;
        this.positionDeletedAt = positionDeletedAt;
    }

    public String getPositionDeletedAt() {
        return positionDeletedAt;
    }

    public void setPositionDeletedAt(String positionDeletedAt) {
        this.positionDeletedAt = positionDeletedAt;
    }
    
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public int getPositionId() {
        return positionId;
    }


    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Float getSalary() {
        return salary;
    }

    public String getComment() {
        return comment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public String getSubLevel() {
        return subLevel;
    }

    public Float getSubAmount() {
        return subAmount;
    }

    public int getSubId() {
        return subId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void setSubLevel(String subLevel) {
        this.subLevel = subLevel;
    }

    public void setSubAmount(Float subAmount) {
        this.subAmount = subAmount;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }
    
}
