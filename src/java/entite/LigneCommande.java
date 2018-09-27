package entite;
// Generated 2018-09-27 18:59:22 by Hibernate Tools 4.3.1



/**
 * LigneCommande generated by hbm2java
 */
public class LigneCommande  implements java.io.Serializable {


     private LigneCommandeId id;
     private Produit produit;
     private Integer quantite;

    public LigneCommande() {
    }

	
    public LigneCommande(LigneCommandeId id, Produit produit) {
        this.id = id;
        this.produit = produit;
    }
    public LigneCommande(LigneCommandeId id, Produit produit, Integer quantite) {
       this.id = id;
       this.produit = produit;
       this.quantite = quantite;
    }
   
    public LigneCommandeId getId() {
        return this.id;
    }
    
    public void setId(LigneCommandeId id) {
        this.id = id;
    }
    public Produit getProduit() {
        return this.produit;
    }
    
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    public Integer getQuantite() {
        return this.quantite;
    }
    
    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }




}


