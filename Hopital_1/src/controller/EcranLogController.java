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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import launch.Main;
import modele.FicheMedicale;
import modele.Personnel;

/**
 * FXML Controller class
 *
 * @author vicoste
 */
public class EcranLogController implements Initializable {
    
    @FXML
    private TextField numDossier; 
    
    @FXML 
    private Button boutton;
    
    @FXML
    private TextField userText;
    
    @FXML
    private PasswordField mdp;
   
    private static Stage stage;  
        public static Stage getStage() {return stage;}
        
    private static Personnel personnelConnecte;
        public static Personnel getPersonnelConnecte() {return personnelConnecte;}
     
    private final String idt="";
    private final String mot="";
    @FXML
    private Label erreurNum;
    /**
     * Initializes the controller class.
     * @throws java.io.IOException
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb){

    }  

    
    @FXML
    public void connexion() throws IOException, Throwable{
        if(userText.getText().equals(idt) & mdp.getText().equals(mot)){
                personnelConnecte = new Personnel("admin", "", "");
                BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Accueil.fxml"));
                Scene scene = new Scene(root);
                Stage st= new Stage();
                st.initOwner(Main.getPrimaryStage());
                st.initModality(Modality.WINDOW_MODAL);
                st.setScene(scene);
                stage=st;
                st.show();
                Main.getStage().close();     
                return;
        }
            
        for(Personnel p : Main.getHopital().getListePersonnel()){
             if(userText.getText().equals(p.getIdentifiant()) & mdp.getText().equals(p.getMdp())){
                personnelConnecte = p;
                BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Accueil.fxml"));
                Scene scene = new Scene(root);
                Stage st= new Stage();
                st.initOwner(Main.getPrimaryStage());
                st.initModality(Modality.WINDOW_MODAL);
                st.setScene(scene);
                stage=st;
                st.show();
                Main.getStage().close();     
                return;
            }
         
        }
            showMessage(Alert.AlertType.ERROR, null, "Identifiant ou mot de passe incorrect. Veuillez recommencer");
         
        
        
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
    
    @FXML
    public void handleButtonPatient() throws IOException{
        for(FicheMedicale f : Main.getHopital().getListeFicheMedicale()){
            if(numDossier.getText().equals(f.getNumDossier())){
                OrdonnanceController.setFicheMedicale(f);
                if(f.getOrdonnance() != null){
                BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Ordonnance.fxml"));
                Scene scene = new Scene(root);
                Stage st = EcranLogController.getStage();
                st.setScene(scene);        
                st.show();}
                else{
                    showMessage(Alert.AlertType.ERROR, null, f+" n'a pas d'ordonnance a disposition");
                }
            } else{
                erreurNum.setVisible(true);
            }
            
        }
        
    }
    
   
    
    
 }
    
    
    

