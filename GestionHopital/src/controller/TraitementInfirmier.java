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
public class TraitementInfirmier extends Traitement{

    private List<Medicament> listMedic;
    private FicheMedical fiche;

    public TraitementInfirmier(List<Medicament> listMedic, FicheMedical fiche) {
        this.listMedic = listMedic;
        this.fiche = fiche;
    }
    
    
    @Override
    public void soigner(Medicament a) {
        fiche.setEtat(Boolean.TRUE);
    }
    
    
}
