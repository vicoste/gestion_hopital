/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.binding.MapBinding;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

/**
 *
 * @author vicoste
 * une Ordonnance est une lste de medicament avec leurs instructions definie par le medecin
 */
public class Ordonnance implements Serializable{
    
   
        
    
    private ObservableMap<Medicament, String> map = FXCollections.emptyObservableMap();

    public ObservableMap<Medicament, String> getMap() {
        return map;
    }

    public void setMap(ObservableMap<Medicament, String> map) {
        this.map = map;
    }
    
    

    public Ordonnance(ObservableMap<Medicament, String> m) {
        map=m;
    }

    
    
    
}
