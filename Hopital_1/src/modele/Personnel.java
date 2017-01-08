/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;

/**
 *
 * @author vicoste
 * LePersonnel est un employé de l'Hopital, il a un identifiant et un mot de passe qui lui permette d'acceder
 * au logiciel.
 * Il peut créer des Patients, des FicheMedicale et des RendezVous
 * son role dans l'hopital n'est pas de soigner comme un medecin mais on peux le voir comme un
 * secretaire qui s'occupe de l'administration de l'hopital
 * 
 */
public class Personnel implements Serializable{
    private String nom; // le nom de l'employé
        public String getNom() {return nom;}
        public void setNom(String nom) {this.nom = nom;}

    private String prenom;// son prénom
        public String getPrenom() {return prenom;}
        public void setPrenom(String prenom) {this.prenom = prenom;}

    private String identifiant;//l'identifiant est généré automatiquement, il permet au Personnel de se connecter
        public String getIdentifiant() {return identifiant;}      

    private String mdp;// le mot de passe est choisis par l'administrateur lorsqu'il creer un nouveau personnel de la creation du Personnel
        public String getMdp() {return mdp;}
        public void setMdp(String mdp) {this.mdp = mdp;}
    
    public Personnel(String nom, String prenom, String mdp) {
        this.nom = nom;
        this.prenom = prenom;        
        this.mdp = mdp;
        /*
        l'identifiant est composé des 2 premieres lettres du prenom et des 6 lettres du nom
        */
        createID();
    }
   
    private void createID(){
        String n; //traite le nom
        String p;//traite le prenom        
        
        p=getPrenom().substring(0,2);
        n=getNom().substring(0, 6);
        
        identifiant = p+n; 
    }
    
    @Override
    public String toString() {
        return getNom(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
