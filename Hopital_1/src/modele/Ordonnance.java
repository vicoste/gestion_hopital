/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.ObservableList;

/**
 *
 * @author vicoste
 * une Ordonnance est une lste de medicament avec leurs instructions definie par le medecin
 */
public class Ordonnance implements Serializable{
    
    private Map<ObservableList<Medicament>,String> map = new HashMap<>();
        public Map<ObservableList<Medicament>, String> getMap() {return map;}
        public void setMap(Map<ObservableList<Medicament>, String> map) {this.map = map;}
        
        
    
   /* private static ObservableList<Medicament> medicaments;
        public static ObservableList<Medicament> getMedicaments() {return medicaments;}
        public static void setMedicaments(ObservableList<Medicament> medicaments) { Ordonnance.medicaments = medicaments;}
*/
    public Ordonnance(ObservableList<Medicament> l,String s) {
        map.put(l, s);
        
    }
    
    
}
