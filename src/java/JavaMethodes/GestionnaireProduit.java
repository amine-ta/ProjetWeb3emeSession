/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMethodes;

import DAO.MarqueDAO;
import DAO.ProduitDAO;
import DAO.categorieDAO;
import entite.*;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Mohamed Amine Tarhouni et Gian Gabriele Ciampa
 */
public class GestionnaireProduit
{
    
    public static Object rechercheUnProduit(String produitId)
    {
        Integer id = Integer.valueOf(produitId);
        Produit pro = ProduitDAO.getSingleProduit(new BigDecimal(id));
        
        return pro;
    }
    
    public static List rechercherTousProduits()
    {
        return ProduitDAO.allProduit();
    }
    
    public static List rechercherToutesMarques()
    {
        return MarqueDAO.getAllMarque();
    }
    
    public static List rechercherToutesCategories()
    {
        return categorieDAO.getAllCategorie();
    }
    
    public static void modifierQuantiteEnStockProduit(Produit produit, Integer qteEnStock)
    {
        ProduitDAO.updateQteStock(produit, qteEnStock);
       
    }
    
    public static List rechercherProduitParMarque()
    {
        return ProduitDAO.getProduitParMarque();
    }
    
    public static List rechercherProduitParCategorie(String categorie)
    {
        return ProduitDAO.getProduitParCategorie(categorie);
    }
    
}
