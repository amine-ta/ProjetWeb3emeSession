/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMethodes;

import DAO.CommandeDAO;
import entite.Client;
import entite.Commande;
import entite.LigneCommande;
import entite.LigneCommandeId;
import entite.Produit;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 1895040
 */
public class GestionnaireCommande {

    private static Commande uneCommande;

    public static BigDecimal recupererDernierIDCommande() {
        BigDecimal increment;
        BigDecimal incrementor = new BigDecimal("1");

        Object obj = CommandeDAO.recupererDernierIDCommande();

        // S'il n'y a aucun client dans la BDD, on démarre les ID à 1001, sinon
        // on incrémente de 1 le dernier ID récupéré.
        if (obj != null) {
            increment = (BigDecimal) obj;
            increment = increment.add(incrementor);
        } else {
            increment = (new BigDecimal(5001));
        }

        return increment;
    }

    public static String obtenirTodayDate() {

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df.format(date);
        return dateString;
    }

    public static void creerNouvelleCommande(Client client) {

        Date date = new Date();
        BigDecimal noCommande = recupererDernierIDCommande();
        // On créé un construteur de type client
        uneCommande = new Commande(noCommande, client, date);
        // On appelle la fonction DAO qui va l'ajouter dans la BDD
        CommandeDAO.insert(uneCommande);
    }

//    public static void creerNouvelleLigneCommande(BigDecimal noCommande, Produit produit, Integer qte) {
//        LigneCommandeId ligneID = new LigneCommandeId(noCommande, produit.getIdproduit());
//
//        LigneCommande ligneCmd = new LigneCommande(ligneID, produit, qte);
//
//        CommandeDAO.insertLigne(ligneCmd);
//    }

}
