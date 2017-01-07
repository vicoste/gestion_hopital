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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import launch.Main;

/**
 * FXML Controller class
 *
 * @author vicoste
 */
public class AccueilController implements Initializable {

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonFM(ActionEvent event) throws IOException{
     
       BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/FM.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);
        st.show();
            
    }

    @FXML
    private void handleButtonRDV(ActionEvent event) throws IOException{
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/RDV.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();
    }
    
    @FXML
    private void handleButtonLogout(ActionEvent event) throws IOException{
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/EcranLog.fxml"));
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
        Main.getStage().show();
        EcranLogController.getStage().hide();
    }

    @FXML
    private void handleButtonPersonnel(ActionEvent event) {
    }

    @FXML
    private void handleButtonOrdonnance(ActionEvent event) {
    }
   
    
}
