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
abstract class PersonnelHospitalier extends Personnel{
    private List<Symptome> listSymp2;

    public PersonnelHospitalier(String nom, String prenom, String identifiant, String mdp) {
        super(nom, prenom, identifiant, mdp);
    }
    
    
    public void consultation()
    {
        
    }
    
    
    public void analyse(Symptome a){
        
    }
    
    
}
