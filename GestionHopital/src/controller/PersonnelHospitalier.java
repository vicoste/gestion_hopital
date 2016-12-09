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
abstract class PersonnelHospitalier extends Personnel{
    private List<Symptome> listSymp2;
    

    public PersonnelHospitalier(List<Symptome> listSymp2) {
        this.listSymp2 = listSymp2;
        
    }
    
    
    
    
    public void analyse(Symptome a){
        
    }
    
    
}
