/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import launch.Main;
import modele.Medecin;
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
    
    private static Stage stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        list.setItems(Main.getListRDV());
    }    
    
    @FXML
    private void handleButtonAjouter(ActionEvent event) throws IOException{
        GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("/ihm/SelectFM.fxml"));
        Scene scene = new Scene(root);
        Stage st = new Stage();
        st.initOwner(AccueilController.getStage());
        st.initModality(Modality.WINDOW_MODAL);
        st.setScene(scene);
        st.setResizable(false);
        stage=st;
        st.show();
    }
    @FXML
    private void handleButtonSupprimer(ActionEvent event) throws IOException{
        if(list.getSelectionModel().getSelectedItem()==null) {
            showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner un RDV. Veuillez recommencer");
        } 
        else {
            showMessage(Alert.AlertType.CONFIRMATION, null, "Etes vous sur de vouloir supprimer ?");
            
            
                
                list.getSelectionModel().clearSelection();
            }
            
            
             
        }
    
    @FXML
    private void handleButtonModifier(ActionEvent event) throws IOException{
        if(list.getSelectionModel().getSelectedItem()==null) {
            showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner une RDV. Veuillez recommencer");
        } 
        else {
        
            //ACTION A CODER
             
        }
    }
    @FXML
    private void handleButtonLogout(ActionEvent event) throws IOException{
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/EcranLog.fxml"));
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
        Main.getStage().show();
        EcranLogController.getStage().hide();
        AccueilController.getStage().hide();
    }
    
    private Optional<ButtonType> showMessage(Alert.AlertType type,String header,String message,ButtonType... lesBoutonsDifferents){
        Alert laFenetre = new Alert(type);
        laFenetre.setHeaderText(header);
        laFenetre.setContentText(message);
        if (lesBoutonsDifferents.length > 0) {
            laFenetre.getButtonTypes().clear();
            laFenetre.getButtonTypes().addAll(lesBoutonsDifferents);
        }
        return laFenetre.showAndWait();
    }

    public static Stage getStage() {
        return stage;
    }
    
}
        