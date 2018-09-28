/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import DAO.ProduitDAO;
import JavaMethodes.GestionnairePanier;
import JavaMethodes.GestionnaireProduit;
import Services.IGestionnairePanier;
import Services.IGestionnaireProduit;
import entite.LigneCommande;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    IGestionnairePanier gestionnairePanier =new GestionnairePanier();
    IGestionnaireProduit gestionnaireProduit = new GestionnaireProduit();
    String url;
    String action;
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
        
        BigDecimal montantTotal;
       
       String msgErreurQteStk="";
       String langue="";
       
       langue = (String)session.getAttribute("langueCourante");
       
       if (langue != null)
       {    
           if (langue.equalsIgnoreCase("en_CA"))
               msgErreurQteStk = "The quantity in stock is insufficient";
           else if (langue.equalsIgnoreCase("fr_CA"))
               msgErreurQteStk = "La quantité en stock est insuffisante";
           else
               msgErreurQteStk = "La quantità in magazzino è insufficiente";
       }
       else
               msgErreurQteStk = "La quantité en stock est insuffisante";
       
       
        if (session == null) {
            response.sendRedirect("/erreur.jsp");
        }

       
//Gestion Produit

        String Filtre=request.getParameter("Filtre");
        String categorie=request.getParameter("categorie");
        String marque=request.getParameter("marque");
        String prix = request.getParameter("rechPrix");
    
 
      
       if(action!=null&&action.equals("detail"))
        {
            String idProduit = request.getParameter("id");
            Object obj = gestionnaireProduit.getSingleProduit(idProduit);
            session.setAttribute("PageCourante","/detailProduit.jsp");
            session.setAttribute("detailProduit",obj );
            url = "/detailProduit.jsp";
        }
        
  
       else if(Filtre!=null){
           if(Filtre.equals("mar")){
                List LiProduit=GestionnaireProduit.rechercherProduitParMarque(marque);
               session.setAttribute("ListPoduit",LiProduit);
               session.setAttribute("PageCourante","/portail.jsp");
                url = "/portail.jsp";
           }
           
           else if(Filtre.equals("Cat")){
                List LiProduit=GestionnaireProduit.rechercherProduitParCategorie(categorie);
                session.setAttribute("ListPoduit",LiProduit);
                session.setAttribute("PageCourante","/portail.jsp");
                url = "/portail.jsp";
           }
           else if(Filtre.equals("prix")){
                List LiProduit=GestionnaireProduit.rechercherProduitParPrix(prix);
                session.setAttribute("ListPoduit",LiProduit);
                session.setAttribute("PageCourante","/portail.jsp");
                url = "/portail.jsp";
           }
       }
       
         else if(action.equals("cart")){            
                                    session.setAttribute("PageCourante","/panier.jsp");
                                    url = "/panier.jsp";
                          }
    

//Gestion Panier
             else if (!action.equals("CHECKOUT")) {            
           
                    if (action.equals("ADD")||action.equals("portail")){              
                                 String IdItem = request.getParameter("idItem");  
                                 String quantite=request.getParameter("qteSaisie");                      
                                 if (gestionnaireProduit.verifierQuantiteProduitDansBDD(IdItem,quantite))
                                 {    
                                            gestionnairePanier.ajouterProduitDansPanier(IdItem,quantite); 

                                            if(action.equals("ADD")){
                                                url = "/detailProduit.jsp";
                                                session.setAttribute("PageCourante","/detailProduit.jsp");
                                            }
                                            if(action.equals("portail")){
                                                session.setAttribute("count",GestionnairePanier.count);
                                                session.setAttribute("PageCourante","/portail.jsp");
                                                url = "/portail.jsp";
                                            }
                                 }
                                 else
                                     request.setAttribute("msgErreurQteStk", msgErreurQteStk);
                          }       
                      
                        else if(action.equals("DELETE")){               
                                    String del = request.getParameter("delindex");
                                    gestionnairePanier.SupprimerUnProduitPanier(del);                                                                               
                                    url = "/panier.jsp";
                            }
            }//Fin If De (action.equals("ADD")||action.equals("portail")
        
       
            else if(action.equals("CHECKOUT")){

                        String amount=GestionnaireProduit.getTotalApresTAXE(gestionnairePanier.getPanier());              
                        session.setAttribute("amount",amount);
                        session.setAttribute("TPS",GestionnaireProduit.TPS);
                        session.setAttribute("TVQ",GestionnaireProduit.TVQ);            
                        session.setAttribute("soustotal",GestionnaireProduit.getSousTotal(gestionnairePanier.getPanier()));
                        session.setAttribute("PageCourante","/PageClient.jsp");
                        url = "/PageClient.jsp";
            }

       
       
       
                session.setAttribute("count",GestionnairePanier.count);
                session.setAttribute("shoppingcart", gestionnairePanier.getPanier());
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
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
