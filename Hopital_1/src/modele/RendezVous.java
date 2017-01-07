/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author vicoste
 */
public class RendezVous implements Serializable{
    
    private FicheMedicale fiche;
        public FicheMedicale getFiche() {return fiche;}
        public void setFiche(FicheMedicale fiche) {this.fiche = fiche;}    

    private LocalDate date;
        public LocalDate getDate() {return date;}
        public void setDate(LocalDate date) {this.date = date;}
    
    
    public RendezVous(FicheMedicale fiche, LocalDate date) {
        //setFicheMedicale(fiche);
        this.date = date;
        this.fiche = fiche;
    }

    @Override
    public String toString() {
        return getDate()+" : "+getFiche().getPatient().toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
