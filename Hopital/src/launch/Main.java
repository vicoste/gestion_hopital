package launch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modele.FicheMedicale;
import modele.Patient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import modele.Medecin;
import modele.Personnel;
import modele.RendezVous;
import modele.Symptome;


public class Main extends Application {
  
    private static Stage primaryStage;
    private static Stage stage = new Stage();
    
    private static ObservableList<Symptome> listSymp = FXCollections.observableArrayList();
    private static ObservableList<RendezVous> listRDV = FXCollections.observableArrayList();
    private static ObservableList<FicheMedicale> listFM = FXCollections.observableArrayList();
    private static ObservableList<Medecin> listMed = FXCollections.observableArrayList();
    private static ObservableList<Patient> listPat = FXCollections.observableArrayList();
    private static ObservableList<Personnel> listPers = FXCollections.observableArrayList();
    //FONCTION MAIN

   

    @Override
    public void start(Stage primaryStage) {     //DEMANDER AU PROF COMMENT LANCER UNE SERIALISATION A LA FERMETURE DU PROG
       
        SerializerPatient();
        DeserializerPatient();
        CreateListSymp();
        CreateListFM();        
        CreateListMedecin();
      
        try {            
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/EcranLog.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) {      
        launch(args);     
    }
    
    //FONCTIONS SERILIZATION
    
     private void SerializerPatient(){
        final Patient patient = new Patient("numsécu","Dupond", "Jean", 18, false);
        final Patient patient1 = new Patient("nuqdsdqsdcu","durand", "didier", 15, false);
        ObjectOutputStream oos = null;

        try {
            final FileOutputStream fichier = new FileOutputStream("src/data/patient.ser");
            oos = new ObjectOutputStream(fichier);            
            oos.writeObject(patient);
            oos.writeObject(patient1);
            
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
     
     private void DeserializerPatient(){
         ObjectInputStream ois = null;
         try {
            final FileInputStream fichier = new FileInputStream("src/data/patient.ser");
            ois = new ObjectInputStream(fichier);
            final Patient patient = (Patient) ois.readObject();
            
            System.out.println("Personne : ");
            System.out.println("nom : " + patient.getNom());
            System.out.println("prenom : " + patient.getPrenom());
            System.out.println("num secur : " + patient.getNumSecu());
            System.out.println("age : " + patient.getAge());
             setListPat(patient);
            
            final Patient patient1 = (Patient) ois.readObject();
            
            System.out.println("Personne : ");
            System.out.println("nom : " + patient1.getNom());
            System.out.println("prenom : " + patient1.getPrenom());
            System.out.println("num secur : " + patient1.getNumSecu());
            System.out.println("age : " + patient1.getAge());
             setListPat(patient1);
            
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
     
    
   
    
    
    //FONCTION CREATION
    
   
    
    private void CreateListFM(){
        
        Patient a = new Patient("165464", "pierre", "letest", 20, Boolean.FALSE);
        Patient b = new Patient("165464", "pierre", "letest", 20, Boolean.TRUE);
        Patient c = new Patient("165464", "pierre", "letest", 18, Boolean.FALSE);
        Patient d = new Patient("165464", "pierre", "letest", 50, Boolean.TRUE );
        Patient f = new Patient("165464", "pierre", "letest", 20, Boolean.FALSE);
        FicheMedicale f1 = new FicheMedicale("depuis 3 jour ne peux plus défequer", a, getSymptome());
        FicheMedicale f2 = new FicheMedicale("depuis 3 jour ne peux plus défequer", a, getSymptome());
        FicheMedicale f3 = new FicheMedicale("depuis 3 jour ne peux plus défequer", a, getSymptome());
        FicheMedicale f4 = new FicheMedicale("depuis 3 jour ne peux plus défequer", a, getSymptome());
        FicheMedicale f5 = new FicheMedicale("depuis 3 jour ne peux plus défequer", a, getSymptome());
        
        listFM.addAll(f1,f2,f3,f4,f5);
   
 
       
   
        
    }
    
    private void CreateListSymp(){
        
        
        Symptome mauxDeTete = new Symptome("Maux de Tete", "une douleur dans la tete");
        Symptome malDeVentre = new Symptome("Mal de Ventre","douleur dans le ventre");
        Symptome brasCasse = new Symptome("Bras Cassé", "L'os du bras a rompu");
        Symptome jambeCasse = new Symptome("Jambe Cassé", "l'os de la jambe a rompu");
        
        
        
        listSymp.add(mauxDeTete);
        listSymp.add(malDeVentre);
        listSymp.add(jambeCasse);
        listSymp.add(brasCasse);   
    }
    
    private void CreateListMedecin(){
        
   
        Medecin m1 = new Medecin("arthur", "rimbow", "baudelaire", "love");
        Medecin m2 = new Medecin("georges", "sand", "baudelaire", "love");
        Medecin m3 = new Medecin("guillaume", "appolinaire", "baudelaire", "love");
        Medecin m4 = new Medecin("philipe", "etchebest", "baudelaire", "love");
        
        listMed.addAll(m1,m2,m3,m4);
        
    }
    

    
    
    
    
    
    
    
    //GETTER ET SETTER
    
    
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static Stage getStage(){
        return stage;
    } 
    public static ObservableList<Symptome> getSymptome(){
        return listSymp;
    }  
    
    public static ObservableList<RendezVous> getListRDV() {
       return listRDV;
    }
    
    public static void setListRDV(RendezVous r){
        listRDV.add(r);
    }
    
    public static void delListRDV(RendezVous r){
        
        listRDV.remove(r);
        
    } 
    
    public static ObservableList<FicheMedicale> getListFM() {
        return listFM;
    }

    public static void setListFM(FicheMedicale fm) {
        listFM.add(fm);
    }
    
    public static ObservableList<Medecin> getListMed() {
        return listMed;
    }

    public static void setListPat(Patient p) {
        listPat.add(p);
    }

    public static ObservableList<Patient> getListPat() {
        return listPat;
    }
    
     public static void delListFM(FicheMedicale fm) {
        listFM.remove(fm);
    }

    public static void setPers(Personnel p) {
        //EN COURS : DEFINIR SI LE PERSONNEL EST UN MEDECIN OU NON 
    }

    public static ObservableList<Personnel> getListPers() {
        return listPers;
    }

    public static void delPers(Personnel p){
        
    }
    
}   
    