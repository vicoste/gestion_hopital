/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import launch.Main;
import modele.Patient;
import modele.Symptome;

/**
 * FXML Controller class
 *
 * @author Virgile
 */
public class AddFMController implements Initializable {

    
    @FXML
    private ComboBox<String> cbPatient;
    @FXML
    private ComboBox<Symptome> selecSymp;
    @FXML
    private TextArea taMotif;
    @FXML
    private ListView<Symptome> listSymp;

    private ObservableList<Symptome> ls = FXCollections.observableArrayList();
    private ObservableList<Symptome> listeDansCB = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeDansCB.setAll(Main.getSymptome());
        selecSymp.setItems(listeDansCB);
        
        
        cbPatient.setItems(FXCollections.observableArrayList(        "Option 1",        "Option 2",        "Option 3"    ));
        
    }    

    @FXML
    private void handleButtonCreate(ActionEvent event) {
        
        System.out.println(ls);
        FMController.getStage().hide();
    }
    
    @FXML
    private void handleButtonRetour(ActionEvent event) {
        
    }
    
    @FXML
    private void handleButtonSupp(ActionEvent event) {
        if(listSymp.getSelectionModel().getSelectedItem()==null) {
            showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner un Symptôme.");
        } 
        else {
            showMessage(Alert.AlertType.CONFIRMATION, null, "Etes vous sur de vouloir supprimer ?");            
            selecSymp.getItems().add(listSymp.getSelectionModel().getSelectedItem());
            ls.remove(listSymp.getSelectionModel().getSelectedIndex()); 
        }
    }
    
    @FXML
    private void handleButtonAddPatient(ActionEvent event) throws IOException{
        GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("/ihm/CreerPatient.fxml"));
        Scene scene = new Scene(root);
        Stage st = FMController.getStage();
        st.setScene(scene);
        st.setResizable(false);
        
    }

    @FXML
    private void handleButtonAddSymp(ActionEvent event) {
        
    }
    
    @FXML
    private void handleButtonOKSymp(ActionEvent event){
        ls.add(selecSymp.getSelectionModel().getSelectedItem());
        listeDansCB.remove(selecSymp.getSelectionModel().getSelectedIndex());
        listSymp.setItems(ls);                  
        selecSymp.getSelectionModel().clearSelection();
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
    
}
