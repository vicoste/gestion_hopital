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
        dateEntree = new Date();
        
        createNumDossier();
        
     
        
               
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
        
        
        
        String a = dateEntree.toString();
        String sexe = new String();
        String num = new String();
        System.out.println(a);
        String numJour = a.substring(8, 10);
        System.out.println(numJour);
        
        String mois = a.substring(4, 7);
        System.out.println(mois);
        
        switch(mois){
            case "Jan":
                mois="01";
                break;
                
            case "Fev":
                mois="02";
                break;
                                
            case "Mar":
                mois="03";
                break; 
                
            case "Avr":
                mois="04";
                break; 
                
            case "May":
                mois="05";
                break;  
                
            case "Jun":
                mois="06";
                break;   
                
            case "Jul":
                mois="07";
                break;    
                
            case "Aug":
                mois="08";
                break;    
                
            case "Sep":
                mois="09";
                break;    
                
            case "Oct":
                mois="10";
                break;   
                
            case "Nov":
                mois="11";
                break;  
                
            case "Dec":
                mois="12";
                break;       
                
            default:
                mois="13";
 
        }
        String an = a.substring(24, 28);
        
        if(patient.getSexe()){
            sexe = "1";
        }
        else{
            sexe = "0";
        }
        dateEntree.getTime();
        
        num= sexe.concat(numJour).concat(mois).concat(an).concat(patient.getNom().substring(0, 1).toUpperCase()).concat(patient.getPrenom().substring(0, 1).toUpperCase());
        
        
        
        
        System.out.println("numdossier :"+num+dateEntree.getTime());
        
        
        
        
        
        
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
