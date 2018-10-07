/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtres;

import JavaMethodes.GestionnaireClient;
import JavaMethodes.GestionnaireCommande;
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
    public static boolean connecter = false;

    String motDePasse = "";
    Client client = null;
    String MessageErreurConnexion, MessageErreurMotDePasse, PageJSP;
    String MessageErreurCourriel;
    String loginInvalide;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public AuthentificationClientExistant() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
       
        String couriel = request.getParameter("logincourriel");
        String langue = request.getParameter("languecourr");
        String action = request.getParameter("action");
        PageJSP = "/PageClient.jsp";

        if (action.equals("CLIENTEXISIT")) {
            // Si le courriel n'existe pas dans la base de donnée, alors le client est inexistant!!
            if (!GestionnaireClient.rechercherCourriel(couriel)) {
                request.setAttribute("Valide", true);
                RequestDispatcher rd = request.getRequestDispatcher(PageJSP);
                rd.forward(request, response);
            } // Le courriel existe, mais le mot de passe ne correspond pas au mot de passe dans la base de donnée
            else if (!GestionnaireClient.confirmerMotDePasse(request.getParameter("logincourriel"), request.getParameter("loginmdp"))) {
                request.setAttribute("logincourrielv", request.getParameter("logincourriel"));
                request.setAttribute("ValideMdp", true);
                RequestDispatcher rd = request.getRequestDispatcher(PageJSP);
                rd.forward(request, response);

            } else {
                motDePasse = request.getParameter("loginmdp");
                client = GestionnaireClient.ConfirmerClient(couriel, motDePasse);
                GestionnaireCommande.creerNouvelleCommande(client);
                request.setAttribute("boncourriel", couriel);
            }
               
        } else if (action.equals("CreerClient")) {

            boolean courrieltrouve = false;
            String courriel = request.getParameter("courriel");
            String langues = request.getParameter("languecourr");
            courrieltrouve = GestionnaireClient.rechercherCourriel(courriel);

            if (courrieltrouve) {
                request.setAttribute("ValideCourriel", true);
                RequestDispatcher rd = request.getRequestDispatcher(PageJSP);
                rd.forward(request, response);
            }
            request.setAttribute("boncourriel", courriel);

        }
        
        
        chain.doFilter(request, response);

    }

    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {

    }
}
