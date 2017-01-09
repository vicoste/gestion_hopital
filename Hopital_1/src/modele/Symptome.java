/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author vicoste
 * le symptome dont souffre le patient il a un nom et une description
 */
public class Symptome implements Serializable{
   
    private String nom;//exemple : migraine
        public String getNom() {return nom;}
        public void setNom(String nom) {this.nom = nom;}
    
    private String description;//exemple : type de céphalée (mal de tête) chronique fréquente, invalidante, caractérisée par des maux de tête et des nausées.
        public String getDescription() {return description;}
        public void setDescription(String description) {this.description = description;}
        
    public Symptome(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null)return false;        
        if (getClass() != obj.getClass())return false;
        
        final Symptome other = (Symptome) obj;
        if (!Objects.equals(this.nom, other.nom))return false;
        return true;
    }

   

    
    @Override
    public String toString() {
        return getNom(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
