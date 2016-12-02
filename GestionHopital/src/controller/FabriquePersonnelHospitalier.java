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
abstract class FabriquePersonnelHospitalier {
    private List<Symptome> listSymp2;
    private ControleurMedecin controler;

    public FabriquePersonnelHospitalier(List<Symptome> listSymp2, ControleurMedecin controler) {
        this.listSymp2 = listSymp2;
        this.controler = controler;
    }
    
    
    abstract void analysePro(Symptome a );
    
    public void analyse(Symptome a){
        
    }
    
    
}
