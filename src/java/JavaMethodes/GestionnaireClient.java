/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMethodes;

import DAO.ClientDAO;
import entite.Client;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Mohamed Amine Tarhouni et Gian Gabriele Ciampa
 */
public class GestionnaireClient {
    static Client  unClient;

    public static Client getUnClient() {
        return unClient;
    }
    
    // Méthode qui va ajouter un nouveau client à la table Client sur la BDD
    public static Client creerClient(String prenom,String nom,String telephone,String nocivique,String noapp,String rue,String ville,String province,
                                     String pays, String courriel,String mdp)
    {
        BigDecimal increment;
        BigDecimal incrementor = new BigDecimal("1");
 
        // On récupère le dernier ID créé dans la BDD
        Object obj = ClientDAO.recupererDernierID();
       
        
        // S'il n'y a aucun client dans la BDD, on démarre les ID à 1001, sinon
        // on incrémente de 1 le dernier ID récupéré.
        if (obj != null)
        {
           increment = (BigDecimal)obj;
           increment = increment.add(incrementor);
        }
        else
           increment = (new BigDecimal(1001));
 
        // On créé un construteur de type client
      
        unClient = new Client(increment,nom,prenom,courriel,mdp,telephone,nocivique,noapp,rue,ville,province,pays);
      
        // On appelle la fonction DAO qui va l'ajouter dans la BDD
        ClientDAO.insert(unClient);
        
        return unClient;
    }
    
    // Méthode qui recherche le courriel dans la BDD
    public static boolean rechercherCourriel(String courriel)
    {
       Client client = ClientDAO.rechercherCourriel(courriel);
  
       // Si la taille est différente de 0, alors il y a déjà un client avec ce courriel
       if (client == null)
              return false;
        else
              return true;
    }
    
    //Méthode qui récupère un client dans la BDD via son email
    public static Client recuperClient(String courriel)
    {
        Client client = ClientDAO.rechercherCourriel(courriel);
        return client;
    }
            
   
    //Méthode qui va valider le mot de passe pour l'authentification d'un client existant
    public static boolean confirmerMotDePasse(String courriel,String mdp)
    {
       Client client = ClientDAO.rechercherCourriel(courriel);
  
            
       if (client.getMotdepasse().equals(mdp))
              return true;
        else
              return false;
    }
    
     public static Client ConfirmerClient(String courriel,String mdp)
    {
       Client client = ClientDAO.rechercherCourriel(courriel);
  
            
       if (client.getMotdepasse().equals(mdp))
              return client;
        else
              return null;
    }
    
}
