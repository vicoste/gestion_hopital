/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import launch.Main;
import modele.Medicament;
import modele.FicheMedicale;
import modele.Symptome;

/**
 * FXML Controller class
 *
 * @author Merle Laure
 */
public class OrdonnanceController implements Initializable {

    @FXML
    private ListView<Symptome> listSymptome; // symptome inscrit sur la fiche medicale
    @FXML
    private ListView<Medicament> listMedic; // medicament qui traite ce symptome
    @FXML
    private ListView<String> listInstructions;//

    private ObservableList<Symptome> listeSymp=FXCollections.observableArrayList();
    private ListProperty<Symptome> listeSymptome = new SimpleListProperty<>(listeSymp);
        public ObservableList<Symptome> getListeSymptome(){return listeSymptome.get();}
        public void setListeSymptome(ObservableList<Symptome> s){listeSymptome.set(s);}
        public ListProperty<Symptome> listeSymptome(){return listeSymptome;}
        
    private ObservableList<Medicament> listeMedic=FXCollections.observableArrayList();
    private ListProperty<Medicament> listeMedicament = new SimpleListProperty<>(listeMedic);
        public ObservableList<Medicament> getListeMedicament(){return listeMedicament.get();}
        public void setListeMedicament(ObservableList<Medicament> med){listeMedicament.set(med);}
        public ListProperty<Medicament> listeMedicament(){return listeMedicament;}
        
    private static FicheMedicale f;
        public static FicheMedicale getFicheMedicale() {return f;}
        public static void setFicheMedicale(FicheMedicale f) {OrdonnanceController.f = f;}
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        int i =0;
        ArrayList<Symptome> aux =new ArrayList<>();
        
        for(Symptome s: f.getListSymp()){
             listeSymp.add(s);
         }
         for(Medicament m : Main.getHopital().getListeMedicament()){
             System.out.println(m.getListeSymptome());
           for(Symptome s : listeSymp){
                if(m.soigne(s)) 
                    if(!listeMedic.contains(m))listeMedic.add(m);
            }
         
        
        listSymptome.itemsProperty().bind(listeSymptome); //smptome sur l'odonnance
        listMedic.itemsProperty().bind(listeMedicament);
        
      // Main.getHopital().getListeMedicament().
               
        //    }
            
         }
    }
        
        

    @FXML
    private void handleButtonLogout(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
    }

    @FXML
    private void suppressionMedic(ActionEvent event) {
    }

    @FXML
    private void ajoutMedic(ActionEvent event) {
    }
    
}