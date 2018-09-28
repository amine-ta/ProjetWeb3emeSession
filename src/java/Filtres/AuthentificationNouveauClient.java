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
import org.hibernate.Session;

/**
 *
 * @author 1895040
 */
public class AuthentificationNouveauClient implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public AuthentificationNouveauClient() {
    }    
    
  
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException
    {
     
        boolean courrieltrouve = false;
        String courriel = request.getParameter("courriel");
        String langue = request.getParameter("languecourr");
        
        
        courrieltrouve = GestionnaireClient.rechercherCourriel(courriel);
        if (courrieltrouve)
        {
            request.setAttribute("prenomv",request.getParameter("prenom"));
            request.setAttribute("nomv",request.getParameter("nom"));
            request.setAttribute("telephonev",request.getParameter("telephone"));
            request.setAttribute("nociviquev",request.getParameter("nocivique"));
            request.setAttribute("ruev",request.getParameter("rue"));
            request.setAttribute("noappv",request.getParameter("noapp"));
            request.setAttribute("villev",request.getParameter("ville"));
            request.setAttribute("provincev",request.getParameter("province"));
            request.setAttribute("paysv",request.getParameter("pays"));
            
            if (langue.equalsIgnoreCase("fr_CA"))
                request.setAttribute("MessageErreurCourriel", "Un client avec ce courriel existe déjà");
            else if (langue.equalsIgnoreCase("en_CA"))
                request.setAttribute("MessageErreurCourriel", "Uno cliente con questa e-mail esiste già");
            else
                request.setAttribute("MessageErreurCourriel", "A client with this email already exists");
            
            RequestDispatcher rd = request.getRequestDispatcher("/PageClient.jsp");
            rd.forward(request, response);
        }
        else
            chain.doFilter(request, response);
        
        
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }
  
}
