/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;

/**
 *
 * @author vicoste
 */
public class RendezVous {
    
    private FicheMedical fiche;
    private Medecin medecin;
    private Date date;

    public RendezVous(FicheMedical fiche, Medecin medecin, Date date) {
        this.fiche = fiche;
        this.medecin = medecin;
        this.date = date;
    }

    /**
     * @return the fiche
     */
    public FicheMedical getFiche() {
        return fiche;
    }

    /**
     * @param fiche the fiche to set
     */
    public void setFiche(FicheMedical fiche) {
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
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return medecin+" - "+fiche+ " le "+date; //To change body of generated methods, choose Tools | Templates.
    }
    
}
