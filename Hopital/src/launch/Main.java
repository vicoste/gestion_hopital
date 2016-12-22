package launch;

import java.io.IOException;
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
import modele.RendezVous;
import modele.Symptome;


public class Main extends Application {
  
    private static Stage primaryStage;
    private static Stage stage = new Stage();
   
    private static  ObservableList<RendezVous> listRDV = FXCollections.observableArrayList();
    private static ObservableList<FicheMedical> listFM = FXCollections.observableArrayList();
    
   


    @Override
    public void start(Stage primaryStage) {
        
       
        
        try {            
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/EcranLog.fxml"));
            Scene scene = new Scene(root, 600, 400);
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
    
    public static ObservableList<Symptome> getSymptome(){
        ObservableList<Symptome> listSymp = FXCollections.observableArrayList();
        
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
        
        return listSymp;
    }  
    public static ObservableList<RendezVous> getListRDV() {
       
        
       
        
        
        return listRDV;
    }
    public static void setListRDV(RendezVous r){
        listRDV.add(r);
    }
    
    public static ObservableList<FicheMedical> getListFM() {
        
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
        return listFM;
    }
}   
    