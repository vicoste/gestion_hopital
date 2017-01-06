/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javafx.collections.ObservableList;

/**
 *
 * @author vicoste
 */
public class Ordonnance {
    
    
    
    private static ObservableList<Medicament> medicaments;

    public Ordonnance(ObservableList<Medicament> l) {
        medicaments=l;        
    }
    
    
}
