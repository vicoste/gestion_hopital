/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author vicoste
 */
public class Medecin extends PersonnelHospitalier{
    private String specialite;

    public Medecin(String nom, String prenom, String identifiant, String mdp) {
        super(nom, prenom, identifiant, mdp);
    }

    
    
    
    public void analyse(Symptome a, Boolean machine){
        
    }

    @Override
    public void analyse(Symptome a) {
        
    }
    
}
