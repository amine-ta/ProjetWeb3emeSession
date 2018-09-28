/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMethodes;

import DAO.CommandeDAO;
import DAO.MarqueDAO;
import DAO.ProduitDAO;
import DAO.categorieDAO;
import entite.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Mohamed Amine Tarhouni et Gian Gabriele Ciampa
 */
public class GestionnaireProduit
        
{  static public double TPS =0.05;
   static public double TVQ =0.09975; 
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
    
    public static String getTotalApresTAXE(Vector buylist){
  //on va calculer le prix total
      double total =0,totalTaxeTPS=0,totalTaxeTVQ;
      
      total = getSousTotal(buylist);
      
      totalTaxeTPS = getMontantTPS(total);
      totalTaxeTVQ = getMontantTVQ(total);
      total = total + totalTaxeTPS + totalTaxeTVQ;
      
      String amount = new Float(total).toString();
      int n = amount.indexOf('.');
      amount = amount.substring(0,n+3);      
      return amount ;
      
            }    
    
    
    public static double getSousTotal(Vector buylist){
  //on va calculer le prix total
      double sstotal =0;
    
      for (int i=0; i< buylist.size();i++) {
        LigneCommande anOrder = (LigneCommande) buylist.elementAt(i);
        double price= anOrder.getProduit().getPrix().doubleValue();
        
        int qty = anOrder.getQuantite();
        sstotal += (price * qty);
      }
      
      return sstotal ;
      
            }    
    
    public static double getMontantTPS(double total)
    {
        double montantTPS = total * TPS;
        return montantTPS;
    }
    
    public static String getStrMontantTPS(double mntTPS)
    {
        String montantTPS = new Float(mntTPS).toString();
        int n = montantTPS.indexOf('.');
        montantTPS = montantTPS.substring(0,n+3); 
        return montantTPS;
    }
    
    public static double getMontantTVQ(double total)
    {
        double montantTVQ = total * TVQ;
        return montantTVQ;
    }
    
    public static String getStrMontantTVQ(double mntTVQ)
    {
        String montantTVQ = new Float(mntTVQ).toString();
        int n = montantTVQ.indexOf('.');
        montantTVQ = montantTVQ.substring(0,n+3); 
        return montantTVQ;
    } 
    
    public static String getValeurTPS()
    {
        DecimalFormat dc = new DecimalFormat("###.###");
        
        
        String valTPS = dc.format(TPS*100);
        valTPS = valTPS+"%";
        return valTPS;
    }
    
    public static String getValeurTVQ()
    {
        DecimalFormat dc = new DecimalFormat("###.###");
        String valTVQ = dc.format(TVQ*100);
        valTVQ = valTVQ+"%";
        return valTVQ;
    }
    
    
    
}
