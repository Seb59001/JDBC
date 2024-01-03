/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MAIN;
//import DAO.Dao;

import DAO.SupplierDao;
import Modele.Supplier;
import java.util.List;
import java.util.Scanner;
import Main.menuSupplier;

/**
 *
 * @author legse
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        while (!quitter) {
            afficherMenuPrincipal();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Nettoyer la ligne en ajoutant une lecture supplémentaire
            System.out.println();

            switch (choix) {
                case 1:
                    // Appeler le menu user

                    break;
                case 2:
                    // Appeler le menu client

                    break;
                case 3:
                    // Appeler le menu Supplier
                    menuSupplier.runMenu();
                    break;
                case 4:
                    // Appeler le menu article

                    break;
                case 5:
                    quitter = true;
                    System.out.println("Merci d'avoir utilisé le programme. Au revoir !");
                    scanner.close();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
                    System.out.println();
                    break;
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("Menu Principal :");
        System.out.println("1. Gérer la table Utilisateurs");
        System.out.println("2. Gérer la table Clients");
        System.out.println("3. Gérer la table Fournisseurs");
        System.out.println("4. Gérer la table Articles");
        System.out.println("5. Quitter");
        System.out.print("Choisissez une option : ");
    }
}
