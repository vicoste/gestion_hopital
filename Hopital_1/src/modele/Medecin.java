/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author vicoste
 */
public class Medecin extends Personnel{
    
    private static ObservableList<RendezVous> listRDV = FXCollections.observableArrayList();
    private final static ListProperty<RendezVous> rdvProperty = new SimpleListProperty<>(listRDV);
        public static ObservableList<RendezVous> getListRDV(){return rdvProperty.get();}
        public static void setListRDV(ObservableList<RendezVous> rdv){rdvProperty.set(rdv);}
        public static ListProperty<RendezVous> listRDVProperty(){return rdvProperty;}
        
        
    public Medecin(String nom, String prenom, String identifiant, String mdp, ObservableList<RendezVous> rdv) {
        super(nom, prenom, identifiant, mdp);
        setListRDV(rdv);
    }  
    
    
    @Override
    public String toString() {
        return "Docteur "+getNom(); //To change body of generated methods, choose Tools | Templates.
    }

 
    
      
}
