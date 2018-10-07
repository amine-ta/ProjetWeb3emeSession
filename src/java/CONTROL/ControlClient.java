/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import JavaMethodes.GestionnaireClient;
import JavaMethodes.GestionnaireCommande;
import entite.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrateur
 */
public class ControlClient extends HttpServlet {
        String action;
        String NextPage;
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
         action =request.getParameter("action");
         
         if(action.equals("CreerClient")&& action!=null){
             
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String telephone = request.getParameter("telephone");
        String nocivique = request.getParameter("nocivique");
        String noapp = request.getParameter("noapp");
        String rue = request.getParameter("rue");
        String ville = request.getParameter("ville");
        String province = request.getParameter("province");
        String pays = request.getParameter("pays");
        String courriel = request.getParameter("courriel");
        String motdepasse = request.getParameter("motdepasse");
 
        Client client = GestionnaireClient.creerClient(prenom,nom,telephone,nocivique,noapp,rue,ville,province,pays,courriel,motdepasse);     
        GestionnaireCommande.creerNouvelleCommande(client);  
        
        request.setAttribute("nouveauclientnom", nom);
        request.setAttribute("nouveauclientprenom", prenom);
        session.setAttribute("PageCourante","/checkout.jsp");
            
         }
         
         else if(action.equals("clientExist")&& action!=null) {
  
         
         
         Vector buylist = (Vector) session.getAttribute("shoppingcart");
         session.setAttribute("shoppingcart", buylist);
         session.setAttribute("PageCourante","/checkout.jsp");
         String boncourriel = (String)request.getAttribute("boncourriel");
         session.setAttribute("boncourriel", boncourriel);
         
                  
         }
         
         
         NextPage="/checkout.jsp"; 
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(NextPage);
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
