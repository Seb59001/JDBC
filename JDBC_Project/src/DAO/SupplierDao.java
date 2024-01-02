/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
/**
 *
 * @author annas
 *
 */

import Modele.Supplier;

public class SupplierDao {

    private SupplierDao() {
    }

    public static int add(Supplier sup) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int ret = -1;

        try {
            // Ouvrir la connexion
            connection = Dao.connectDatabase();

            // Préparer la requête SQL
            String sql = "INSERT INTO supplier VALUES (DEFAULT, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Définir les valeurs des paramètres à partir des méthodes getter
            preparedStatement.setInt(1, sup.getSupplierNumber());
            preparedStatement.setString(2, sup.getLastname());
            preparedStatement.setString(3, sup.getFirstname());
            preparedStatement.setString(4, sup.getEmail());
            preparedStatement.setString(5, sup.getAddress());

            // Exécuter la requête
            ret = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERREUR : " + e);
        } finally {
            // Fermer les ressources
            Dao.closeResources(connection, preparedStatement, resultSet);
        }
        return ret;
    }

    public static int delete(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int ret = -1;

        try {
            // Ouvrir la connexion
            connection = Dao.connectDatabase();

            // Préparer la requête SQL
            String sql = "DELETE FROM supplier WHERE Supplier_ID = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Définir les valeurs des paramètres à partir des méthodes getter
            preparedStatement.setInt(1, id);

            // Exécuter la requête
            ret = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERREUR : " + e);
        } finally {
            // Fermer les ressources
            Dao.closeResources(connection, preparedStatement, resultSet);
        }
        return ret;
    }

    public static Supplier readById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Supplier supplier = null;

        try {
            // Ouvrir la connexion
            connection = Dao.connectDatabase();

            // Préparer la requête SQL
            String sql = "SELECT * FROM supplier WHERE Supplier_ID = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Définir les valeurs des paramètres à partir des méthodes getter
            preparedStatement.setInt(1, id);

            // Exécuter la requête
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Créer un objet Supplier à partir des résultats de la requête
                int supplierId = resultSet.getInt("Supplier_ID");
                int supplierNumber = resultSet.getInt("Supplier_Number");
                String lastname = resultSet.getString("lastname");
                String firstname = resultSet.getString("firstname");
                String mail = resultSet.getString("email");
                String address = resultSet.getString("address");
                supplier = new Supplier(supplierId, supplierNumber, lastname, firstname, mail, address);
            }
        } catch (SQLException e) {
            System.out.println("ERREUR : " + e);
        } finally {
            // Fermer les ressources
            Dao.closeResources(connection, preparedStatement, resultSet);
        }

        return supplier;
    }

    public static Supplier[] readAll() {
        return null;
    }

    public static int update(Supplier sup) {
        return 0;
    }

}
