/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author legse
 */

import DAO.ClientDao;
import Modele.Client;

import java.util.List;
import java.util.Scanner;

public class MenuClient {

     /**
     * Méthode principale pour exécuter le menu de gestion des clients.
     */
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        
        // Boucle pour afficher le menu et traiter les choix de l'utilisateur
        while (true) {
            System.out.println("\nMenu Clients");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Supprimer un client");
            System.out.println("3. Lire un client par ID");
            System.out.println("4. Lire tous les clients");
            System.out.println("5. Mettre à jour un client");
            System.out.println("0. Retourner au menu principal");
            System.out.print("Choisissez une option (0-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            // Utilisation d'une structure switch pour gérer les différentes options du menu
            switch (choice) {
                case 1:
                    addClient(scanner);
                    break;
                case 2:
                    deleteClient(scanner);
                    break;
                case 3:
                    readClientById(scanner);
                    break;
                case 4:
                    readAllClients();
                    break;
                case 5:
                    updateClient(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

        /**
     * Méthode pour lire un client par ID.
     * Appel de la méthode readById de la classe ClientDao au sein de la méthode
     */
    private static void readClientById(Scanner scanner) {
        System.out.print("Saisissez l'ID du client que vous souhaitez consulter : ");
        int clientIdToRead = scanner.nextInt();
        Client clientById = ClientDao.readById(clientIdToRead);
        if (clientById != null) {
            System.out.println("Informations sur le client " + clientById);
        } else {
            System.out.println("Client non trouvé avec l'id " + clientIdToRead);
        }
    }

     /**
     * Méthode pour afficher tous les clients.
     * Avec appel de la méthode readAll de la classe ClientDao
     */
    private static void readAllClients() {
        List<Client> allClients = ClientDao.readAll();
        for (Client client : allClients) {
            System.out.println(client);
        }
    }
    
     /**
     * Méthode pour supprimer un client par ID.
     * Avec appel de la méthode delete de la classe ClientDao
     */
    private static void deleteClient(Scanner scanner) {
    System.out.print("Saisissez l'ID du client que vous souhaitez supprimer : ");
    int clientIdToDelete = scanner.nextInt();
    int result = ClientDao.delete(clientIdToDelete);
    if (result != -1) {
        System.out.println("Client supprimé avec succès !");
    } else {
        System.out.println("Échec de la suppression du client.");
    }
}
    
    
    
    /**
     * Méthode pour mettre à jour un client.
     * Avec appel de la méthode update de la classe ClientDao
     */
    private static void updateClient(Scanner scanner) {
    System.out.print("Saisissez l'ID du client que vous souhaitez mettre à jour : ");
    int clientIdToUpdate = scanner.nextInt();
    scanner.nextLine(); // Pour consommer la nouvelle ligne

    // Lire les informations actuelles du client à partir de la base de données
    Client clientToUpdate = ClientDao.readById(clientIdToUpdate);

    if (clientToUpdate != null) {
        System.out.println("Anciennes informations du client : " + clientToUpdate);

        // Booléen indiquant si la mise à jour du client est terminée ou non
        boolean updateCompleted = false;

        while (!updateCompleted) {
            // Affichez un menu pour demander quels champs l'utilisateur souhaite mettre à jour
            System.out.println("\nSélectionnez les champs à mettre à jour :");
            System.out.println("1. Numéro du client");
            System.out.println("2. Nom du client");
            System.out.println("3. Prénom du client");
            System.out.println("4. Email du client");
            System.out.println("5. Adresse du client");
            System.out.println("0. Annuler et quitter la mise à jour");

            System.out.print("Choisissez une option (0-5) : ");
            int updateChoice = scanner.nextInt();
            scanner.nextLine();

            switch (updateChoice) {
                case 1:
                    System.out.print("Nouveau numéro du client : ");
                    int newClientNumber = scanner.nextInt();
                    clientToUpdate.setClientNumber(newClientNumber);
                    break;
                case 2:
                    String newLastname;
                    do {
                        System.out.print("Nouveau nom du client : ");
                        newLastname = scanner.nextLine().trim();
                        if (newLastname.isEmpty()) {
                            System.out.println("Erreur : Le nom ne peut pas être vide. Veuillez réessayer.");
                        }
                    } while (newLastname.isEmpty());
                    clientToUpdate.setLastname(newLastname);
                    break;
                case 3:
                    String newFirstname;
                    do {
                        System.out.print("Nouveau prénom du client : ");
                        newFirstname = scanner.nextLine().trim();
                        if (newFirstname.isEmpty()) {
                            System.out.println("Erreur : Le prénom ne peut pas être vide. Veuillez réessayer.");
                        }
                    } while (newFirstname.isEmpty());
                    clientToUpdate.setFirstname(newFirstname);
                    break;
                case 4:
                    String newEmail;
                    do {
                        System.out.print("Nouvel email du client : ");
                        newEmail = scanner.nextLine().trim();
                        if (newEmail.isEmpty()) {
                            System.out.println("Erreur : L'email ne peut pas être vide. Veuillez réessayer.");
                        } else if (!isValidEmail(newEmail)) {
                            System.out.println("Erreur : Le format de l'email n'est pas valide. Veuillez réessayer.");
                        }
                    } while (newEmail.isEmpty() || !isValidEmail(newEmail));
                    clientToUpdate.setEmail(newEmail);
                    break;
                case 5:
                    String newAddress;
                    do {
                        System.out.print("Nouvelle adresse du client : ");
                        newAddress = scanner.nextLine().trim();
                        if (newAddress.isEmpty()) {
                            System.out.println("Erreur : L'adresse ne peut pas être vide. Veuillez réessayer.");
                        }
                    } while (newAddress.isEmpty());
                    clientToUpdate.setAddress(newAddress);
                    break;
                case 0:
                    System.out.println("Mise à jour annulée.");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }

            System.out.print("Voulez-vous mettre à jour un autre champ ? (O/N) : ");
            // Récupère la réponse de l'utilisateur en convertissant les espaces inutiles, met en majuscules pour une comparaison insensible à la casse
            String continueUpdate = scanner.nextLine().trim().toUpperCase();

            // Vérifie si l'utilisateur ne souhaite pas continuer la mise à jour en comparant la réponse à "O" (non-insensible à la casse)
            if (!continueUpdate.equals("O")) {
                updateCompleted = true;
            }
        }

        // Appelez la méthode update du ClientDao
        int result = ClientDao.update(clientToUpdate);
        if (result != -1) {
            System.out.println("Client mis à jour avec succès !");
        } else {
            System.out.println("Échec de la mise à jour du client.");
        }
    } else {
        System.out.println("Client non trouvé avec l'ID " + clientIdToUpdate);
    }
}

    
    
    /**
     * Méthode pour ajouter un nouveau client.
     * Avec appel de la méthode add de la classe ClientDao
     */
    private static void addClient(Scanner scanner) {
    int clientNumber;
    String lastName, firstName, email, address;

    // Saisir le numéro du client
    System.out.print("Numéro du client : ");
    clientNumber = scanner.nextInt();
    scanner.nextLine(); // Pour consommer la nouvelle ligne

    // Saisir le nom du client
    do {
        System.out.print("Nom du client : ");
        lastName = scanner.nextLine().trim();

        if (lastName.isEmpty()) {
            System.out.println("Erreur : Le nom ne peut pas être vide. Veuillez réessayer.");
        }
    } while (lastName.isEmpty());

    // Saisir le prénom du client
    do {
        System.out.print("Prénom du client : ");
        firstName = scanner.nextLine().trim();

        if (firstName.isEmpty()) {
            System.out.println("Erreur : Le prénom ne peut pas être vide. Veuillez réessayer.");
        }
    } while (firstName.isEmpty());

    // Saisir l'email du client
    do {
        System.out.print("Email du client : ");
        email = scanner.nextLine().trim();

        if (email.isEmpty()) {
            System.out.println("Erreur : L'email ne peut pas être vide. Veuillez réessayer.");
        } else if (!isValidEmail(email)) {
            System.out.println("Erreur : Le format de l'email n'est pas valide. Veuillez réessayer.");
        }
    } while (email.isEmpty() || !isValidEmail(email));

    // Saisir l'adresse du client
    do {
        System.out.print("Adresse du client : ");
        address = scanner.nextLine().trim();

        if (address.isEmpty()) {
            System.out.println("Erreur : L'adresse ne peut pas être vide. Veuillez réessayer.");
        }
    } while (address.isEmpty());

    // Création d'un nouvel objet Client avec les informations saisies
    Client newClient = new Client(clientNumber, lastName, firstName, email, address);

    // Appelez la méthode add du ClientDao
    int result = ClientDao.add(newClient);
    if (result != -1) {
        System.out.println("Client ajouté avec succès !");
    } else {
        System.out.println("Échec de l'ajout du client.");
    }
}
    
    
    
    
    
    // Ajouter cette méthode pour vérifier le format de l'email
    private static boolean isValidEmail(String email) {
        // Utilisez une expression régulière simple pour vérifier le format de l'email
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        return email.matches(emailRegex);
    }
}

