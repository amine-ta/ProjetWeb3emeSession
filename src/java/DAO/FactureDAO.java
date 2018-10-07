/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gcia_
 */
public class FactureDAO
{
static Session session;

    private static void getOpenSession() throws HibernateException {

        session = util.HibernateUtil.getSessionFactory().openSession();
    }

    private static Transaction OpenSessionWithTransaction() {
        getOpenSession();

        Transaction tx = session.beginTransaction();
        return tx;
    }


      public static Object recupererDernierIDFacture() {
        getOpenSession();
        Object results = null;
        //Query query = session.createQuery("SELECT MAX(id) FROM Facture");
        //results = query.uniqueResult();
        session.close();
        return results;
    }    
}
