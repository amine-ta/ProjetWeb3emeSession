/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gcia_
 */
public class Deconnexion extends HttpServlet {

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
        String language = request.getParameter("languecourr");
        String messageDeconnexion = "";
        String nextJSP;
        nextJSP = "/DeconnClient.jsp";
                      
        session.setAttribute("langueCourante", language);
        
        if (language.equalsIgnoreCase("fr_CA"))
        {
            messageDeconnexion = "Vous avez été déconnecté.  Merci d'avoir magasiné chez Pro-Vita Tarh&Cia inc.\n";
            messageDeconnexion = messageDeconnexion + "Bonne journée!";
        }
        else if (language.equalsIgnoreCase("en_CA"))
         {
            messageDeconnexion = "You have been log out.  Thanks having shopped at Pro-Vita Tarh&Cia inc. \n";
            messageDeconnexion = messageDeconnexion + "Have a nice day!";
         }
        else
       {
            messageDeconnexion = "Avete stato disconnesso.  Grazie per avere acquistato su Pro-Vita Tarh&Cia inc.\n";
            messageDeconnexion = messageDeconnexion + "Buona Giornata!";
         }     
        session.invalidate();
        request.setAttribute("MessageDeconnexion", messageDeconnexion);
     
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
