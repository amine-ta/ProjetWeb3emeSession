/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMethodes;

import Services.IGestionnairePanier;
import DAO.ProduitDAO;
import entite.LigneCommande;
import entite.Produit;
import java.math.BigDecimal;
import java.util.Vector;

/**
 *
 * @author 1895088
 */
public class GestionnairePanier implements IGestionnairePanier {

    private Vector<LigneCommande> panier;
    private Produit produit;
    private LigneCommande lignecmd;
    
    private Produit getSingleProduit(String Item) {
        Integer id = Integer.valueOf(Item);
        produit = ProduitDAO.getSingleProduit(new BigDecimal(id));
        return produit;
    }

    @Override
    public void ajouterProduitDansPanier(String idProduit,String qte) {
        
        boolean match = false;
        produit = getSingleProduit(idProduit);
        Integer quantite = Integer.valueOf(qte);
        
        lignecmd = new LigneCommande();
        lignecmd.setProduit(produit);
        lignecmd.setQuantite(quantite);
        

        if (panier == null) {
      
            panier = new Vector<LigneCommande>();
            panier.addElement(lignecmd);
        } else {
            
            for (int i = 0; i < panier.size(); i++) {
                LigneCommande Ligneproduit = (LigneCommande)panier.elementAt(i);
                if (Ligneproduit.getProduit().getIdproduit().equals(lignecmd.getProduit().getIdproduit())) {
                
                    Ligneproduit.setQuantite(Ligneproduit.getQuantite()+lignecmd.getQuantite());
                    panier.setElementAt(Ligneproduit,i);
                    match = true;
                } //end of if name matches
            } // end of for
            if (!match){
            
            panier.addElement(lignecmd);
            }
        }
        
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
        panier.removeElementAt(id);
    }

 
     public  int getCount() {
        int count=0;
        if(panier==null){
         count=0;
        }
         else{
        for(int i=0;i<panier.size();i++) 
        count +=panier.get(i).getQuantite();
        }
        
        return count;             
    }


}

