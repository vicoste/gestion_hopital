/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author vicoste
 */
public class FicheMedical {
    private int numDossier; 
    private Date dateEntree;
    private String motif;
    private Boolean etat;
    private Patient patient;
    private List<Symptome> listSymp;
    private Traitement traitement;

    public FicheMedical(String motif, Patient p, List<Symptome> listSymp) {
        
        this.motif=motif;
        patient=p;
        this.listSymp=listSymp;
        etat = false;
        traitement = null;
       
        System.out.println();
        //createNumDossier();
        
        
        
        
               
    }
    

    /**
     * @return the numDossier
     */
    public int getNumDossier() {
        return numDossier;
    }

    /**
     * le numDossier ne peux pas etre modifié, il est généré une fois 
     * 
     */
     
    private void createNumDossier() {
        
        File f =new File("dossier.don");
        
        
        
        
        
        
        
        
    }

    /**
     * @return the dateEntree
     */
    public Date getDateEntree() {
        return dateEntree;
    }

    /**
     * @param dateEntree the dateEntree to set
     */
    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    /**
     * @return the motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * @param motif the motif to set
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * @return the etat
     */
    public Boolean getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the symptome
     */
    public List<Symptome> getSymptome() {
        return listSymp;
    }

    /**
     * @param symptome the symptome to set
     */
    public void setSymptome(List<Symptome> symptome) {
        listSymp = symptome;
    }
    
}
