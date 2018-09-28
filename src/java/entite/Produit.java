package entite;
// Generated 2018-09-27 18:59:22 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Produit generated by hbm2java
 */
public class Produit  implements java.io.Serializable {


     private BigDecimal idproduit;
     private Categorie categorie;
     private Marque marque;
     private String nomproduit;
     private String descriptionFr;
     private BigDecimal prix;
     private String formatpro;
     private Integer quantiteenstock;
     private String image;
     private Set ligneCommandes = new HashSet(0);

    public Produit() {
    }

	
    public Produit(BigDecimal idproduit) {
        this.idproduit = idproduit;
    }
    public Produit(BigDecimal idproduit, Categorie categorie, Marque marque, String nomproduit, String descriptionFr, BigDecimal prix, String formatpro, Integer quantiteenstock, String image, Set ligneCommandes) {
       this.idproduit = idproduit;
       this.categorie = categorie;
       this.marque = marque;
       this.nomproduit = nomproduit;
       this.descriptionFr = descriptionFr;
       this.prix = prix;
       this.formatpro = formatpro;
       this.quantiteenstock = quantiteenstock;
       this.image = image;
       this.ligneCommandes = ligneCommandes;
    }
   
    public BigDecimal getIdproduit() {
        return this.idproduit;
    }
    
    public void setIdproduit(BigDecimal idproduit) {
        this.idproduit = idproduit;
    }
    public Categorie getCategorie() {
        return this.categorie;
    }
    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    public Marque getMarque() {
        return this.marque;
    }
    
    public void setMarque(Marque marque) {
        this.marque = marque;
    }
    public String getNomproduit() {
        return this.nomproduit;
    }
    
    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }
    public String getDescriptionFr() {
        return this.descriptionFr;
    }
    
    public void setDescriptionFr(String descriptionFr) {
        this.descriptionFr = descriptionFr;
    }
    public BigDecimal getPrix() {
        return this.prix;
    }
    
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
    public String getFormatpro() {
        return this.formatpro;
    }
    
    public void setFormatpro(String formatpro) {
        this.formatpro = formatpro;
    }
    public Integer getQuantiteenstock() {
        return this.quantiteenstock;
    }
    
    public void setQuantiteenstock(Integer quantiteenstock) {
        this.quantiteenstock = quantiteenstock;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Set getLigneCommandes() {
        return this.ligneCommandes;
    }
    
    public void setLigneCommandes(Set ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }




}


