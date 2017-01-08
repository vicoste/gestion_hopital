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
import javafx.scene.control.ListView;
import modele.Medicament;
import modele.Symptome;

/**
 * FXML Controller class
 *
 * @author Merle Laure
 */
public class Ordonnance implements Initializable {

    @FXML
    private ListView<Symptome> listSymptome;
    @FXML
    private ListView<Medicament> listMedic;
    @FXML
    private ListView<String> listInstructions;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonLogout(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
    }

    @FXML
    private void suppressionMedic(ActionEvent event) {
    }

    @FXML
    private void ajoutMedic(ActionEvent event) {
    }
    
}
