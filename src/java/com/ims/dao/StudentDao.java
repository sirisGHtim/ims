/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.modal.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author stim
 */
public class StudentDao {
    
    
    public static boolean addStudent(Student s){
        boolean status = false;
        Connection conn = MyConnection.connect();
        PreparedStatement ps = null;
        
        if(conn!=null){
            String sql ="insert into student_tbl (name,country,gender,hobbies) "
                    + "values(?,?,?,?)";
            try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getCountry());
            ps.setString(3, s.getGender());
            ps.setString(4, s.getHobbies());
            
            if(ps.executeUpdate()==1){
                status = true;
            }
            
            
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            finally{
                ps=null;
                conn = null;
            }
           
        }
       return status;
    }
    
    
}
