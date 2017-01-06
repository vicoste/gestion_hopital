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
public class Hopital {
    
    private ObservableList<Personnel> listePersonnel;
    private ObservableList<FicheMedicale> listeFicheMedicale;
    private ObservableList<Symptome> listeSymptome;
    private ObservableList<Medicament> listeMedicament;
    

    public ObservableList<FicheMedicale> getListeFicheMedicale() {
        return listeFicheMedicale;
    }

    public void setListeFicheMedicale(ObservableList<FicheMedicale> listeFicheMedicale) {
        this.listeFicheMedicale = listeFicheMedicale;
    }

    public ObservableList<Personnel> getListePersonnel() {
        return listePersonnel;
    }

    public void setListePersonnel(ObservableList<Personnel> listePersonnel) {
        this.listePersonnel = listePersonnel;
    }
    
    
    
    
}
