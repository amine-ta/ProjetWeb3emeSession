/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entite.Produit;

/**
 *
 * @author utilisateur
 */
public interface IGestionnaireProduit {
    Object getSingleProduit(String Item);
    boolean verifierQuantiteProduitDansBDD(String IdItem,String quantite);
}
