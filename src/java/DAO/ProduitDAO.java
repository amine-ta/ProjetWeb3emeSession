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
import org.hibernate.sql.JoinType;

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

    public static List allProduit() {
   
            getOpenSession();
            Query query = session.createQuery(" from Produit where ROWNUM <= 12");
            List results = query.list();
            
     
            session.close();
            return results;

    }

    public static Produit getSingleProduit(BigDecimal idproduit) {
        try {
            getOpenSession();
            Query query = session.createQuery("FROM Produit P WHERE P.idproduit= :ClientID ");
            query.setParameter("ClientID", idproduit);
            Produit results = (Produit) query.uniqueResult();
            return results;
        } catch (Exception e) {
        } finally {
            session.close();

        }
        return null;
    }
    
    public static List rechercheProduitParPrix(BigDecimal prixMin, BigDecimal prixMax) {
        try {
            Query query;
            getOpenSession();
            if (!prixMin.equals(prixMax))
            {
                query = session.createQuery("FROM Produit WHERE prix >= :MIN AND prix < :MAX ");
                query.setParameter("MIN", prixMin);
                query.setParameter("MAX", prixMax);
            }
            else
            {
                query = session.createQuery("FROM Produit WHERE prix >= :MAX ");
                query.setParameter("MAX", prixMax);
            }
            
            List results = query.list();
            return results;
        } catch (Exception e) {
        } finally {
            session.close();

        }
        return null;
    }
    
   
    public static List getProduitParMarque(String nom) {

        try {
            getOpenSession();
            Criteria criteria = session.createCriteria(Produit.class).createAlias("marque", "mar").add(Restrictions.eq("mar.nom", nom));
            List produit = criteria.list();
            return produit;
        } catch (Exception ex) {

        } finally {
            session.close();

        }
        return null;

    }

    public static List getProduitParCategorie(String categorie) {

        try {
            getOpenSession();
            Criteria criteria = session.createCriteria(Produit.class).createAlias("categorie", "cat").add(Restrictions.eq("cat.nomcategorie", categorie));
            List produit = criteria.list();
            return produit;
        } catch (Exception ex) {

        } finally {
            session.close();
        }
        return null;

    }

    public static void updateQteStock(Produit produit, Integer quantiteEnStock) {
        try {
            Transaction tx = OpenSessionWithTransaction();
            produit.setQuantiteenstock(quantiteEnStock);
            session.update(produit);
            tx.commit();
        } catch (Exception e) {
        } finally {
            session.close();
        }

    }

}
