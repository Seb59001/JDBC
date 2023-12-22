

package DAO;

import java.sql.*;

public class Dao {
    public static void connectDatabase(){
        try{
            // driver class et obj connexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "");
            System.out.println("Creation BDD sucess");
            
            // obj statement
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS JDBC CHARACTER SET utf8");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}