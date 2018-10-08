/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import DAO.DAOLigneDeCommande;
import JavaMethodes.GestionnaireClient;
import JavaMethodes.GestionnaireCommande;
import entite.Client;
import entite.LigneCommande;
import entite.LigneCommandeId;
import entite.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class ControlPaiement extends HttpServlet {
Client client = null;
String motDePasse = "";
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

            
        String action = request.getParameter("action");
         HttpSession session = request.getSession();
        if(action.equals("PayerCommande")){
            
            BigDecimal noComm=(BigDecimal)session.getAttribute("noCommande");
            client = GestionnaireClient.getUnClient();
            GestionnaireCommande.creerNouvelleCommande(client);
            
            Vector<LigneCommande> Panier=(Vector)session.getAttribute("shoppingcart");
            for(int i=0;i<Panier.size();i++){
                Panier.get(i).getQuantite();
                LigneCommandeId ligneId= new LigneCommandeId(noComm,Panier.get(i).getProduit().getIdproduit());
                LigneCommande uneLigneCommande = new LigneCommande(ligneId,Panier.get(i).getProduit(),Panier.get(i).getQuantite());
                DAOLigneDeCommande.insertLigneCommande(uneLigneCommande);
            }
            
         String NextPage="/FinAchat.jsp"; 
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(NextPage);
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
