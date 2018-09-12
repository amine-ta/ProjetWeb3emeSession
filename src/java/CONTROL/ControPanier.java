/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import DAO.ProduitDAO;
import entite.LigneCommande;
import entite.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mohamed Amine Tarhouni et Gian Gabriele Ciampa
 */
public class ControPanier extends HttpServlet {

    Vector buylist;
    static int count=0;
    String url;
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
        
       BigDecimal montantTotal;
        
        if (session == null) {
            response.sendRedirect("erreur.jsp");
        }

        Vector buylist = (Vector) session.getAttribute("shoppingcart");

        String action = request.getParameter("action");

        String IdItem = request.getParameter("idItem");
        
        String qte = request.getParameter("qteSaisie");


        if (!action.equals("CHECKOUT")) {
            //si clic sur supprimer
            if (action.equals("ADD")||action.equals("portail")) {
                 
                boolean match = false;
                Integer id = Integer.valueOf(IdItem);
                LigneCommande lignecmd = new LigneCommande();
                Produit pro = ProduitDAO.getSingleProduit(new BigDecimal(id));
                lignecmd.setProduit(pro);
                Integer quantite = Integer.valueOf(qte);
                lignecmd.setQuantite(quantite);
                
                if (buylist == null) {
                    count++;
                    buylist = new Vector();
                    buylist.addElement(lignecmd);
                } else {
                    for (int i = 0; i < buylist.size(); i++) {
                  //      Produit produitDeSession = (Produit) buylist.get(i);
                        LigneCommande lgDeSession = (LigneCommande) buylist.get(i);
                        
                        if (lgDeSession.getProduit().getIdproduit().equals(lignecmd.getProduit().getIdproduit()))
                                {
                                    lgDeSession.setQuantite(lgDeSession.getQuantite() + lignecmd.getQuantite());
                                    buylist.setElementAt(lgDeSession,i);
                                    match = true;
                                }
                    }

                    if (!match) {
                        count++;
                        buylist.addElement(lignecmd);
                    }

                }
                session.setAttribute("count", count);
                  
                if(action.equals("ADD")){
                    url = "/detailProduit.jsp";
                }
                if(action.equals("portail")){
                    url = "/portail.jsp";
                }
                
            }
         
            else if(action.equals("cart")){
                 session.setAttribute("count", count);

                 
                 url = "/panier.jsp";
              }
            
            else if(action.equals("DELETE")){
                       count--;
                       String del = request.getParameter("delindex");
                        
                        Integer id = Integer.valueOf(del);
                        buylist.removeElementAt(id);                    
                        session.setAttribute("count", count); 
                        
                       
                        url = "/panier.jsp";
            }
      
        }
        else if(action.equals("CHECKOUT")){
            url = "/PageClient.jsp";
        }
            
         
                 session.setAttribute("shoppingcart", buylist);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
    }

//et on redirige la requête vers la page EShop.jsp qui va afficher
//le nouveau panier (grâce au INCLUDE)
// session.setAttribute("shoppingcart", buylist);
//et on redirige la requête vers la page EShop.jsp qui va afficher
//le nouveau panier (grâce au INCLUDE)

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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
