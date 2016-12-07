package launch;

import controller.FicheMedical;
import controller.Patient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/EcranLog.fxml"));
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) {
        launch(args);
        //Patient p = new Patient(null, "pierre", "paul", "15", Boolean.TRUE);
        //FicheMedical f =new FicheMedical( "dedede",p, null);
        
    }
}