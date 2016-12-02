/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author vicoste
 */
public class ControleurConnexion {
    private GestionHopital gestion;
    
    @FXML
    private TextField login;
    @FXML
    private PasswordField mdp;


    public ControleurConnexion(GestionHopital gestion) {
        this.gestion = gestion;
    }
    
    
    public void clicLogin(){
        
        
    }
    
}
