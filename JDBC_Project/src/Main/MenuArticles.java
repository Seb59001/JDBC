/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import DAO.ArticleDao;
import Modele.Article;
import java.util.Scanner;

/**
 *
 * @author Romain
 */
public class MenuArticles {
    
    public static void run(){
    System.out.println("Consulter les articles : ");
        
    Scanner scanner = new Scanner(System.in);

        boolean again = true;

        while(again){
            System.out.println("Menu:");
            System.out.println("1. Inserer un article");
            System.out.println("2. Lire tous les articles");
            System.out.println("3. Lire un article");
            System.out.println("4. Modifier un article");
            System.out.println("5. Supprimer un article");
            System.out.println("0. Quitter");
            
            boolean state = false;
            boolean verifAnswer = false;
            int searchArticleNumber = 0;
            if(scanner.hasNextInt()){
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addMenu();
                        break;
                    case 2:
                        ArticleDao.readAll();
                        break;
                    case 3:
                        System.out.println("Quel numéro article souhaitez vous consulter ? ");
                        if(scanner.hasNextInt()){
                            int choiceDisplayArticle = scanner.nextInt();
                            ArticleDao.readOne(choiceDisplayArticle);
                        } else {
                            System.out.println("Aucun numéro d'article ne coresspond à votre demande.");
                            scanner.next();
                        }
                        break;
                    case 4:
                        System.out.println("Quel est le numéro de l'article que vous souhaitez modifier ? ");
                        if(scanner.hasNextInt()){
                            searchArticleNumber = scanner.nextInt();
                            if(ArticleDao.selectOne(searchArticleNumber)){
                                updateMenu(searchArticleNumber);
                            } else {
                                System.out.println("Désolé, cet article n'est pas présent dans la bdd");
                            }
                        } else {
                            System.out.println("Merci de saisir un numéro d'article");
                        }
                        break;
                    case 5:
                        System.out.println("Quel numéro d'article souhaitez vous consulter ? ");
                        int choiceDeleteArticle = scanner.nextInt();
                        ArticleDao.delete(choiceDeleteArticle);
                        break;
                    case 0:
                        System.out.println("Au revoir!");
                        again = false;
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                } 
            } else {
                System.out.println("Merci de saisir un chiffre coresspondant au choix du menu");  
                scanner.next();
            }
        }
    }
    
    private static void addMenu() {
        
        Scanner scanner = new Scanner(System.in);
        boolean state = false;
        boolean verifAnswer = false;
        boolean verifNumber = false;
        int articleNumber = 0;
        String stateAnswer = null;
        
        
        System.out.println("Titre de l'article : ");
        String lastname = scanner.next();
        while(verifLength(lastname)){
            System.out.println("Titre de l'article : ");
            lastname = scanner.next();
        }
        
        while(!verifNumber){
            System.out.println("Numéro de l'article :");
            if(scanner.hasNextInt()){
                articleNumber = scanner.nextInt();
                if(ArticleDao.selectOne(articleNumber)){
                    System.out.println("Désolé, un article à déja ce numéro, merci de saisir un nouveau numéro d'article..");
                } else {
                    verifNumber = true;
                }
            } else {
                System.out.println("Merci de saisir un nombre : ");
                scanner.next();
            }
        }
        
        System.out.println("Description : ");
        String description = scanner.next();
        while(verifLength(description)){
            System.out.println("Description : ");
            description = scanner.next();
        }
        while(!verifAnswer){
            System.out.println("Article acheté ? (oui/non) ");
            stateAnswer = scanner.next().toLowerCase();
            if(stateAnswer.equals("oui")){
                state = true;
                verifAnswer = true;
            } else if (stateAnswer.equals("non")){
                state = false;
                verifAnswer = true;
            } else {
                System.out.println("Erreur de saisie, saisir \"oui\" ou \"non\".");
            } 
        }
        Article art = new Article(articleNumber, lastname.trim(), description.trim(), state);
        ArticleDao.add(art);
    }
    
    private static void updateMenu(int searchArticleNumber){
        
        Scanner scanner = new Scanner(System.in);
        boolean state = false;
        boolean verifAnswer = false;
        String stateAnswer = null;
        String lastname = null;
        String description = null;
        
        
        System.out.println("Titre de l'article : ");
        lastname = scanner.next();
        while(verifLength(lastname)){
            System.out.println("Titre de l'article : ");
            lastname = scanner.next();
        }
     
        System.out.println("Description : ");
        description = scanner.next();
        while(verifLength(description)){
            System.out.println("Description : ");
            description = scanner.next();
        }
        while(!verifAnswer){
         
            System.out.println("Article acheté ? (oui/non) ");
            stateAnswer = scanner.next().toLowerCase();

            if(stateAnswer.equals("oui")){
                state = true;
                verifAnswer = true;
            } else if (stateAnswer.equals("non")){
                state = false;
                verifAnswer = true;
            } else {
                System.out.println("Erreur de saisie, saisir \"oui\" ou \"non\".");
            } 
        }
        
        ArticleDao.update(lastname.trim(), description.trim(), state, searchArticleNumber);
    }
    
    private static Boolean verifLength(String str){
        if(str.length() < 2 ){
            System.out.println("Erreur de saisie, minimun 2 caractères.");
            return true;
        } else {
            return false;
        }
        
    }
}
