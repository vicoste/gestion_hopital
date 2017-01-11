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
 */
public class Hopital {
    
    private final ObservableList<Personnel> listePers=FXCollections.observableArrayList();
    private ListProperty<Personnel> listePersonnel = new SimpleListProperty<>(listePers);
        public  ObservableList<Personnel> getListePersonnel(){return listePersonnel.get();}
        public  void setListePersonnel(ObservableList<Personnel> p){listePersonnel.set(p);}
        public  ListProperty<Personnel> listePersonnel(){return listePersonnel;}
        
    private ObservableList<FicheMedicale> listeFiche = FXCollections.observableArrayList();
    private final ListProperty<FicheMedicale> listeFicheMedicale = new SimpleListProperty<>(listeFiche);
        public ObservableList<FicheMedicale> getListeFicheMedicale(){return listeFicheMedicale.get();}
        public void setListeFicheMedicale(ObservableList<FicheMedicale> rdv){listeFicheMedicale.set(rdv);}
        public ListProperty<FicheMedicale> listeFicheMedicale(){return listeFicheMedicale;} 
    
    private ObservableList<Symptome> listeSymp=FXCollections.observableArrayList();
    private ListProperty<Symptome> listeSymptome = new SimpleListProperty<>(listeSymp);
        public ObservableList<Symptome> getListeSymptome(){return listeSymptome.get();}
        public void setListeSymptome(ObservableList<Symptome> s){listeSymptome.set(s);}
        public ListProperty<Symptome> listeSymptome(){return listeSymptome;}
        
    private ObservableList<Medicament> listMedic=FXCollections.observableArrayList();
    private ListProperty<Medicament> listeMedicament = new SimpleListProperty<>(listMedic);
        public ObservableList<Medicament> getListeMedicament(){return listeMedicament.get();}
        public void setListeMedicament(ObservableList<Medicament> med){listeMedicament.set(med);}
        public ListProperty<Medicament> listeMedicament(){return listeMedicament;}
        
    private ObservableList<RendezVous> listRDV = FXCollections.observableArrayList();
    private final ListProperty<RendezVous> listeRendezVous = new SimpleListProperty<>(listRDV);
        public ObservableList<RendezVous> getListeRendezVous(){return listeRendezVous.get();}
        public void setListeRendezVous(ObservableList<RendezVous> rdv){listeRendezVous.set(rdv);}
        public ListProperty<RendezVous> listeRendezVous(){return listeRendezVous;}
        
    private ObservableList<Patient> listP = FXCollections.observableArrayList();
    private ListProperty<Patient> listePatient = new SimpleListProperty<>(listP);
        public ObservableList<Patient> getListePatient(){return listePatient.get();}
        public void setlistePatient(ObservableList<Patient> patient){listePatient.set(patient);}
        public ListProperty<Patient> listePatient(){return listePatient;}
    

        
        /*
        Cette fonction est appelée a la fermeture du programme, elle permet de rendre toutes les
        listes du programme persistantes
        */
    public void serializerListes() {
   
        serializerPatient();
        serializerMedicament();
        serializerSymptome();
        serializerFicheMedicale();
        serializerRendezVous();
        serializerPersonnel();
        
        
    }
    
    public void deserializerListes(){
       
        deserializerPatient();
        deserializerMedicament();
        deserializerSymptome();
        deserializerFicheMedicale();
        deserializerRendezVous();
        deserializerPersonnel();
        
       }
        /*
        LES FONCTIONS CE-DESSOUS SONT TOUTES LES FONCTIONS DE SERIALIZATION ET DESERIALIZATION 
        REGROUPEES RESPECTIVEMENT DANS LES FONCTIONS CI-DESSUS
        
        COMME LES OBSERVABLELIST NE SONT PAS SERIALIZABLE, JE LES TRAITE COMME DES ARRAYLIST
        */
        
