/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entite.Produit;
import java.math.BigDecimal;
import java.util.Vector;

/**
 *
 * @author 1895088
 */
public interface IGestionnairePanier{     
    void ajouterProduitDansPanier(String idProduit,String qte);
    void SupprimerUnProduitPanier(String id);
    Vector getPanier();
}
