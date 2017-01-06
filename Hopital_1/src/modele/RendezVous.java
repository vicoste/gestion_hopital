/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author vicoste
 */
public class RendezVous {
    
    private final ObjectProperty<FicheMedicale> ficheMedicale= new SimpleObjectProperty<>();
        public FicheMedicale getFicheMedicale() {return ficheMedicale.get();}
        public void setFicheMedicale(FicheMedicale ficheMedicale) {this.ficheMedicale.set(ficheMedicale);}
        public ObjectProperty<FicheMedicale> FicheMedicaleProperty(){return ficheMedicale;}

    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    
    
    


    
    
    public RendezVous(FicheMedicale fiche, LocalDate date) {
        setFicheMedicale(fiche);
        this.date = date;
    }


    @Override
    public String toString() {
        return date+" : "+fiche.getPatient().toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
