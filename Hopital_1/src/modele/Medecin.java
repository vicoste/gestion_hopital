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
 * Un Medecin est un Personnel qui a plus de pouvoir, en effet le medecin peux soigné des malade alors qu'un 
 * secrétaire ne pourra que les enregistrer
 * le medecin dispose d'une liste de rendezVous qui lui est propre, cellle des patient qu'il doit traité
 * 
 */
public class Medecin extends Personnel{
    
    private static ObservableList<RendezVous> listRDV = FXCollections.observableArrayList();//sa liste de rendez-vous
    private final static ListProperty<RendezVous> rdvProperty = new SimpleListProperty<>(listRDV);
        public static ObservableList<RendezVous> getListRDV(){return rdvProperty.get();}
        public static void setListRDV(ObservableList<RendezVous> rdv){rdvProperty.set(rdv);}
        public static ListProperty<RendezVous> listRDVProperty(){return rdvProperty;}
        
    /* a sa creation, le medecin n'a pas encore de rendezVous*/    
    public Medecin(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
        ;
    }  

    @Override
    public boolean isMedecin() {
        return true; 
    }
    
    
    @Override
    public String toString() {
        return "Docteur "+getNom(); 
    }

 
    
      
}
