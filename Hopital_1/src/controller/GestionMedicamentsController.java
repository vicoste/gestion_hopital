/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Merle Laure
 */
public class GestionMedicamentsController implements Initializable {

    @FXML
    private ListView<?> list;
    @FXML
    private CheckBox checkBox;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private ListView<?> listeSymptomes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
