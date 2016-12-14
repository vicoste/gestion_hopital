package launch;

import java.io.IOException;
import modele.FicheMedical;
import modele.Patient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
  
    private static Stage primaryStage;
   
   @Override
    public void start(Stage primaryStage) {
        
        try {
               
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/EcranLog.fxml"));
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
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
}