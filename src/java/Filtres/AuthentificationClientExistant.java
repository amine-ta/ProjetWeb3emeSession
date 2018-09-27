/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtres;

import JavaMethodes.GestionnaireClient;
import entite.Client;
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
import javax.servlet.http.HttpSession;

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
        String langue = request.getParameter("languecourr");
        
        String MessageErreurConnexion,MessageErreurMotDePasse,PageJSP;
        PageJSP = "/PageClient.jsp";
        if (langue.equalsIgnoreCase("en_CA"))
        {
            MessageErreurConnexion = "The email does not exist";
            MessageErreurMotDePasse = "Invalid password entered";
            
        }
        else if (langue.equalsIgnoreCase("fr_CA"))
        {
            MessageErreurConnexion = "Le courriel n'existe pas";
            MessageErreurMotDePasse = "Le mot de passe est invalide";
            
        }
        else
        {
            MessageErreurConnexion = "L'e-mail non esiste";
            MessageErreurMotDePasse = "La chiave d'accesso non è valida";
            
        }    
        
        // Si le courriel n'existe pas dans la base de donnée, alors le client est inexistant!!
        if(!GestionnaireClient.rechercherCourriel(motDePasseLogin))
        {
            request.setAttribute("MessageErreurLogin", MessageErreurConnexion);
        } 
        // Le courriel existe, mais le mot de passe ne correspond pas au mot de passe dans la base de donnée
        else
        {
            if (!GestionnaireClient.confirmerMotDePasse(request.getParameter("logincourriel"), request.getParameter("loginmdp")))
            {
                request.setAttribute("logincourrielv",request.getParameter("logincourriel"));
                request.setAttribute("MessageErreurLogin", MessageErreurMotDePasse);
            } 
            else
            {
            
            chain.doFilter(request, response);
            }
            
                
        }
        RequestDispatcher rd = request.getRequestDispatcher(PageJSP);
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
    