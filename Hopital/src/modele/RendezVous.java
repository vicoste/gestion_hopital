/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author vicoste
 */
public class RendezVous {
    
    private FicheMedicale fiche;
    private Medecin medecin;
    private LocalDate date;

    public RendezVous(FicheMedicale fiche, Medecin medecin, LocalDate date) {
        this.fiche = fiche;
        this.medecin = medecin;
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
     * @return the medecin
     */
    public Medecin getMedecin() {
        return medecin;
    }

    /**
     * @param medecin the medecin to set
     */
    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
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
        return date+" : "+fiche.getPatient().toString()+"        avec le "+medecin; //To change body of generated methods, choose Tools | Templates.
    }
    
}