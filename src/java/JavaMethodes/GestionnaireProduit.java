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
 
            List produit =ProduitDAO.allProduit(); 
             return produit;

    }
    
    public static List rechercherToutesMarques()
    {
        List marque = MarqueDAO.getAllMarque();
       // util.HibernateUtil.getSessionFactory().close();
        return marque;
    }
    
    public static List rechercherToutesCategories()
    {
        List categorie = categorieDAO.getAllCategorie();
        return categorie;
    }
    
    public static void modifierQuantiteEnStockProduit(Produit produit, Integer qteEnStock)
    {
        ProduitDAO.updateQteStock(produit, qteEnStock);
       
    }
    
    public static List rechercherProduitParMarque(String _nomMarque)
    {   List Produit =ProduitDAO.getProduitParMarque(_nomMarque);
        //util.HibernateUtil.getSessionFactory().close();
        return Produit;
    }
    
    public static List rechercherProduitParCategorie(String categorie)
    {
        List Produit =ProduitDAO.getProduitParCategorie(categorie);
       // util.HibernateUtil.getSessionFactory().close();
        return Produit;
    }
    
}
