package launch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;
import modele.FicheMedical;
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
import modele.RendezVous;
import modele.Symptome;


public class Main extends Application {
  
    private static Stage primaryStage;
    private static Stage stage = new Stage();
    private static ObservableList<Symptome> listSymp = FXCollections.observableArrayList();
    private static ObservableList<RendezVous> listRDV = FXCollections.observableArrayList();
    private static ObservableList<FicheMedical> listFM = FXCollections.observableArrayList();
    private static ObservableList<Medecin> listMed = FXCollections.observableArrayList();
   
    //FONCTION MAIN

    @Override
    public void start(Stage primaryStage) {
        
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
    
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static Stage getStage(){
        return stage;
    }
    
    
    //FONCTION CREATION
    
    private void CreateListFM(){
        
        Patient a = new Patient("165464", "pierre", "letest", 20, Boolean.FALSE);
        Patient b = new Patient("165464", "pierre", "letest", 20, Boolean.TRUE);
        Patient c = new Patient("165464", "pierre", "letest", 18, Boolean.FALSE);
        Patient d = new Patient("165464", "pierre", "letest", 50, Boolean.TRUE );
        Patient f = new Patient("165464", "pierre", "letest", 20, Boolean.FALSE);
        FicheMedical f1 = new FicheMedical("depuis 3 jour ne peux plus défequer", a, getSymptome());
        FicheMedical f2 = new FicheMedical("depuis 3 jour ne peux plus défequer", a, getSymptome());
        FicheMedical f3 = new FicheMedical("depuis 3 jour ne peux plus défequer", a, getSymptome());
        FicheMedical f4 = new FicheMedical("depuis 3 jour ne peux plus défequer", a, getSymptome());
        FicheMedical f5 = new FicheMedical("depuis 3 jour ne peux plus défequer", a, getSymptome());
        
        listFM.addAll(f1,f2,f3,f4,f5);
    }
    
    private void CreateListSymp(){
        
        
        Symptome mauxDeTete = new Symptome("Maux de Tete", "une douleur dans la tete");
        Symptome malDeVentre = new Symptome("Mal de Ventre","douleur dans le ventre");
        Symptome brasCasse = new Symptome("Bras Cassé", "L'os du bras a rompu");
        Symptome jambeCasse = new Symptome("Jambe Cassé", "l'os de la jambe a rompu");
        
        for(int i=0;i<20;i++){
            Symptome troll = new Symptome("aie", "lol");
            listSymp.add(troll);
        }
        
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
    
    
    public static ObservableList<Symptome> getSymptome(){
        return listSymp;
    }  
    
    public static ObservableList<RendezVous> getListRDV() {
       return listRDV;
    }
    
    public static void setListRDV(RendezVous r){
        listRDV.add(r);
    }
    
    public static ObservableList<FicheMedical> getListFM() {
        return listFM;
    }

    public static ObservableList<Medecin> getListMed() {
        return listMed;
    }
    
    
    
}   
    