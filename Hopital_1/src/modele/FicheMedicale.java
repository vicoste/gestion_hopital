/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.ObservableList;


/**
 *
 * @author vicoste
 * La fiche Medicale d'un patient contient les informations qui seront necessaire au medecin
 * Un patient peut avoir plusieur fiche medicale : par exemple il peut venir en 2017 a cause d'une grippe
 *                                                                      puis en 2020 a cause d'une fracture
 * Les fiches medicales sont enregistrées indefiniment (pour pouvoir ressortir les vieux dossier)
 * leur état passe de 0 à 1 lorsque le patient est guerris, la Fiche medicale est donc traité et
 * ne sera plus disponible pour prevoir un rendez-vous
 */
public class FicheMedicale implements Serializable{
    
    private String numDossier; //le numero dossier est un numero unique qui identifie une fiche medicale.
        public String getNumDossier() {return numDossier;}//il n'y a pas de setter car le numDossier est créé une fois et definitivement a la création de la fiche médicale
        
    private Date dateEntree; //la date d'entrée est la date de creation de la fiche médicale
        public Date getDateEntree() {return dateEntree;}
        public void setDateEntree(Date dateEntree) {this.dateEntree = dateEntree;}
    
    private String motif; //le motif est la raison du patient pour etre admis dans l'hopital
        public String getMotif() {return motif;}
        public void setMotif(String motif) {this.motif = motif;}
    
    private Patient patient;//le patient qui demande a se faire soigner
        public Patient getPatient() {return patient;}
        public void setPatient(Patient patient) {this.patient = patient;}
        
    private Ordonnance ordonnance;//l'ordonnance peux etre null, elle est disponible lorsque le medecin l'a validé    
        public Ordonnance getOrdonnance() {return ordonnance;}
        public void setOrdonnance(Ordonnance ordonnance) {this.ordonnance = ordonnance;}
    
    private ArrayList<Symptome> listSymp = new ArrayList<>();//liste des symptomes donc souffre le client
        public ArrayList<Symptome> getListSymp() {return listSymp;}
        public void setListSymp(ArrayList<Symptome> listSymp) {this.listSymp = listSymp;}
    
    private Boolean etat;// l'etat de la fiche signifie si le patient a été traité(true) ou non(false)
        public Boolean getEtat() {return etat;}
        public void setEtat(Boolean etat) {this.etat = etat;}
    
    public FicheMedicale(String motif, Patient p, ObservableList<Symptome> listSymp){        
        this.motif = motif;
        patient = p;        
        etat = false;
        dateEntree = new Date();
        /*
        createNumDossier() sert a creer le numero de dossier unique, c'est pour ça que la fonction est private
        est qu'elle est uniquement appelée à la création de la fiche médicale
        */
        createNumDossier();
        /*this.listSymp est une arrayList car l'ObservableList n'est pas serializable
            je n'utilise que des ObservableList dans ce programme donc j'ai recours a un "for each" 
        afin de remplir mon ArrayList avec une ObservableList
        */
        for(Symptome s : listSymp)this.listSymp.add(s);
    }
    
    
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

    @Override
    public String toString() {
        return patient.getNom()+" "+patient.getPrenom()+" - "+numDossier; //
    }

}
