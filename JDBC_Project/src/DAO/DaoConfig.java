/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

/**
 *
 * @author annas
 */
public class DaoConfig {

    private DaoConfig() {
    }

    public static Connection connectDatabase() {
        try {
            // driver class et obj connexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false", "root", "");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERREUR : " + e);
            return null;
        }
    }

    public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("ERREUR : " + e);
        }
    }
}
