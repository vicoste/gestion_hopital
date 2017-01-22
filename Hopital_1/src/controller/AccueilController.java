/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import launch.ControllerUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import modele.FicheMedicale;
import modele.Medecin;
import modele.Personnel;
import modele.RendezVous;

/**
 * FXML Controller class
 *
 * @author vicoste
 */
public class AccueilController implements Initializable {

    @FXML
    private Button ajoutPersonnel;
    @FXML
    private Button ajoutSymptome;
    @FXML
    private Button ajoutMedicament;
    @FXML
    private Button vueOrdonnance;
    @FXML
    private ListView<RendezVous> list;
    @FXML
    private GridPane gestionGrid;
    
    private static Personnel p = EcranLogController.getPersonnelConnecte();
        public static Personnel getPersonnel(){return p;}
        
    ControllerUtils a = new ControllerUtils();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        if(p.getNom()=="admin");
            else{            
        
            vueOrdonnance.setVisible(false);
            gestionGrid.setVisible(false);
            if(p.isMedecin()){
                Medecin m = (Medecin) p;
                list.setVisible(true);
                list.setItems(FXCollections.observableArrayList(m.getListeRdv()));
                vueOrdonnance.setVisible(true);                
            }
        }
    }    

    @FXML
    private void handleButtonFM(ActionEvent event) throws IOException{
  
       a.borderPaneLoad(EcranLogController.getStage(), "/ihm/FM.fxml");       
    }

    @FXML
    private void handleButtonRDV(ActionEvent event) throws IOException{

        a.borderPaneLoad(EcranLogController.getStage(), "/ihm/RDV.fxml");
    }
    
    @FXML
    private void handleButtonLogout(ActionEvent event) throws IOException{
       a.deconnection();
    }


    @FXML
    private void handleButtonOrdonnance(ActionEvent event) throws IOException {
       
        FicheMedicale p = list.getSelectionModel().getSelectedItem().getFiche();
        
        
        if(p != null){
            OrdonnanceController.setFicheMedicale(p);
            a.borderPaneLoad(EcranLogController.getStage(), "/ihm/Ordonnance.fxml");
        } else{
            a.showMessage(Alert.AlertType.ERROR, null, "veuillez selectionner une Ordonnance");
        }
    }

    @FXML
    private void Personnel(ActionEvent event) throws IOException {
        a.borderPaneLoad(EcranLogController.getStage(), "/ihm/GestionPersonnel.fxml");
    }

    @FXML
    private void AjoutSymp(ActionEvent event) throws IOException {
       
        a.borderPaneLoad(EcranLogController.getStage(), "/ihm/AjoutSymptome.fxml");
    }

    @FXML
    private void AjoutMedic(ActionEvent event) throws IOException {
        
        a.borderPaneLoad(EcranLogController.getStage(), "/ihm/GestionMedicaments.fxml");
    }  
}
