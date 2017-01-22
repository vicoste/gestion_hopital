/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
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
    
   
        
    private Dictionary<Medicament, String> dictionary = new Hashtable<>();
    

    public Dictionary<Medicament, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary<Medicament, String> dictionary) {
        this.dictionary = dictionary;
    }
    
    

    public Ordonnance(Dictionary<Medicament, String> m) {
        dictionary=m;
    }

    
    
    
}