    private void serializerPersonnel(){
   
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream("src/data/personnel.ser");            
            oos = new ObjectOutputStream(fichier);            
            oos.writeObject(new ArrayList<>(listePers)); 
            oos.flush();
            
        } catch (final IOException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
                
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
     }
     private void deserializerPersonnel(){
          ObjectInputStream ois = null;
         try {
            final FileInputStream fichier = new FileInputStream("src/data/personnel.ser");
            ois = new ObjectInputStream(fichier);            
            List<Personnel> list = (List<Personnel>) ois.readObject();            
            listePers.addAll(list);
            System.out.println(listePers);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                
            } catch (final IOException ex) {
            ex.printStackTrace();
            }
        }
     }
     
     
     
     
    private void serializerFicheMedicale(){         
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream("src/data/ficheMedicale.ser");            
            oos = new ObjectOutputStream(fichier);            
            oos.writeObject(new ArrayList<>(listeFiche)); 
            oos.flush();
            
        } catch (final IOException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
                
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void deserializerFicheMedicale(){
        ObjectInputStream ois = null;
         try {
            final FileInputStream fichier = new FileInputStream("src/data/ficheMedicale.ser");
            ois = new ObjectInputStream(fichier);            
            List<FicheMedicale> list = (List<FicheMedicale>) ois.readObject();            
            listeFiche.addAll(list);
            System.out.println(listeFiche);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                
            } catch (final IOException ex) {
            ex.printStackTrace();
            }
        }
    }
     
     
    private void serializerMedicament(){         
       
        try(FileOutputStream fichier = new FileOutputStream("src/data/medicament.ser")) {                       
            ObjectOutputStream oos = new ObjectOutputStream(fichier);            
            oos.writeObject(new ArrayList<>(listMedic));          
        
        } catch (final IOException e) {
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
     
     
    private void serializerRendezVous(){         
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream("src/data/rendezVous.ser");            
            oos = new ObjectOutputStream(fichier);            
            oos.writeObject(new ArrayList<>(listRDV)); 
            oos.flush();
            
        } catch (final IOException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
                
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void deserializerRendezVous(){
        ObjectInputStream ois = null;
         try {
            final FileInputStream fichier = new FileInputStream("src/data/rendezVous.ser");
            ois = new ObjectInputStream(fichier);            
            List<RendezVous> list = (List<RendezVous>) ois.readObject();            
            listRDV.addAll(list);
            System.out.println(listRDV);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                
            } catch (final IOException ex) {
            ex.printStackTrace();
            }
        }
    }  
     
     
    private void serializerPatient(){         
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream("src/data/patient.ser");            
            oos = new ObjectOutputStream(fichier);            
            oos.writeObject(new ArrayList<>(listP)); 
            oos.flush();
            
        } catch (final IOException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
                
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void deserializerPatient(){
        ObjectInputStream ois = null;
         try {
            final FileInputStream fichier = new FileInputStream("src/data/patient.ser");
            ois = new ObjectInputStream(fichier);            
            List<Patient> list = (List<Patient>) ois.readObject();            
            listP.addAll(list);
            System.out.println(listP);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                
            } catch (final IOException ex) {
            ex.printStackTrace();
            }
        }
    }
         
    private void serializerSymptome(){         
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream("src/data/symptome.ser");            
            oos = new ObjectOutputStream(fichier);            
            oos.writeObject(new ArrayList<>(listeSymp)); 
            oos.flush();
            
        } catch (final IOException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
                
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void deserializerSymptome(){
        ObjectInputStream ois = null;
         try {
            final FileInputStream fichier = new FileInputStream("src/data/symptome.ser");
            ois = new ObjectInputStream(fichier);            
            List<Symptome> list = (List<Symptome>) ois.readObject();            
            listeSymp.addAll(list);
            System.out.println(listeSymp);                
        
        } catch (final java.io.IOException e) {
            e.printStackTrace();
            
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                
            } catch (final IOException ex) {
            ex.printStackTrace();
            }
        }
    }
     
    
    
     
    
    
    
}
