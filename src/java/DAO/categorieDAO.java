/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import entite.Categorie;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 1895088
 */
public class categorieDAO {
    static Session session;
    

    private static void getOpenSession() throws HibernateException {

        session = util.HibernateUtil.getSessionFactory().openSession();
    }

    private static Transaction OpenSessionWithTransaction() {
        getOpenSession();

        Transaction tx = session.beginTransaction();
        return tx;
    }
    
    
    public static List<Categorie> getAllCategorie(){
        
        List listCategorie;
        try{
            getOpenSession();
            Query query = session.createQuery(" from Categorie");
            List<Categorie> results = query.list();
            return results;
            
        }catch (Exception e){
            System.out.println("Trace exception"+e.getMessage());
        }
        finally{
            session.close();
        }
        return null;
    }
    
}
