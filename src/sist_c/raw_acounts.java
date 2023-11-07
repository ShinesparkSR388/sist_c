/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist_c;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Shinespark
 */
public class raw_acounts {
    public raw_acounts(){
        
    }
    
    public List<obj_acounts> get_all(){
        Conexion cn=new Conexion();
        Statement st;
        ResultSet rs;
        List<obj_acounts> ac = new ArrayList<>();
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from acounts");
            
            obj_acounts ac_ = new obj_acounts();
            while (rs.next()) {  
                ac_ = new obj_acounts();
                ac_.setId(rs.getInt("id"));
                ac_.setDescription(rs.getString("description"));
                ac_.setType(rs.getString("type"));
                ac.add(ac_);
            }
            cn.con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ac;
    }
    public obj_acounts get(int id){
        Conexion cn=new Conexion();
        Statement st;
        ResultSet rs;
        obj_acounts ac = new obj_acounts();
        try {
            st=cn.con.createStatement();
            String str_ = "select * from acounts where id='" + id + "'";
            rs=st.executeQuery(str_);
            
            while (rs.next()) {  
                ac.setId(rs.getInt("id"));
                ac.setDescription(rs.getString("description"));
                ac.setType(rs.getString("type"));
            }
            cn.con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ac;
    }
    public List<obj_acounts> get_idList(String id){
        Conexion cn=new Conexion();
        Statement st;
        ResultSet rs;
        List<obj_acounts> acc = new ArrayList<>();
        try {
            st=cn.con.createStatement();
            String str_ = "select * from acounts where " + id;
            System.out.print(str_);
            rs=st.executeQuery(str_);
            
                obj_acounts ac = new obj_acounts();
            while (rs.next()) {  
                ac = new obj_acounts();
                ac.setId(rs.getInt("id"));
                ac.setDescription(rs.getString("description"));
                ac.setType(rs.getString("type"));
                acc.add(ac);
            }
            cn.con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return acc;
    }
    
}
