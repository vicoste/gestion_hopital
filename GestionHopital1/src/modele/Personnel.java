/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author vicoste
 */
public class Personnel {
    private String nom;
    private String prenom;
    private String identifiant;
    private String mdp;

    public Personnel(String nom, String prenom, String identifiant, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.mdp = mdp;
    }
    
    
    public Boolean seloguer(String id, String mdp){
        return identifiant.equals(id) && this.mdp.equals(mdp);
   
    } 
    


    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * @param identifiant the identifiant to set
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
}
