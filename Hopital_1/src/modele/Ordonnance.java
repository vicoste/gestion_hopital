/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javafx.collections.ObservableList;

/**
 *
 * @author vicoste
 * une Ordonnance est une lste de medicament 
 */
public class Ordonnance implements Serializable{
    
    
    
    private static ObservableList<Medicament> medicaments;
        public static ObservableList<Medicament> getMedicaments() {return medicaments;}
        public static void setMedicaments(ObservableList<Medicament> medicaments) { Ordonnance.medicaments = medicaments;}

    public Ordonnance(ObservableList<Medicament> l) {
        medicaments=l;        
    }
    
    
}
