/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import launch.ControllerUtils;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import launch.Main;
import modele.FicheMedicale;
import modele.Patient;
import modele.Symptome;

/**
 * FXML Controller class
 *
 * @author Virgile
 */
public class AddFMController implements Initializable {

    
    @FXML
    private ComboBox<Patient> cbPatient;
    @FXML
    private ComboBox<Symptome> selecSymp;
    @FXML
    private TextArea taMotif;
    @FXML
    private ListView<Symptome> listSymp;

    private ObservableList<Symptome> ls = FXCollections.observableArrayList();
    private ObservableList<Symptome> listeDansCB = FXCollections.observableArrayList();
    
    ControllerUtils a = new ControllerUtils();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listeDansCB.addAll(Main.getHopital().listeSymptome());
        selecSymp.setItems(listeDansCB);        
        
        cbPatient.itemsProperty().bind(Main.getHopital().listePatient());
        
    }    

    @FXML
    private void handleButtonCreate(ActionEvent event) {
        FicheMedicale ficheMedicale = new FicheMedicale(taMotif.getText(),cbPatient.getValue(),ls);
        Main.getHopital().getListeFicheMedicale().add(ficheMedicale);
        FMController.getStage().hide();
    }
    
    @FXML
    private void handleButtonRetour(ActionEvent event) {
        FMController.getStage().hide();
    }
    
    @FXML
    private void handleButtonSupp(ActionEvent event) {
        if(listSymp.getSelectionModel().getSelectedItem()==null) {
            a.showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner un Symptôme.");
        } 
        else {
            a.showMessage(Alert.AlertType.CONFIRMATION, null, "Etes vous sur de vouloir supprimer ?");            
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
    private void handleButtonOKSymp(ActionEvent event){
        ls.add(selecSymp.getSelectionModel().getSelectedItem());
        listeDansCB.remove(selecSymp.getSelectionModel().getSelectedIndex());
        listSymp.setItems(ls);                  
        selecSymp.getSelectionModel().clearSelection();
    }
    
    
}
