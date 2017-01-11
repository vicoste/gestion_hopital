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
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import launch.Main;
import modele.FicheMedicale;

/**
 * FXML Controller class
 *
 * @author Virgile
 */
public class FMController implements Initializable {

    @FXML
    private ListView<FicheMedicale> list;
    
    private static Stage stage;
    private static ObservableValue<FicheMedicale> listFM;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        list.itemsProperty().bind(Main.getHopital().listeFicheMedicale());
    }    

    

    @FXML
    private void handleButtonRetour(ActionEvent event) throws IOException{
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Accueil.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();
    }
    
     @FXML
    private void handleButtonAjouter(ActionEvent event) throws IOException{
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/AddFM.fxml"));
        Scene scene = new Scene(root, 400, 400);
        Stage st = new Stage();
        st.initOwner(EcranLogController.getStage());
        st.initModality(Modality.WINDOW_MODAL);
        st.setScene(scene);
        st.setResizable(false);
        stage = st;
        st.show();
    }
    @FXML
    private void handleButtonSupprimer(ActionEvent event) throws IOException{
        if(list.getSelectionModel().getSelectedItem()==null) {
            showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner une fiche médicale. Veuillez recommencer");
        } 
        else {
            if (showMessage(Alert.AlertType.CONFIRMATION, null, "Etes vous sur de vouloir supprimer ?").get()!=ButtonType.OK)    return;
            Main.getHopital().getListeFicheMedicale().remove(list.getSelectionModel().getSelectedItem());
            
                
                
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
       
    }
    


    public static Stage getStage() {
        return stage;
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
