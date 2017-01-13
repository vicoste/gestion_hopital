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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import launch.Main;
import modele.FicheMedicale;

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
    private ComboBox<FicheMedicale> selectionPatient;
    
    ControllerUtils a = new ControllerUtils();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        selectionPatient.itemsProperty().bind(Main.getHopital().listeFicheMedicale());
        if(EcranLogController.getPersonnelConnecte().getNom()=="admin"){            
        }else{
            vueOrdonnance.setVisible(false);
            ajoutPersonnel.setVisible(false);
            ajoutSymptome.setVisible(false);
            ajoutMedicament.setVisible(false);
            if(EcranLogController.getPersonnelConnecte().isMedecin()){
                vueOrdonnance.setVisible(true);
            }
        }
        
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
        
        /*BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/RDV.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();*/
        a.borderPaneLoad(EcranLogController.getStage(), "/ihm/RDV.fxml");
        
        
    }
    
    @FXML
    private void handleButtonLogout(ActionEvent event) throws IOException{
       a.deconnection();
    }


    @FXML
    private void handleButtonOrdonnance(ActionEvent event) throws IOException {
       
        FicheMedicale p = selectionPatient.getSelectionModel().getSelectedItem();
        OrdonnanceController.setFicheMedicale(p);
        
        if(p.getOrdonnance() != null){
            /*BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Ordonnance.fxml"));
            Scene scene = new Scene(root);
            Stage st = EcranLogController.getStage();
            st.setScene(scene);        
            st.show();*/
            a.borderPaneLoad(EcranLogController.getStage(), "/ihm/Ordonnance.fxml");
        } else{
            a.showMessage(Alert.AlertType.ERROR, null, p+" n'a pas d'ordonnance a disposition");
        }
    }

    @FXML
    private void Personnel(ActionEvent event) throws IOException {
        
        /*BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/GestionPersonnel.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();*/
        a.borderPaneLoad(EcranLogController.getStage(), "/ihm/GestionPersonnel.fxml");
    }

    @FXML
    private void AjoutSymp(ActionEvent event) throws IOException {/*
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/AjoutSymptome.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();*/
        a.borderPaneLoad(EcranLogController.getStage(), "/ihm/AjoutSymptome.fxml");
    }

    @FXML
    private void AjoutMedic(ActionEvent event) throws IOException {
        /*BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/GestionMedicaments.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();*/
        a.borderPaneLoad(EcranLogController.getStage(), "/ihm/GestionMedicaments.fxml");
    }
   

    
    
}
