/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.sun.javafx.image.impl.ByteArgb.accessor;
import com.sun.javafx.scene.control.FormatterAccessor;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;
import launch.Main;
import modele.Patient;
import modele.RendezVous;

/**
 * FXML Controller class
 *
 * @author Virgile
 */
public class CreerPatientController implements Initializable {

    @FXML
    private RadioButton homme;
    @FXML
    private RadioButton femme;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private Slider age;
    @FXML
    private TextField numSecu;
    @FXML
    private TextField valeurAge;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            
        
        femme.setSelected(true); 
        
        age.setMin(0); age.setMax(120); age.setSnapToTicks(true); age.setMinorTickCount(1);
        age.setValue(40);
        valeurAge.setText("40");
        
        valeurAge.textProperty().bindBidirectional(age.valueProperty(), new NumberStringConverter());
        valeurAge.setTextFormatter(new TextFormatter<>(t ->{
        
                if (t.isReplaced()) 
                    if(t.getText().matches("[^0-9]"))
                        t.setText(t.getControlText().substring(t.getRangeStart(), t.getRangeEnd()));
                

                if (t.isAdded()) {
                    if (t.getControlText().contains(",")) {
                        if (t.getText().matches("[^0-9]")) {
                            t.setText("");
                        }
                    } else if (t.getText().matches("[^0-9,]")) {
                        t.setText("");
                    }
                }

                return t;}));
        
        
        
        
        numSecu.setTextFormatter(new TextFormatter<>(t ->{
            
            if (t.isReplaced()) 
                if(t.getText().matches("[^0-9]"))
                        t.setText(t.getControlText().substring(t.getRangeStart(), t.getRangeEnd()));
            
            
            if (t.isAdded()) {
                        if (t.getControlText().contains(",")) {
                            if (t.getText().matches("[^0-9]")) {
                                t.setText("");
                            }
                        } else if (t.getText().matches("[^0-9,]")) {
                            t.setText("");
                        }
                    
                }

                return t;}));
        
        
        
    }
           
        
            
        
        
        

    @FXML
    private void actionFemme() {
        homme.setSelected(false);
    }
    
    @FXML
    private void actionHomme() {
        femme.setSelected(false);
    }
    
    @FXML
    private void handleButtonRetour(ActionEvent event) {        
        FMController.getStage().close();
    }

    @FXML
    private void handleButtonValid(ActionEvent event) {
         
        boolean sexe = false;
        if(femme.equals(true)) sexe = true;
            
        if(nom.getText().equals("")) {
            showMessage(Alert.AlertType.ERROR, null, "Veuillez entrer un nom.");
        } else{    
            if(prenom.getText().equals("")) { 
                showMessage(Alert.AlertType.ERROR, null, "Veuillez entrer un prenom.");
            } else{
                if(numSecu.getLength()!=15){
                    showMessage(Alert.AlertType.ERROR, null, "n° secu invalide.");
                } else{
                    if(numSecu.getText().substring(0, 1).matches("[^0-1]")){
                        showMessage(Alert.AlertType.ERROR, null, "n° secu invalide.");
                    }else{
                        
                        Patient p = new Patient(numSecu.getText(), nom.getText(), prenom.getText(), (int) age.getValue(), sexe);                     
                                              
                        if(showMessage(Alert.AlertType.CONFIRMATION, null, "C'est données sont-elles exactes ?\n"
                        + "Nom : "+p.getNom()+" \n"
                        + "prenom : "+p.getPrenom()+"\n"
                        + "age : "+p.getAge()+"\n"
                        + "sexe : "+p.getSexe()+"\n"
                        + "numéro sécu : "+p.getNumSecu()).get()==ButtonType.OK){
                            Main.setListPat(p);
                            FMController.getStage().close();
                        }                            
                    }                                 
                } 
            }
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
    
}
