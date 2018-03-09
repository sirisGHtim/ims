/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author stim
 */
public class MyConnection {
    
    public static Connection connect(){
        Connection conn = null;
        
        String url = "jdbc:mysql://localhost:3306/imsdb";
        String user = "root";
        String pass = "";
        
        try{
            
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pass);
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e); 
        }
        return conn;
    }
}
