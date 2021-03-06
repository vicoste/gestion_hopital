/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.ObservableList;
import launch.Main;


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
    
    private ArrayList<Symptome> listSymp = new ArrayList<>();
        public ArrayList<Symptome> getListSymp() {return listSymp;}
        public void setListSymp(ArrayList<Symptome> listSymp) {this.listSymp = listSymp;}
    
    private Boolean etat;// l'etat de la fiche signifie si le patient a été traité(true) ou non(false)
        public Boolean getEtat() {return etat;}
        public void setEtat(Boolean etat) {this.etat = etat;}
    
    public FicheMedicale(String motif, Patient p, ObservableList<Symptome> liste){        
 
        this.motif = motif;
        patient = p;        
        etat = false;
        dateEntree = new Date();
        /*
        createNumDossier() sert a creer le numero de dossier unique, c'est pour ça que la fonction est private
        est qu'elle est uniquement appelée à la création de la fiche médicale
        */
        createNumDossier();
        /*listSymp est une arrayList car l'ObservableList n'est pas serializable
            je n'utilise que des ObservableList dans ce programme donc j'ai recours a un "for each" 
        afin de remplir mon ArrayList avec une ObservableList
        */
        for(Symptome s : liste) listSymp.add(s);
    }
    
    
    private void createNumDossier() {
        String date = LocalDate.now().toString();
        String sexe = null;
        int i=0;
        if(patient.getSexe()) sexe ="1"; 
        else sexe = "0";
        String res = sexe+date+patient.getNom().substring(0, 1)+patient.getPrenom().substring(0,1);
        for(FicheMedicale f : Main.getHopital().getListeFicheMedicale()){
            
            if(res.equals(f.getNumDossier())){
                i++;
                res = res+i;
                
            }
        }
        numDossier=res;
        
    }

    @Override
    public String toString() {
        return patient.getNom()+" "+patient.getPrenom()+" - "+numDossier; //
    }

}
