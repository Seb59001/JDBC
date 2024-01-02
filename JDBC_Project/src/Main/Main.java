/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MAIN;
//import DAO.Dao;

import DAO.SupplierDao;
import Modele.Supplier;

/**
 *
 * @author legse
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;

        //Dao db = new Dao();
        //db.connectDatabase();
        System.out.println("Creating Toto");
        Supplier toto = new Supplier(112, "Doe", "Jane", "doejane@gmail.com", "2 rue Vauban");
        System.out.println("Adding to Database");
        i = SupplierDao.add(toto);
        if (i == -1) {
            System.out.println("Adding failed");
        } else {
            System.out.println("Added (" + i + " records)");
        }

        //-----------------------------
        System.out.println("Deleting id 5");
        i = SupplierDao.delete(5);
        if (i == -1) {
            System.out.println("Deleting failed");
        } else {
            System.out.println("Deleted (" + i + " records)");
        }

        System.out.println(toto);

        //----------------------------
        System.out.println("Selecting id 10");
        Supplier sup = SupplierDao.readById(1);
        System.out.println(sup);
        if (sup != null) {
            System.out.println("Fournisseur trouvé :");
        } else {
            System.out.println("Aucun fournisseur trouvé avec l'ID 10");
        }

    }

}
