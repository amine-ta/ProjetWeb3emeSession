/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entite.Marque;
import entite.Produit;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mohamed Amine Tarhouni et Gian Gabriele Ciampa
 */
public class ProduitDAO {

    static Session session;

    private static void getOpenSession() throws HibernateException {

        session = util.HibernateUtil.getSessionFactory().openSession();
    }

    private static Transaction OpenSessionWithTransaction() {
        getOpenSession();

        Transaction tx = session.beginTransaction();
        return tx;
    }

    public static List<Produit> allProduit() {
        getOpenSession();
        Query query = session.createQuery(" from Produit");
        List<Produit> results = query.list();
        session.close();
        return results;
    }

    public static Produit getSingleProduit(BigDecimal idproduit) {
        try{
        getOpenSession();
        Query query = session.createQuery("FROM Produit P WHERE P.idproduit= :ClientID ");
        query.setParameter("ClientID", idproduit);

        Produit results = (Produit)query.uniqueResult();
        return results;
        }
        catch(Exception e){
        }
        finally{
        session.close();  
        }
        return null;
    }
    
    public static List<Produit> getProduitParMarque()
            { 
            
           Criteria criteria = session.createCriteria(Produit.class,"produit").createAlias("produit.marque","produ").add(Restrictions.eq("produit.nom", "Mutant"));
            List list = criteria.list();
           
   
//        getOpenSession();
//        Query query = session.createQuery("FROM Produit P INNER JOIN P.marque M "
//                                            + "WHERE M.nom = :NOMMARQUE ");
//        
//        query.setParameter("NOMMARQUE",marque);
//        List<Produit> results = query.list();
//        session.close();
        return list;
  
    }
    
    public static List<Produit> getProduitParCategorie(String categorie)
    {
        getOpenSession();
        Query query = session.createQuery("FROM Produit P INNER JOIN P.categorie C "
                                            + "WHERE C.nomcategorie = :NOMCATEGORIE ");
        
        query.setParameter("NOMCATEGORIE",categorie);
        List<Produit> results = query.list();
        session.close();
        return results;
  
    }
    
    public static void updateQteStock(Produit produit, Integer quantiteEnStock)
    {
        try
        {
            Transaction tx = OpenSessionWithTransaction();
            produit.setQuantiteenstock(quantiteEnStock);
            session.update(produit);
            tx.commit();
        }
        catch(Exception e){
        }
        finally{
        session.close();  
        }
       
       
    }  
    
        
    
}