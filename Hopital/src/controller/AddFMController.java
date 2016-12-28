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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Virgile
 */
public class AddFMController implements Initializable {

    @FXML
    private GridPane gjgyjhg;
    @FXML
    private ComboBox<?> cbPatient;
    @FXML
    private ChoiceBox<?> selecSymp;
    @FXML
    private TextArea taMotif;
    @FXML
    private ListView<?> listSymp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAddPatient(ActionEvent event) {
    }

    @FXML
    private void handleButtonAddSymp(ActionEvent event) {
    }
    
}
