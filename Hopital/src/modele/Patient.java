/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author vicoste
 */
public class Patient {
    private String numSecu;
    private String nom;
    private String prenom;
    private int age;
    private Boolean sexe;       //rajout : pas present en ULM --> utilisé dans le numDssier  0=homme 1=femme

    public Patient(String numSecu, String nom, String prenom, int age, Boolean sexe) {
        this.numSecu = numSecu;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
    }
    
    

    /**
     * @return the numSecu
     */
    public String getNumSecu() {
        return numSecu;
    }

    /**
     * @param numSecu the numSecu to set
     */
    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the sexe
     */
    public Boolean getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(Boolean sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
       if(sexe) return "Mme "+nom;
       else return "Mr "+nom;
    }
    
}

