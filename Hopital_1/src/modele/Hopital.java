/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author vicoste
 * la classe hopital contient toute les données persistantes qui compose un Hopipal, c'est a dire :
 *      -un liste d'employé (personnel)
 *      -une liste de patient (qu'ils soit malade ou non)
 *      -la liste des symptome repertorié
 *      -la liste des medicaments repertorié
 *      -la liste des fiches médicales concernant les patients malades (listeFicheTraite)
 *      -la liste de toutes les fiches Medicales (les archives en gros)
 *      
 *      
 * 
 */
public class Hopital {
    
    private final ObservableList<Personnel> listePers=FXCollections.observableArrayList();
    private final ListProperty<Personnel> listePersonnel = new SimpleListProperty<>(listePers);
        public  ObservableList<Personnel> getListePersonnel(){return listePersonnel.get();}
        public  void setListePersonnel(ObservableList<Personnel> p){listePersonnel.set(p);}
        public  ListProperty<Personnel> listePersonnel(){return listePersonnel;}
                
    private final ObservableList<FicheMedicale> listeFiche = FXCollections.observableArrayList();
    private final ListProperty<FicheMedicale> listeFicheMedicale = new SimpleListProperty<>(listeFiche);
        public ObservableList<FicheMedicale> getListeFicheMedicale(){return listeFicheMedicale.get();}
        public void setListeFicheMedicale(ObservableList<FicheMedicale> rdv){listeFicheMedicale.set(rdv);}
        public ListProperty<FicheMedicale> listeFicheMedicale(){return listeFicheMedicale;} 
    
    private final ObservableList<FicheMedicale> listeFicheTraite = FXCollections.observableArrayList();
    private final ListProperty<FicheMedicale> listeFicheMedicaleTraite = new SimpleListProperty<>(listeFicheTraite);
        public ObservableList<FicheMedicale> getListeFicheMedicaleTraite(){return listeFicheMedicaleTraite.get();}
        public void setListeFicheMedicaleTraite(ObservableList<FicheMedicale> rdv){listeFicheMedicaleTraite.set(rdv);}
        public ListProperty<FicheMedicale> listeFicheMedicaleTraite(){return listeFicheMedicaleTraite;} 
    
    private final ObservableList<Symptome> listeSymp=FXCollections.observableArrayList();
    private final ListProperty<Symptome> listeSymptome = new SimpleListProperty<>(listeSymp);
        public ObservableList<Symptome> getListeSymptome(){return listeSymptome.get();}
        public void setListeSymptome(ObservableList<Symptome> s){listeSymptome.set(s);}
        public ListProperty<Symptome> listeSymptome(){return listeSymptome;}
        
    private final ObservableList<Medicament> listMedic=FXCollections.observableArrayList();
    private final ListProperty<Medicament> listeMedicament = new SimpleListProperty<>(listMedic);
        public ObservableList<Medicament> getListeMedicament(){return listeMedicament.get();}
        public void setListeMedicament(ObservableList<Medicament> med){listeMedicament.set(med);}
        public ListProperty<Medicament> listeMedicament(){return listeMedicament;}
        
    private final ObservableList<Patient> listP = FXCollections.observableArrayList();
    private final ListProperty<Patient> listePatient = new SimpleListProperty<>(listP);
        public ObservableList<Patient> getListePatient(){return listePatient.get();}
        public void setlistePatient(ObservableList<Patient> patient){listePatient.set(patient);}
        public ListProperty<Patient> listePatient(){return listePatient;}


        
        /*
        Cette fonction est appelée a la fermeture du programme, elle permet de rendre toutes les
        listes du programme persistantes
        */
    public void serializerListes() {
        
        serializer(listP, "src/data/patient.ser");
        serializer(listMedic,"src/data/medicament.ser" );
        serializer(listeSymp, "src/data/symptome.ser");
        serializer(listeFiche, "src/data/ficheMedicale.ser");
        serializer(listePers, "src/data/personnel.ser");
        

        
    }
    
    public void deserializerListes(){
       
        deserializerPatient();
        deserializerMedicament();
        deserializerSymptome();
        deserializerFicheMedicale();
        deserializerPersonnel();
        
        actualiserFicheTraite();
        
       }
    
    public ListProperty<FicheMedicale> actualiserFicheTraite(){
        listeFicheMedicaleTraite.clear();
         listeFicheTraite.addAll(listeFiche.filtered((t) -> {
           return !t.getEtat(); //To change body of generated lambdas, choose Tools | Templates.
       }));
         return listeFicheMedicaleTraite;
    }
        /*
        LES FONCTIONS CE-DESSOUS SONT TOUTES LES FONCTIONS DE SERIALIZATION ET DESERIALIZATION 
        REGROUPEES RESPECTIVEMENT DANS LES FONCTIONS CI-DESSUS
        
        COMME LES OBSERVABLELIST NE SONT PAS SERIALIZABLE, JE LES TRAITE COMME DES ARRAYLIST
        */
    
    private void serializer(ObservableList object, String destination){         
       
        try(FileOutputStream fichier = new FileOutputStream(destination)) {                       
            ObjectOutputStream oos = new ObjectOutputStream(fichier);            
            oos.writeObject(new ArrayList<>(object));          
        
        } catch (final IOException e) {
            e.printStackTrace();           
        }
    }
   
     private void deserializerPersonnel(){
          
         try(FileInputStream fichier = new FileInputStream("src/data/personnel.ser")) {
            
            ObjectInputStream ois = new ObjectInputStream(fichier);            
            List<Personnel> list = (List<Personnel>) ois.readObject();            
            listePers.addAll(list);
            System.out.println(listePers);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            
        }
     }

    private void deserializerFicheMedicale(){
        
         try(FileInputStream fichier = new FileInputStream("src/data/ficheMedicale.ser")) {
            
            ObjectInputStream ois = new ObjectInputStream(fichier);            
            List<FicheMedicale> list = (List<FicheMedicale>) ois.readObject();            
            listeFiche.addAll(list);
            System.out.println(listeFiche);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            
        } 
    }
    
    private void deserializerMedicament(){
        
         try(FileInputStream fichier = new FileInputStream("src/data/medicament.ser")) {            
            ObjectInputStream ois = new ObjectInputStream(fichier);            
            List<Medicament> list = (List<Medicament>) ois.readObject();            
            listMedic.addAll(list);
            System.out.println(listMedic);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();            
        
        }
    }
      
    private void deserializerPatient(){
       
         try(FileInputStream fichier = new FileInputStream("src/data/patient.ser")) {
            
            ObjectInputStream ois = new ObjectInputStream(fichier);            
            List<Patient> list = (List<Patient>) ois.readObject();            
            listP.addAll(list);
            System.out.println(listP);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            
        }
    }
    
    private void deserializerSymptome(){
        
         try(FileInputStream fichier = new FileInputStream("src/data/symptome.ser")) {
            
            ObjectInputStream ois = new ObjectInputStream(fichier);            
            List<Symptome> list = (List<Symptome>) ois.readObject();            
            listeSymp.addAll(list);
            System.out.println(listeSymp);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            
        }
    }
 
}
