/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

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
    private Slider sexe;
    @FXML
    private TextField numSecu;
    @FXML
    private Label valeurSexe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonRetour(ActionEvent event) {
    }

    @FXML
    private void handleButtonValid(ActionEvent event) {
    }
    
}
