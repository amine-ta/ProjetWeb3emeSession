/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMethodes;

import Services.IGestionnairePanier;
import DAO.ProduitDAO;
import Services.IGestionnaireProduit;
import entite.LigneCommande;
import entite.Produit;
import java.math.BigDecimal;
import java.util.Vector;

/**
 *
 * @author 1895088
 */
public class GestionnairePanier implements IGestionnairePanier {

    private Vector panier;
    private Produit produit;
    private LigneCommande lignecmd;
    public static  int count=0;
    private IGestionnaireProduit gestionProduit=new GestionnaireProduit();

    
    

    @Override
    public void ajouterProduitDansPanier(String idProduit,String qte) {        
        boolean match = false;
        produit = (Produit)gestionProduit.getSingleProduit(idProduit);
        Integer quantite = Integer.valueOf(qte);       
        lignecmd = new LigneCommande(quantite,produit);        
        VerifierPanierVide(match);
        
    }

    private void VerifierPanierVide(boolean match) {
        if (panier == null) {
            count++;
            panier = new Vector();
            panier.addElement(lignecmd);
        } else {         
            match = VerfierProduitDansPanier(match);
            if (!match){
                count++;
                panier.addElement(lignecmd);
            }
        }
    }

    private boolean VerfierProduitDansPanier(boolean match) {
        for (int i = 0; i < panier.size(); i++) {
            LigneCommande Ligneproduit = (LigneCommande)panier.elementAt(i);
            if (Ligneproduit.getProduit().getIdproduit().equals(lignecmd.getProduit().getIdproduit())) {
                count++;
                Ligneproduit.setQuantite(Ligneproduit.getQuantite()+lignecmd.getQuantite());
                panier.setElementAt(Ligneproduit,i);
                match = true;
            } //end of if name matches
        } // end of for
        return match;
    }

    public Vector getPanier() {
        return panier;
    }

   

    public LigneCommande getLignecmd() {
        return lignecmd;
    }

   

    @Override
    public void SupprimerUnProduitPanier(String index) {        
        Integer id = Integer.valueOf(index);
        LigneCommande ligneC =(LigneCommande)panier.get(id);
        count -=ligneC.getQuantite();
        panier.removeElementAt(id);
        if(panier.isEmpty()){
            panier=null;
        }
    }

 
    public static int getCount() {
        return count;
    }

}

