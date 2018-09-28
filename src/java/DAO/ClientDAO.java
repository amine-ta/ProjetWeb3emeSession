/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entite.Client;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mohamed Amine Tarhouni et Gian Gabriele Ciampa 
 */
public class ClientDAO {

    static Session session;

    private static void getOpenSession() throws HibernateException {

        session = util.HibernateUtil.getSessionFactory().openSession();
    }

    private static Transaction OpenSessionWithTransaction() {
        getOpenSession();

        Transaction tx = session.beginTransaction();
        return tx;
    }

    public static List<Client> allClient() {
        getOpenSession();
        Query query = session.createQuery(" from Client");
        List<Client> results = query.list();
        session.close();
        return results;
    }

    public static Object recupererDernierID() {
        getOpenSession();
        Query query = session.createQuery("SELECT MAX(idclient) FROM Client");
        Object results = query.uniqueResult();
        session.close();
        return results;
    }
    
    public static Client rechercherCourriel(String courriel)
    {
        getOpenSession();
        Query query = session.createQuery("FROM Client " +
                                          "WHERE UPPER(couriel) = :emailrecherche");
       
        query.setParameter("emailrecherche",courriel.toUpperCase());
        Client results = (Client)query.uniqueResult();
        session.close();
        return results;
    }
    
    
    public static void insert(Client client)
    {
         
       Transaction tx = OpenSessionWithTransaction();
       
       session.save(client);
       
       tx.commit();
       
       session.close();
       
    }
    
    
    
    
    
}
