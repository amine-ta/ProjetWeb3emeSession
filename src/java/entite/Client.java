package entite;
// Generated 2018-09-06 20:59:46 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Client generated by hbm2java
 */
public class Client  implements java.io.Serializable {


     private BigDecimal idclient;
     private String nomclient;
     private String prenomclient;
     private String couriel;
     private String motdepasse;
     private String telephoneclient;
     private String nocivique;
     private String noapp;
     private String nomrue;
     private String ville;
     private String province;
     private String pays;
     private Set commandes = new HashSet(0);
     private Set factures = new HashSet(0);

    public Client() {
    }

	
    public Client(BigDecimal idclient) {
        this.idclient = idclient;
    }
    public Client(BigDecimal idclient, String nomclient, String prenomclient, String courriel, String motdepasse, String telephoneclient, String nocivique, String noapp, String nomrue,String ville, String province, String pays, Set commandes, Set factures) {
       this.idclient = idclient;
       this.nomclient = nomclient;
       this.prenomclient = prenomclient;
       this.couriel = courriel;
       this.motdepasse = motdepasse;
       this.telephoneclient = telephoneclient;
       this.nocivique = nocivique;
       this.noapp = noapp;
       this.nomrue = nomrue;
       this.ville = ville;
       this.province = province;
       this.pays = pays;
       this.commandes = commandes;
       this.factures = factures;
    }

    public Client(BigDecimal idclient, String nomclient, String prenomclient, String courriel, String motdepasse, String telephoneclient, String nocivique, String noapp, String nomrue, String ville, String province, String pays) {
        this.idclient = idclient;
        this.nomclient = nomclient;
        this.prenomclient = prenomclient;
        this.couriel = courriel;
        this.motdepasse = motdepasse;
        this.telephoneclient = telephoneclient;
        this.nocivique = nocivique;
        this.noapp = noapp;
        this.nomrue = nomrue;
        this.ville = ville;
        this.province = province;
        this.pays = pays;
    }
    
    
   
    public BigDecimal getIdclient() {
        return this.idclient;
    }
    
    public void setIdclient(BigDecimal idclient) {
        this.idclient = idclient;
    }
    public String getNomclient() {
        return this.nomclient;
    }
    
    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }
    public String getPrenomclient() {
        return this.prenomclient;
    }
    
    public void setPrenomclient(String prenomclient) {
        this.prenomclient = prenomclient;
    }
    public String getCouriel() {
        return this.couriel;
    }
    
    public void setCouriel(String couriel) {
        this.couriel = couriel;
    }
    public String getMotdepasse() {
        return this.motdepasse;
    }
    
    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
    public String getTelephoneclient() {
        return this.telephoneclient;
    }
    
    public void setTelephoneclient(String telephoneclient) {
        this.telephoneclient = telephoneclient;
    }
    public String getNocivique() {
        return this.nocivique;
    }
    
    public void setNocivique(String nocivique) {
        this.nocivique = nocivique;
    }
    public String getVille() {
        return this.ville;
    }
    
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    public String getPays() {
        return this.pays;
    }
    
    public void setPays(String pays) {
        this.pays = pays;
    }
    public Set getCommandes() {
        return this.commandes;
    }
    
    public void setCommandes(Set commandes) {
        this.commandes = commandes;
    }
    public Set getFactures() {
        return this.factures;
    }
    
    public void setFactures(Set factures) {
        this.factures = factures;
    }

    public String getNoapp() {
        return noapp;
    }

    public void setNoapp(String noapp) {
        this.noapp = noapp;
    }

    public String getNomrue() {
        return nomrue;
    }

    public void setNomrue(String nomrue) {
        this.nomrue = nomrue;
    }

}


