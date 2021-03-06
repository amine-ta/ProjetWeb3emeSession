package entite;
// Generated 2018-09-06 20:59:46 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * LigneCommandeId generated by hbm2java
 */
public class LigneCommandeId  implements java.io.Serializable {


     private BigDecimal nocommande;
     private BigDecimal idproduit;

    public LigneCommandeId() {
    }

    public LigneCommandeId(BigDecimal nocommande, BigDecimal idproduit) {
       this.nocommande = nocommande;
       this.idproduit = idproduit;
    }
   
    public BigDecimal getNocommande() {
        return this.nocommande;
    }
    
    public void setNocommande(BigDecimal nocommande) {
        this.nocommande = nocommande;
    }
    public BigDecimal getIdproduit() {
        return this.idproduit;
    }
    
    public void setIdproduit(BigDecimal idproduit) {
        this.idproduit = idproduit;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LigneCommandeId) ) return false;
		 LigneCommandeId castOther = ( LigneCommandeId ) other; 
         
		 return ( (this.getNocommande()==castOther.getNocommande()) || ( this.getNocommande()!=null && castOther.getNocommande()!=null && this.getNocommande().equals(castOther.getNocommande()) ) )
 && ( (this.getIdproduit()==castOther.getIdproduit()) || ( this.getIdproduit()!=null && castOther.getIdproduit()!=null && this.getIdproduit().equals(castOther.getIdproduit()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNocommande() == null ? 0 : this.getNocommande().hashCode() );
         result = 37 * result + ( getIdproduit() == null ? 0 : this.getIdproduit().hashCode() );
         return result;
   }   


}


