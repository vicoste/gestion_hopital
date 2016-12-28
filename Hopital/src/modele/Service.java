/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author vicoste
 */
public class Service {
    private String nom;
    private String specialite;
    private List<FicheMedicale> listFichM;
    private List<Personnel> listPers;

    public Service(String nom, String specialite, List<FicheMedicale> listFichM, List<Personnel> listPers) {
        this.nom = nom;
        this.specialite = specialite;
        this.listFichM = listFichM;
        this.listPers = listPers;
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
     * @return the specialite
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * @param specialite the specialite to set
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
    
}
