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
public class Medecin extends Personnel{
    
    private static ObservableList<RendezVous> listRDV;
        
    public Medecin(String nom, String prenom, String identifiant, String mdp) {
        super(nom, prenom, identifiant, mdp);
    }  
    
    
    @Override
    public String toString() {
        return "Docteur "+getNom(); //To change body of generated methods, choose Tools | Templates.
    }

    public static ObservableList<RendezVous> getListRDV() {
        return listRDV;
    }

    public static void  setListRDV(ObservableList<RendezVous> listRDV) {
        Medecin.listRDV = listRDV;
    }
    
      
}
