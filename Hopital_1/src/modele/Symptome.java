/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javafx.collections.ObservableList;

/**
 *
 * @author vicoste
 */
public class Symptome implements Serializable{
    private String nom;
    private String description;
    
    

    public Symptome(String nom, String description) {
        this.nom = nom;
        this.description = description;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getNom(); //To change body of generated methods, choose Tools | Templates.
    }

    public ObservableList<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(ObservableList<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
    
    
    
}
