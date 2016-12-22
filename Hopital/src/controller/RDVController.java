/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import launch.Main;
import modele.RendezVous;
import modele.Symptome;

/**
 * FXML Controller class
 *
 * @author vicoste
 */
public class RDVController implements Initializable {

    @FXML
    private ListView<RendezVous> list;
   
    private static Stage st = new Stage();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        list.setItems(Main.getListRDV());
    }    
    
    public void handleButtonAjouter(ActionEvent event) throws IOException{
         GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("/ihm/SelectFM.fxml"));
            Scene scene = new Scene(root);
            st.initOwner(Main.getPrimaryStage());
            st.initModality(Modality.WINDOW_MODAL);
            st.setScene(scene);
            st.showAndWait();
    }
    public void handleButtonSupprimer(ActionEvent event) throws IOException{
    
    }
    public void handleButtonModifier(ActionEvent event) throws IOException{
    
    }

    public static Stage getStage() {
        return st;
    }
    
}
        