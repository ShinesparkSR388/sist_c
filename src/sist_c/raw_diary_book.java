/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist_c;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Shinespark
 */
public class raw_diary_book {
    public raw_diary_book(){
        
    }
    
    public int set(obj_diary_book book){
        Conexion cn=new Conexion();
        try {
            int code_ = (int) (Math.random()*99999999+1);
            String sql_ = "insert into diary_book (code, description, date) values(?, ?, ?)";
            PreparedStatement prs =cn.con.prepareStatement(sql_);
            prs.setInt(1,code_);
            prs.setString(2, book.getDescription());
            prs.setString(3, book.getDate());
            
            boolean i_ = prs.execute();
            cn.con.close();
            return code_;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }
    public obj_diary_book getByCode(int code){
        Conexion cn=new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from diary_book where code="+ code +"");
            
            obj_diary_book db_ = new obj_diary_book();
            while (rs.next()) {  
                db_.setId(rs.getInt("id"));
                db_.setDescription(rs.getString("description"));
                db_.setDate(rs.getString("date"));
            }
            cn.con.close();
            return db_;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public obj_diary_book getById(int id){
        Conexion cn=new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from diary_book where id="+ id +"");
            
            obj_diary_book db_ = new obj_diary_book();
            while (rs.next()) {  
                db_.setId(rs.getInt("id"));
                db_.setDescription(rs.getString("description"));
                db_.setDate(rs.getString("date"));
            }
            cn.con.close();
            return db_;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<obj_diary_book> getByDate(String date_){
        Conexion cn=new Conexion();
        Statement st;
        ResultSet rs;
        List<obj_diary_book> db_l = new ArrayList<>();
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from diary_book where date='"+ date_ +"'");
            
            obj_diary_book db_ = new obj_diary_book();
            while (rs.next()) {
                db_ = new obj_diary_book();
                db_.setId(rs.getInt("id"));
                db_.setDescription(rs.getString("description"));
                db_.setDate(rs.getString("date"));
                db_.setCode(rs.getInt("code"));
                db_l.add(db_);
            }
            cn.con.close();
            return db_l;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
