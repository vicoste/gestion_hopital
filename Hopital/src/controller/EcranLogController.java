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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import launch.Main;

/**
 * FXML Controller class
 *
 * @author vicoste
 */
public class EcranLogController implements Initializable {
    
    @FXML 
    private Button boutton;
    
    @FXML
    private TextField userText;
    
    @FXML
    private PasswordField mdp;
    
    private final String idt="";
    private final String mot="";
    private static Stage stage;
    
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
    public void connexion() throws IOException, Throwable{
         if(userText.getText().equals(idt) & mdp.getText().equals(mot)){
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Accueil.fxml"));
            Scene scene = new Scene(root);
            Stage st= new Stage();
            st.initOwner(Main.getPrimaryStage());
            st.initModality(Modality.WINDOW_MODAL);
            st.setScene(scene);
            stage=st;
            st.show();
            Main.getStage().close();     
            
          }
         else{
             showMessage(Alert.AlertType.ERROR, null, "Identifiant ou mot de passe incorrect. Veuillez recommencer");
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
    
     
    
    public static Stage getStage() {
        return stage;
    }
 }
    
    
    

