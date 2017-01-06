/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author vicoste
 */
public class RendezVous {
    
    private FicheMedicale fiche;
    private LocalDate date;
    


    
    
    public RendezVous(FicheMedicale fiche, LocalDate date) {
        this.fiche = fiche;
        this.date = date;
    }

    /**
     * @return the fiche
     */
    public FicheMedicale getFiche() {
        return fiche;
    }

    /**
     * @param fiche the fiche to set
     */
    public void setFiche(FicheMedicale fiche) {
        this.fiche = fiche;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date+" : "+fiche.getPatient().toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
