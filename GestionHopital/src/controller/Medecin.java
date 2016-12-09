/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;

/**
 *
 * @author vicoste
 */
public class Medecin extends PersonnelHospitalier{
    private String specialite;

    public Medecin(List<Symptome> listSymp2 ) {
        super(listSymp2);
    }
    
    
    public void analyse(Symptome a, Boolean machine){
        
    }

    @Override
    public void analyse(Symptome a) {
        
    }
    
}
