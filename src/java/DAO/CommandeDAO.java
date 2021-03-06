/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.ClientDAO.session;
import entite.Commande;
import entite.LigneCommande;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 1895040
 */
public class CommandeDAO {
    
    static Session session;

    private static void getOpenSession() throws HibernateException {

        session = util.HibernateUtil.getSessionFactory().openSession();
    }

    private static Transaction OpenSessionWithTransaction() {
        getOpenSession();

        Transaction tx = session.beginTransaction();
        return tx;
    }
    
    
    public static Object recupererDernierIDCommande() {
        getOpenSession();
        Query query = session.createQuery("SELECT MAX(nocommande) FROM Commande");
        Object results = query.uniqueResult();
        session.close();
        return results;
    }
    
    
    public static void insert(Commande commande)
    {
        Transaction tx = OpenSessionWithTransaction();
        session.save(commande);
        tx.commit();
       
       session.close();
        
    }
    
     public static void insertLigne(LigneCommande ligneCmd)
    {
        Transaction tx = OpenSessionWithTransaction();
        session.save(ligneCmd);
        tx.commit();
       
       session.close();
        
    }
}




    