/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launch;

import controller.EcranLogController;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import launch.Main;

/**
 *
 * @author vicoste
 * cette classe sert a regrouper les methodes utiles aux controller
 */
public class ControllerUtils {
    
    public void deconnection() throws IOException{
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/EcranLog.fxml"));
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
        Main.getStage().show();
        EcranLogController.getStage().hide();
    
    }
    
    
    public Stage gridPaneLoad(Stage initOwner, String chemin, boolean resize)throws IOException{
               
        GridPane root = (GridPane) FXMLLoader.load(getClass().getResource(chemin));
        Scene scene = new Scene(root, 400, 400);//ATTENTION A LA TAILLE
        Stage st = new Stage();
        st.initOwner(initOwner);
        st.initModality(Modality.WINDOW_MODAL);
        st.setScene(scene);
        st.setResizable(resize);
        return st;
    }
    
    public Stage gridPaneLoad(Stage initOwner, String chemin)throws IOException{
        return gridPaneLoad(initOwner, chemin, true);
        
    }

    public Stage borderPaneLoad(Stage initOwner, String chemin, boolean resize)throws IOException{
        
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource(chemin));
        Scene scene = new Scene(root, 400, 400);//ATTENTION A LA TAILLE
        Stage st = new Stage();
        st.initOwner(initOwner);
        st.initModality(Modality.WINDOW_MODAL);
        st.setScene(scene);
        st.setResizable(resize);        
        st.show();
        
        return st;
        
    }
    
    public Stage borderPaneLoad(Stage initOwner, String chemin) throws IOException{
        return borderPaneLoad(initOwner, chemin, true);
    }
    
    
    public Optional<ButtonType> showMessage(Alert.AlertType type,String header,String message,ButtonType... lesBoutonsDifferents){
        Alert laFenetre = new Alert(type);
        laFenetre.setHeaderText(header);
        laFenetre.setContentText(message);
        if (lesBoutonsDifferents.length > 0) {
            laFenetre.getButtonTypes().clear();
            laFenetre.getButtonTypes().addAll(lesBoutonsDifferents);
        }
        return laFenetre.showAndWait();
    }
        
}
