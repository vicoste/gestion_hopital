/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vicoste
 */
public class EcranLogController implements Initializable {
    
    @FXML
    private Stage primaryStage;
    
    @FXML 
    private Button boutton;
    
    @FXML
    private TextField login;
    
    @FXML
    private PasswordField mdp;
    
    /**
     * Initializes the controller class.
     * @throws java.io.IOException
     */
    
    public EcranLogController(){

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){

    }  
    
    @FXML
    public void connexion() throws IOException{
        Stage sta = new Stage(); 
        
        
       
        
         
        
        FXMLLoader root = new FXMLLoader(getClass().getResource("ihm/Accueil.fxml"));
        root.setController(new AccueilController());
        sta.setScene(new Scene(root.load()));
        sta.resizableProperty().set(false);
        sta.show();
        primaryStage.hide();
    }
    
}
