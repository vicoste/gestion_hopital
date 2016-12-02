/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author vicoste
 */
public class Patient {
    private String numSecu;
    private String nom;
    private String prenom;
    private String age;

    public Patient(String numSecu, String nom, String prenom, String age) {
        this.numSecu = numSecu;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
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
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }
}
