/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.CommandeDAO.session;
import entite.LigneCommande;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrateur
 */
public class DAOLigneDeCommande {

    static Session session;

    private static void getOpenSession() throws HibernateException {

        session = util.HibernateUtil.getSessionFactory().openSession();
    }

    private static Transaction OpenSessionWithTransaction() {
        getOpenSession();
        Transaction tx = session.beginTransaction();
        return tx;
    }

    public static void insertLigneCommande(LigneCommande ligneCmd) {
        Transaction tx = OpenSessionWithTransaction();
        session.save(ligneCmd);
        tx.commit();
        session.close();

    }

}
