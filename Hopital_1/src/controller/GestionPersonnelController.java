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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import launch.Main;
import modele.Medecin;
import modele.Personnel;

/**
 * FXML Controller class
 *
 * @author Merle Laure
 */
public class GestionPersonnelController implements Initializable {

    @FXML
    private ListView<Personnel> list;
    @FXML
    private CheckBox checkBox;
    @FXML
    private TextField nom;
    @FXML
    private TextField mdp;
    @FXML
    private TextField prenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.itemsProperty().bind(Main.getHopital().listePersonnel());
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Accueil.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();
    }

    @FXML
    private void deconnection(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/EcranLog.fxml"));
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
        Main.getStage().show();
        EcranLogController.getStage().hide();
       
    }

    @FXML
    private void suppression(ActionEvent event) {
        if(list.getSelectionModel().getSelectedItem()==null) {
            showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner un RDV. Veuillez recommencer");
        } 
        else {
            if(showMessage(Alert.AlertType.CONFIRMATION, null, "Etes vous sur de vouloir supprimer ?").get()!=ButtonType.OK)    return;
            Main.getHopital().getListePersonnel().remove(list.getSelectionModel().getSelectedItem());
        }
        
    }

    @FXML
    private void ajout(ActionEvent event) {
        Personnel p;
        if(nom.getText().equals("") || prenom.getText().equals("") || mdp.getText().equals("") ) {showMessage(Alert.AlertType.ERROR, null, "Données invalides");return;}
        
        if(checkBox.isSelected())p = new Medecin(nom.getText(), prenom.getText(), mdp.getText());
        else p = new Personnel(nom.getText(), prenom.getText(), mdp.getText());
        
        Main.getHopital().getListePersonnel().add(p);
        nom.setText("");prenom.setText("");mdp.setText("");checkBox.setSelected(false);
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
