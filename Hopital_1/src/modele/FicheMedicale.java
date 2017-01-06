/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import java.util.Date;
import java.util.List;


/**
 *
 * @author vicoste
 */
public class FicheMedicale {
    private String numDossier; 
    private Date dateEntree;
    private String motif;    
    private Patient patient;
    private Ordonnance ordonnance;    
    private List<Symptome> listSymp;    
    private Boolean etat;
    
    public FicheMedicale(String motif, Patient p, List<Symptome> listSymp){
        
        this.motif = motif;
        patient = p;
        this.listSymp = listSymp;
        etat = false;
        dateEntree = new Date();        
        createNumDossier();              
    }
    

    /**
     * @return the numDossier
     */
    public String getNumDossier() {
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
        
        String numJour = a.substring(8, 10);
        
        
        String mois = a.substring(4, 7);
        
        
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
        
        
        
        
       
        
        numDossier=num;
        
         
        
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

    @Override
    public String toString() {
        return patient.getNom()+" "+patient.getPrenom()+" - "+numDossier; //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void setListFM(){
        
    }
}
