/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist_c;

/**
 *
 * @author Shinespark
 */
public class obj_dbm {
    private int id;
    private int id_acount;
    private int id_transaction;
    private int type;
    private double amount;
    private String description;
    private String acount_type;
    private String date;

    public String getAcount_type() {
        return acount_type;
    }

    public void setAcount_type(String acount_type) {
        this.acount_type = acount_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_acount() {
        return id_acount;
    }

    public void setId_acount(int id_acount) {
        this.id_acount = id_acount;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public int isType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void sum(double value){
        this.amount = this.amount + value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
