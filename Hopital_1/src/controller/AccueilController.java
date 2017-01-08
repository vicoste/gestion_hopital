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
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import launch.Main;
import modele.Medecin;

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

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    private void handleButtonOrdonnance(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Ordonnance.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();
    }

    @FXML
    private void Personnel(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/GestionPersonnel.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();
    }

    @FXML
    private void AjoutSymp(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/AjoutSymptome.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();
    }

    @FXML
    private void AjoutMedic(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/GestionMedicaments.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();
    }
   
    
}
