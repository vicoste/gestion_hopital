/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import launch.Main;
import modele.Patient;
import modele.RendezVous;

/**
 * FXML Controller class
 *
 * @author Virgile
 */
public class CreerPatientController implements Initializable {

    @FXML
    private RadioButton homme;
    @FXML
    private RadioButton femme;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private Slider age;
    @FXML
    private TextField numSecu;
    @FXML
    private TextField valeurAge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        femme.setSelected(true); 
        
        age.setMin(0); age.setMax(120);
        age.setValue(40);
        valeurAge.setText("40");
        age.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                valeurAge.textProperty().setValue(String.valueOf((int) age.getValue()));
            }
        });
    }    

    @FXML
    private void actionFemme() {
        homme.setSelected(false);
    }
    
    @FXML
    private void actionHomme() {
        femme.setSelected(false);
    }
    @FXML
    private void actionAge(){
        //DEMANDER AU PROF COMMENT AJUSTER LA VALEUR DU SLIDER A CELLE DU TEXTFIELD
    }
    @FXML
    private void handleButtonRetour(ActionEvent event) {
    }

    @FXML
    private void handleButtonValid(ActionEvent event) {
        if(nom.getText().equals("")) {
            showMessage(Alert.AlertType.ERROR, null, "Veuillez entrer un nom.");
        } else{    
            if(prenom.getText().equals("")) { 
                showMessage(Alert.AlertType.ERROR, null, "Veuillez entrer un prenom.");
            } else{
                if(numSecu.getLength()!=15){
                    showMessage(Alert.AlertType.ERROR, null, "n° secu invalide.");
                } else{
                    if(numSecu.getText(0, 1).equals("1") || numSecu.getText(0, 1).equals("0")){
                        showMessage(Alert.AlertType.ERROR, null, "n° secu invalide.");
                    }else{
                        Patient p = new Patient(numSecu.getText(), nom.getText(), prenom.getText(), (int) age.getValue(), Boolean.TRUE);
                        if(showMessage(Alert.AlertType.CONFIRMATION, null, "C'est données sont-elles exactes ?\n"
                        + "Nom : "+p.getNom()+" \n"
                        + "prenom : "+p.getPrenom()+"\n"
                        + "age : "+p.getAge()+"\n"
                        + "sexe : "+p.getSexe()+"\n"
                        + "numéro sécu : "+p.getNumSecu()).get()==ButtonType.OK){
                            Main.setListPat(p);
                            FMController.getStage().close();
                        }
                            
                    }                                 
                } 
            }
        }
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
