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
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import launch.Main;
import modele.Medicament;
import modele.Symptome;

/**
 * FXML Controller class
 *
 * @author Merle Laure
 */
public class GestionMedicamentsController implements Initializable {

    @FXML
    private ListView<Medicament> list;
    @FXML
    private TextField nom;
    @FXML
    private TextArea description;
    @FXML
    private ListView<Symptome> symptomeSoigne;
    @FXML
    private ListView<Symptome> listSymptome;

    private ObservableList<Symptome> listeSymp=FXCollections.observableArrayList();
    private ListProperty<Symptome> listeSymptome = new SimpleListProperty<>(listeSymp);
        private ObservableList<Symptome> getListeSymptome(){return listeSymptome.get();}
        private void setListeSymptome(ObservableList<Symptome> s){listeSymptome.set(s);}
        private ListProperty<Symptome> listeSymptome(){return listeSymptome;}
        
    private ObservableList<Symptome> listeSympSoin=FXCollections.observableArrayList();
    private ListProperty<Symptome> listeSymptomeSoin = new SimpleListProperty<>(listeSympSoin);
        private ObservableList<Symptome> getListeSymptomeSoin(){return listeSymptomeSoin.get();}
        private void setListeSymptomeSoin(ObservableList<Symptome> s){listeSymptomeSoin.set(s);}
        private ListProperty<Symptome> listeSymptomeSoin(){return listeSymptomeSoin;}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        list.itemsProperty().bind(Main.getHopital().listeMedicament());
        
        listeSymp.addAll(Main.getHopital().getListeSymptome());
        listSymptome.itemsProperty().bind(listeSymptome);
        symptomeSoigne.itemsProperty().bind(listeSymptomeSoin);
        listSymptome.setOnMouseClicked(new EventHandler<MouseEvent>(){              
                
            @Override
            public void handle(MouseEvent event) {
             if (event.getClickCount() == 2) {
                listeSympSoin.add(listSymptome.getSelectionModel().getSelectedItem());
                listeSymp.remove(listSymptome.getSelectionModel().getSelectedItem());
                }
            }            
        });
        symptomeSoigne.setOnMouseClicked(new EventHandler<MouseEvent>(){              
                
            @Override
            public void handle(MouseEvent event) {
             if (event.getClickCount() == 2) {
                
                listeSymp.add(symptomeSoigne.getSelectionModel().getSelectedItem());
                listeSympSoin.remove(symptomeSoigne.getSelectionModel().getSelectedItem());
                }
            }            
        });

        
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/Accueil.fxml"));
        Scene scene = new Scene(root);
        Stage st = EcranLogController.getStage();
        st.setScene(scene);        
        st.show();
    }

    @FXML
    private void deconnection(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/ihm/EcranLog.fxml"));
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
        Main.getStage().show();
        EcranLogController.getStage().hide();
       
    }

    @FXML
    private void suppression(ActionEvent event) {
        if(list.getSelectionModel().getSelectedItem()==null) {
            showMessage(Alert.AlertType.ERROR, null, "Veuillez selectionner une Medicament. Veuillez recommencer");
        } 
        else {
            if(showMessage(Alert.AlertType.CONFIRMATION, null, "Etes vous sur de vouloir supprimer ?").get()!=ButtonType.OK)    return;
            Main.getHopital().getListeMedicament().remove(list.getSelectionModel().getSelectedItem());
        }
        
    }

    @FXML
    private void ajout(ActionEvent event) {
        if(nom.getText().equals("")|| description.getText().equals("")|| symptomeSoigne.getSelectionModel().getSelectedItems().equals(null)){showMessage(Alert.AlertType.ERROR, null, "Données invalides");return;}
        
        Medicament m =new Medicament(nom.getText(), description.getText(), symptomeSoigne.getItems());
        Main.getHopital().getListeMedicament().add(m);
        nom.setText(""); description.setText("");listeSymp.addAll(listeSympSoin);listeSympSoin.clear();
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
    
}
