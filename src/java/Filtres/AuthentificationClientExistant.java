/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtres;

import JavaMethodes.GestionnaireClient;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Mohamed Amine Tarhouni et Gian Gabriele Ciampa
 */
public class AuthentificationClientExistant implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public AuthentificationClientExistant() {
    }    
    
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
  
        String motDePasseLogin = request.getParameter("logincourriel");
        
        // Si le courriel n'existe pas dans la base de donnée, alors le client est inexistant!!
        if(!GestionnaireClient.rechercherCourriel(motDePasseLogin))
        {
            request.setAttribute("MessageErreurLogin", "Le courriel n'existe pas");
        } 
        // Le courriel existe, mais le mot de passe ne correspond pas au mot de passe dans la base de donnée
        else
        {
            if (!GestionnaireClient.confirmerMotDePasse(request.getParameter("logincourriel"), request.getParameter("loginmdp")))
            {
                request.setAttribute("logincourrielv",request.getParameter("logincourriel"));
                request.setAttribute("MessageErreurLogin", "Le mot de passe est invalide");
            } 
            else
               chain.doFilter(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/PageClient.jsp");
        rd.forward(request,response);
    }
    
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
    
    }
}
    