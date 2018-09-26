/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import JavaMethodes.GestionnaireProduit;
import entite.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1895088
 */
public class init extends HttpServlet {

    String nextJSP;
    List LiCategorie;
    List LiMarque;
    List LiProduit;
    ServletContext application ;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 


    HttpSession session = request.getSession();
        
      //  application = request.getSession().getServletContext();
        LiCategorie = GestionnaireProduit.rechercherToutesCategories();
        LiMarque = GestionnaireProduit.rechercherToutesMarques();
        LiProduit = GestionnaireProduit.rechercherTousProduits();
        session.setAttribute("count", ControPanier.count);
        session.setAttribute("ListPoduit", LiProduit);
        session.setAttribute("ListMarque", LiMarque);
        session.setAttribute("ListCategorie", LiCategorie);  
        
        nextJSP = "/portail.jsp";
        session.setAttribute("PageCourante","/portail.jsp");
        String language = request.getParameter("language");
        List<Produit> ALlProduit =new ArrayList();
        List<String> AllNameProduit=new ArrayList<>();
        
        ALlProduit = GestionnaireProduit.rechercherTousProduits();
        
        for(Produit nom :ALlProduit){
             AllNameProduit.add(nom.getNomproduit());
        }
              
        
        
         
         
        if (language != null)
        {    
            session.setAttribute("langueCourante", language);
            if (language.equalsIgnoreCase("fr_CA"))
            {
                session.setAttribute("motEpuise","Épuisé");
                session.setAttribute("motDispo","Disponible");
            }
            else if (language.equalsIgnoreCase("en_CA"))
            {
                session.setAttribute("motEpuise","Out of Stock");
                session.setAttribute("motDispo","Available");
            }
            else
            {
                session.setAttribute("motEpuise","Esaurito");
                session.setAttribute("motDispo","Disponibile");
            } 
        }
        else // Mettre la langue par défaut à "fr_CA"
        {
            session.setAttribute("motEpuise","Épuisé");
            session.setAttribute("motDispo","Disponible");
        }    
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
       
}
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
