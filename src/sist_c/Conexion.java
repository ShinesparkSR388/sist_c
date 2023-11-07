/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist_c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Shinespark
 */
public class Conexion {
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/sist_db","root","root");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
    }

    public Connection getCon() {
        return con;
    }
    
    public static void main(String[] args) {
        //Creating a new example of connection
        /*
        Conexion cn=new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from acounts");
            while (rs.next()) {                
                System.out.println(rs.getInt("id")+" " +rs.getString("description")+" " +rs.getString("type"));
            }
            cn.con.close();
        } catch (Exception e) {
            System.out.println(e);
        }*/
        
    }

    PreparedStatement prepareStatement(String sql_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
