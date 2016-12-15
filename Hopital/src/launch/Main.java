package launch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modele.FicheMedical;
import modele.Patient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import modele.Symptome;


public class Main extends Application {
  
    private static Stage primaryStage;
    private static Stage stage = new Stage();
    private static List<Symptome> listSymp=new ArrayList<Symptome>();
    
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
        Symptome mauxDeTete = new Symptome("Maux de Tete", "une douleur dans la tete");
        Symptome malDeVentre = new Symptome("Mal de Ventre","douleur dans le ventre");
        Symptome brasCasse = new Symptome("Bras Cassé", "L'os du bras a rompu");
        Symptome jambeCasse = new Symptome("Jambe Cassé", "l'os de la jambe a rompu");
        
        listSymp.add(mauxDeTete);
        listSymp.add(malDeVentre);
        listSymp.add(jambeCasse);
        listSymp.add(brasCasse);
        
        launch(args);
        
    }
    
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static Stage getStage(){
        return stage;
    }
    
    public static List<Symptome> getSymptome(){
        return listSymp;
    }
}