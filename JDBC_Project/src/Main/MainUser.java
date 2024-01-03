package Main;

import DAO.UserDao;
import Modele.User;

import java.util.Scanner;

public class MainUser {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quitter = false;

        while (!quitter) {
            System.out.println("=== Menu Utilisateur ===");
            System.out.println("1. Afficher mes informations");
            System.out.println("2. Mettre à jour mes informations");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne après nextInt()

            switch (choix) {
                case 1:
                    afficherMesInformations();
                    break;
                case 2:
                    mettreAJourMesInformations();
                    break;
                case 3:
                    quitter = true;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;
            }
        }

        System.out.println("Fin du menu utilisateur.");
    }

    private static void afficherMesInformations() {
        // méthode pour afficher les informations de l'utilisateur
        // en utilisant la classe UserDao.
        System.out.print("Entrez l'ID de l'utilisateur : ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne après nextInt()

        User currentUser = UserDao.getUserById(userId);
        if (currentUser != null) {
            System.out.println("Mes informations : " + currentUser);
        } else {
            System.out.println("Utilisateur introuvable.");
        }
    }

    private static void mettreAJourMesInformations() {
        // Exemple de déclaration de variables pour la mise à jour d'un utilisateur
        int userId = 1; // Remplacez cette valeur par la logique qui vous permet d'obtenir l'ID de l'utilisateur à mettre à jour

        int newNumber = 12345;
        String newLogin = "nouveauLogin";
        String newPassword = "nouveauMotDePasse";
        String newLastname = "nouveauNom";
        String newFirstname = "nouveauPrenom";
        String newEmail = "nouveau@mail.com";

        // Créer l'objet User mis à jour
        User updatedUser = new User(userId, newNumber, newLogin, newPassword, newLastname, newFirstname, newEmail);

        // Appeler la méthode update de UserDao
        UserDao.updateUser(updatedUser);

        System.out.println("Informations mises à jour avec succès !");
    }
}
