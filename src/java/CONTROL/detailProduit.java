package CONTROL;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DAO.ProduitDAO;
import JavaMethodes.GestionnaireProduit;
import entite.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import static javassist.CtMethod.ConstParameter.integer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mohamed Amine Tarhouni et Gian Gabriele Ciampa
 */
public class detailProduit extends HttpServlet {
    String action="/erreur.jsp";
    String nextJSP;
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
        
        action = request.getParameter("action");
         
    
  try{
      
       if(action!=null&&action.equals("detail"))
        {
           String idProduit = request.getParameter("id");
           Object obj = GestionnaireProduit.rechercheUnProduit(idProduit);

            session.setAttribute("detailProduit",obj );
            nextJSP = "/detailProduit.jsp";
        }
        
    
       else
        {
            
            List LiCategorie = GestionnaireProduit.rechercherToutesCategories();
            List LiMarque = GestionnaireProduit.rechercherToutesMarques();
            List LiProduit = GestionnaireProduit.rechercherTousProduits();
            
            session.setAttribute("count", ControPanier.count);
            session.setAttribute("ListPoduit", LiProduit);
            session.setAttribute("ListMarque", LiMarque);
            session.setAttribute("ListCategorie", LiCategorie);
            nextJSP = "/portail.jsp";
        }
        
      
      
  }  catch(Exception e){
    
  }    
    finally{
      
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
  }   
        
        
        
     
    
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
