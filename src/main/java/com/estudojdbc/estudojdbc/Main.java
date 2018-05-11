/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estudojdbc.estudojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author peter
 */
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded");
        }catch(ClassNotFoundException e){
            System.out.println("cFailed to load");
            e.printStackTrace();
        }
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estudo_jdbc?serverTimezone=UTC", "root", "p1p2ls");
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(connection != null){
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS movie (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, PRIMARY KEY (id))";
            statement.executeUpdate(sql);
        }else{
            System.err.println("Erro");
        }
    }
 
}
