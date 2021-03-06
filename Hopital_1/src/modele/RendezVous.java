/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.time.LocalDate;
import launch.Main;

/**
 *
 * @author vicoste
 * Un rendezVous est 
 */
public class RendezVous implements Serializable{
    
    private FicheMedicale fiche;
        public FicheMedicale getFiche() {return fiche;}
        public void setFiche(FicheMedicale fiche) {this.fiche = fiche;}    

    private LocalDate date;
        public LocalDate getDate() {return date;}
        public void setDate(LocalDate date) {this.date = date;}
        
    private Heure heure;
        public Heure getHeure() {return heure;}
        public void setHeure(Heure heure) {this.heure = heure;}
    
    
    public RendezVous(FicheMedicale fiche, LocalDate date, Heure heure) {
        this.heure = heure;
        this.date = date;
        this.fiche = fiche;
        
    }

    @Override
    public String toString() {
        return getDate()+" : "+getFiche().getPatient().toString()+" à "+heure.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Boolean supprimer(){
        for(Personnel e : Main.getHopital().getListePersonnel()){
            if(e.isMedecin()){
                Medecin m = (Medecin) e;
                if(m.getListeRdv().contains(this))
                    m.getListeRdv().remove(this);
                    return true;
            }
        }
        return false;
    }
}
