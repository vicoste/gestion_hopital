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
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import launch.ControllerUtils;
import launch.Main;
import modele.FicheMedicale;
import modele.Heure;
import modele.Medecin;
import modele.Personnel;

/**
 * FXML Controller class
 *
 * @author Virgile
 */
public class SelectFMController implements Initializable {
    
    @FXML
    private ListView<FicheMedicale> list;
    
    @FXML
    private Label ficheMedicModif;
    
    @FXML
    private ComboBox<Medecin> cb;
    
    @FXML
    private ComboBox<Heure> cbheure;
    
    @FXML
    private DatePicker datePicker;
    
    private static final ObservableList<Medecin> listeMed=FXCollections.observableArrayList();
    private static ListProperty<Medecin> listeMedecin = new SimpleListProperty<>(listeMed);
        public static ObservableList<Medecin> getListeMedecin(){return listeMedecin.get();}
        public static void setListeMedecin(ObservableList<Medecin> m){listeMedecin.set(m);}
        public static ListProperty<Medecin> listeMedecin(){return listeMedecin;}
        
    ControllerUtils a = new ControllerUtils();
    
        
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ficheMedicModif.setVisible(false);
        
   
        
        list.itemsProperty().bind(Main.getHopital().listeFicheMedicale());
        
        for(Personnel e : Main.getHopital().listePersonnel())if(e.isMedecin()) listeMed.add((Medecin)e);
        
        cb.itemsProperty().bind(listeMedecin());
        
        //cbheure.setSelectionModel();
       
        
        
    } 
    

    @FXML
    private void handleButtonConfirmer(ActionEvent event) {

        if(list.getSelectionModel().getSelectedItem()==null) {
            a.showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner une Fiche Medicale.");
        } else{    
            if(datePicker.getValue()==null) { 
                a.showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner une Date.");
            } else{
                if(datePicker.getValue().compareTo(LocalDate.now())<0){
                    a.showMessage(Alert.AlertType.ERROR, null, "Date invalide.");
                } else{
                    if(cbheure.getValue()==null) {
                        a.showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner une Heure.");
                    } else{
                        if(cb.getValue()==null) {
                            a.showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner un Medecin.");
                        } 
                        else{
                          //  Main.setListRDV(new RendezVous(list.getSelectionModel().getSelectedItem(),cb.getValue(),datePicker.getValue()));
                            RDVController.getStage().close();
                        }
                    }
                }
            }
        }    
    }

    @FXML
    private void handleButtonAnnuler(ActionEvent event) {
        RDVController.getStage().close();
    }
}
