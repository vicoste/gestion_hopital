/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javafx.collections.ObservableList;

/**
 *
 * @author vicoste
 * Un medicament permet de soigner un ou plusieurs symptomes 
 * 
 */
public class Medicament implements Serializable{
    
    private String nom; //le nom du medicament comment "dolipprane"
        public String getNom() {return nom;}
        public void setNom(String nom) {this.nom = nom;}
   
    private String description;// sa description comme on pourrait la trouver dans sa notice
        public String getDescription() {return description;}
        public void setDescription(String description) {this.description = description;}
    
    private ObservableList<Symptome> listeSymptome;//ceci est la liste des symptomes qui seront soignés par le medicament
        public ObservableList<Symptome> getListeSymptome() {return listeSymptome;}
        public void setListeSymptome(ObservableList<Symptome> listeSymptome) {this.listeSymptome = listeSymptome;}
    
    public Medicament(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
    
    @Override
    public String toString() {
        return getNom(); 
    }
    
}
