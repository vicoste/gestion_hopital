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
public class Medecin extends FabriquePersonnelHospitalier{

    public Medecin(List<Symptome> listSymp2, ControleurMedecin controler) {
        super(listSymp2, controler);
    }
    
    @Override
    public void analysePro(Symptome a){
        
    }
    
}
