/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXConsole;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import launch.ControllerUtils;
import launch.Main;
import modele.Medecin;
import modele.Personnel;
import modele.RendezVous;
import modele.Symptome;

/**
 * FXML Controller class
 *
 * @author vicoste
 */
public class RDVController implements Initializable {

    @FXML
    private ListView<RendezVous> list;
        
    private static Stage stage;
        public static Stage getStage() {return stage;}
        
    private static RendezVous rv;
        public static RendezVous getRDV() {return  rv ;}
        
    ControllerUtils a = new ControllerUtils();
    
    private static ObservableList<RendezVous> listeRDV = FXCollections.observableArrayList();
    private static ListProperty<RendezVous> listeRdv= new SimpleListProperty<>(listeRDV);
        public static ObservableList<RendezVous> getListeRdv(){return listeRdv.get();}
        public static void setListeRdv(ObservableList<RendezVous> s){listeRdv.set(s);}
        public static ListProperty<RendezVous> listeRdv(){return listeRdv;}
        
        
        
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chargerRDV();
        list.itemsProperty().bind(listeRdv);
    }    
    
    @FXML
    private void handleButtonAjouter(ActionEvent event) throws IOException{

        stage = a.gridPaneLoad(EcranLogController.getStage(), new Stage(), "/ihm/CreerRDV.fxml", false);
    }
    
    @FXML
    private void handleButtonSupprimer(ActionEvent event) throws IOException{
        if(list.getSelectionModel().getSelectedItem()==null) {
            a.showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner un RDV. Veuillez recommencer");
        } 
        else {
            if(a.showMessage(Alert.AlertType.CONFIRMATION, null, "Etes vous sur de vouloir supprimer ?").get()!=ButtonType.OK)    return;
            if(!list.getSelectionModel().getSelectedItem().supprimer())
                a.showMessage(Alert.AlertType.ERROR, null, "erreur de suppression");
            chargerRDV();
        }
            
            
             
    }
    
    @FXML
    private void handleButtonModifier(ActionEvent event) throws IOException{
        if(list.getSelectionModel().getSelectedItem()==null) {
            a.showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner une RDV. Veuillez recommencer");
        } 
        else {
          
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("/ihm/SelectFM.fxml"));
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.initOwner(EcranLogController.getStage());
            st.initModality(Modality.WINDOW_MODAL);
            st.setScene(scene);
            st.setResizable(false);
            stage=st;
            
            rv = list.getSelectionModel().getSelectedItem();
            
            st.show();
             
        }
    }
    @FXML
    private void handleButtonLogout(ActionEvent event) throws IOException{
        a.deconnection();
       
    }


    @FXML
    private void handleButtonRetour(ActionEvent event)throws IOException{
        
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Accueil.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();
       
        
    }
    
    private void chargerRDV(){
        listeRDV.clear();
        for(Personnel p : Main.getHopital().getListePersonnel()){
            if(!p.isMedecin())continue;
            Medecin m = (Medecin) p;
            for(RendezVous r : m.getListeRdv()){
                if(!listeRDV.contains(r)) listeRDV.add(r);
            }
        }
    }
}
        