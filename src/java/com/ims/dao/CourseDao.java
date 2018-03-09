/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.modal.CourseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author stim
 */
public class CourseDao {
    
    public static boolean insert(CourseModel cm){
        Connection conn = MyConnection.connect();
        PreparedStatement ps = null;
        boolean status = false;
        
        String sql ="insert into course_tbl "
                + "(title,price,duration) values(?,?,?)";
        
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, cm.getTitle());
            ps.setFloat(2, cm.getPrice());
            ps.setString(3, cm.getDuration());
            
            
            int i = ps.executeUpdate();
            if(i==1){
                System.out.println("Inserted a row");
                status = true;
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return status;
    }
    
    public static ArrayList<CourseModel> selectAll(){
        ArrayList<CourseModel> al = new ArrayList<>();
        Connection conn = MyConnection.connect();
        PreparedStatement ps = null;
        
        if(conn!=null){
            
            String sql = "select * from course_tbl";
            
            try{
               ps = conn.prepareStatement(sql);
               
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
                   al.add(new CourseModel(
                           rs.getInt("id"), 
                           rs.getString("title"),
                           rs.getFloat("price"),
                           rs.getString("duration")));
               }
                
            }catch(SQLException se){
                System.out.println(se);
            }
        }
        
        return al;
    }
    
     public static ArrayList<CourseModel> selectById(int id){
        ArrayList<CourseModel> al = new ArrayList<>();
        Connection conn = MyConnection.connect();
        PreparedStatement ps = null;
        
        if(conn!=null){
            
            String sql = "select * from course_tbl where id=?";
            
            try{
               ps = conn.prepareStatement(sql);
               ps.setInt(1, id);
               
               ResultSet rs = ps.executeQuery();
               
               if(rs.next()){
                   al.add(new CourseModel(
                           rs.getInt("id"), 
                           rs.getString("title"),
                           rs.getFloat("price"),
                           rs.getString("duration")));
               }
                
            }catch(SQLException se){
                System.out.println(se);
            }
        }
        
        return al;
    }
    
     public static boolean update(CourseModel cm){
        
        Connection conn = MyConnection.connect();
        PreparedStatement ps = null;
        boolean status = false;
        
        String sql ="update course_tbl set "
                +"title=?, price=?, duration=? "
                + "where id=?";
        
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, cm.getTitle());
            ps.setFloat(2, cm.getPrice());
            ps.setString(3, cm.getDuration());
            ps.setInt(4, cm.getId());
            
            
            int i = ps.executeUpdate();
            if(i==1){
                System.out.println("Updated a row");
                status = true;
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return status;
        
     }
     
}
