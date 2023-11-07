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

/**
 *
 * @author Shinespark
 */
public class raw_diary_book_moves {
    
    public raw_diary_book_moves(){
        
    }
    
    public boolean set(obj_dbm move, int id_ac){
        Conexion cn=new Conexion();
        try {
            String sql_ = "insert into diary_book_moves (id_acount, id_transaction, type, amount) values(?, ?, ?, ?)";
            PreparedStatement prs =cn.con.prepareStatement(sql_);
            prs.setInt(1,move.getId_acount());
            prs.setInt(2, id_ac);
            prs.setInt(3, move.isType());
            prs.setDouble(4, move.getAmount());
            boolean i_ = prs.execute();
            cn.con.close();
            return i_;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public List<obj_dbm> getAll(){
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from diary_book_moves");
            List<obj_dbm> objects = new ArrayList<>();
            obj_dbm db_ = new obj_dbm();
            while (rs.next()) {  
                db_ = new obj_dbm();
                db_.setId(rs.getInt("id"));
                db_.setId_acount(rs.getInt("id_acount"));
                db_.setId_transaction(rs.getInt("id_transaction"));
                db_.setType(rs.getInt("type"));
                
                db_.setAmount(rs.getInt("amount"));
                objects.add(db_);
            }
            cn.con.close();
            return objects;
        }catch(Exception e){
            return null;
        }
    }
    public List<obj_dbm> getByDB(obj_diary_book db){
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        raw_acounts rwa = new raw_acounts();
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from diary_book_moves where id_transaction=" + db.getId());
            List<obj_dbm> objects = new ArrayList<>();
            obj_dbm db_ = new obj_dbm();
            while (rs.next()) {  
                db_ = new obj_dbm();
                db_.setId(rs.getInt("id"));
                db_.setId_acount(rs.getInt("id_acount"));
                db_.setId_transaction(rs.getInt("id_transaction"));
                db_.setType(rs.getInt("type"));  
                db_.setAmount(rs.getInt("amount"));
                db_.setDescription(rwa.get(rs.getInt("id_acount")).getDescription());
                objects.add(db_);
            }
            cn.con.close();
            return objects;
        }catch(Exception e){
            return null;
        }
    }
    
    public List<obj_dbm> getByAc(int db){
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        raw_acounts rwa = new raw_acounts();
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from diary_book_moves where id_acount=" + db);
            List<obj_dbm> objects = new ArrayList<>();
            obj_dbm db_ = new obj_dbm();
            while (rs.next()) {  
                db_ = new obj_dbm();
                db_.setId(rs.getInt("id"));
                db_.setId_acount(rs.getInt("id_acount"));
                db_.setId_transaction(rs.getInt("id_transaction"));
                db_.setType(rs.getInt("type"));  
                db_.setAmount(rs.getInt("amount"));
                db_.setDescription(rwa.get(rs.getInt("id_acount")).getDescription());
                objects.add(db_);
            }
            cn.con.close();
            return objects;
        }catch(Exception e){
            return null;
        }
    }
    public List<obj_dbm> JOIN(){
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("SELECT diary_book_moves.id, diary_book.date, acounts.description, diary_book_moves.type, diary_book_moves.amount FROM ((diary_book_moves INNER JOIN acounts ON diary_book_moves.id_acount = acounts.id) INNER JOIN diary_book ON diary_book_moves.id_transaction = diary_book.id)");
            List<obj_dbm> objects = new ArrayList<>();
            obj_dbm db_ = new obj_dbm();
            while (rs.next()) {  
                db_ = new obj_dbm();
                db_.setId(rs.getInt("id"));
                db_.setDate(rs.getString("date"));
                db_.setDescription(rs.getString("description"));
                if(rs.getInt("type") == 0){
                    db_.setAcount_type("Haber");
                }else{
                    db_.setAcount_type("Debe");
                }
                db_.setAmount(rs.getInt("amount"));
                objects.add(db_);
            }
            cn.con.close();
            return objects;
        }catch(Exception e){
            return null;
        }
    }
}
