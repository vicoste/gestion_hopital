/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import launch.ControllerUtils;
import launch.Main;
import modele.Medicament;
import modele.FicheMedicale;
import modele.Heure;
import modele.Medecin;
import modele.Ordonnance;
import modele.RendezVous;
import modele.Symptome;

/**
 * FXML Controller class
 *
 * @author Virgile
 */
public class OrdonnanceController implements Initializable {

    @FXML
    private ListView<Symptome> listSymptome; // symptome inscrit sur la fiche medicale
    @FXML
    private ListView<Medicament> listMedic; // medicament qui traite ce symptome
    @FXML
    private ListView<String> listInstructions;//
    @FXML
    private Button button;

    private ObservableList<Symptome> listeSymp=FXCollections.observableArrayList();
    private ListProperty<Symptome> listeSymptome = new SimpleListProperty<>(listeSymp);
        public ObservableList<Symptome> getListeSymptome(){return listeSymptome.get();}
        public void setListeSymptome(ObservableList<Symptome> s){listeSymptome.set(s);}
        public ListProperty<Symptome> listeSymptome(){return listeSymptome;}
        
    private static ObservableList<Medicament> listeMedic=FXCollections.observableArrayList();
    private static ListProperty<Medicament> listeMedicament = new SimpleListProperty<>(listeMedic);
        public static ObservableList<Medicament> getListeMedicament(){return listeMedicament.get();}
        public static void setListeMedicament(ObservableList<Medicament> med){listeMedicament.set(med);}
        public static ListProperty<Medicament> listeMedicament(){return listeMedicament;}
        
    private static FicheMedicale f;
        public static FicheMedicale getFicheMedicale() {return f;}
        public static void setFicheMedicale(FicheMedicale f) {OrdonnanceController.f = f;}
        
    ControllerUtils a = new ControllerUtils();

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
         
         }
        listSymptome.itemsProperty().bind(listeSymptome); //symptome sur l'odonnance
        listMedic.itemsProperty().bind(listeMedicament);
        
        listInstructions.setCellFactory((param) -> {
            ListCell<String> cell =new ListCell<String>(){
                @Override
                public void startEdit() {
                    listInstructions.setOnMouseClicked((event) -> {
                        if(event.getClickCount()==2){
                            setGraphic(new TextField());
                            super.startEdit();
                        }
                    });
                }
            };
            return cell; //To change body of generated lambdas, choose Tools | Templates.
        });

             
 
    }  
        

    @FXML
    private void handleButtonLogout(ActionEvent event)throws IOException{
        a.deconnection();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException{
        a.borderPaneLoad(EcranLogController.getStage(), "/ihm/Accueil.fxml");
    }

    @FXML
    private void suppressionMedic(ActionEvent event) {
        listeMedic.remove(listMedic.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void ajoutMedic(ActionEvent event)throws IOException{
       
        a.borderPaneLoad(EcranLogController.getStage(),new Stage(), "/ihm/AjoutMedicOrdonnance.fxml",false); 
    }

    @FXML
    private void editer(ActionEvent event) {

    }

    @FXML
    private void validerOrdonnance(ActionEvent event) throws IOException{
        if(a.showMessage(Alert.AlertType.CONFIRMATION,null, "Une fois valider l'ordonnance ne sera plus modifiable.\n Continuer ?").get()==ButtonType.OK){
            int i=1;
            String instruc;
            Dictionary<Medicament,String> m = new Hashtable<>();
            RendezVous rv=null;
            
            for(Medicament medoc : listeMedic){
                try{instruc = listInstructions.getItems().get(i);}
                catch(IndexOutOfBoundsException e){instruc ="";}
                m.put(medoc, instruc);
                
                i++;
            }
            f.setOrdonnance(new Ordonnance(m));
            f.setEtat(Boolean.TRUE);
            Medecin medecin = (Medecin) AccueilController.getPersonnel();
            for(RendezVous rdv : medecin.getListeRdv()){
                if(rdv.getFiche().equals(f)) {rv=rdv;break;}
            }
            
            medecin.getListeRdv().remove(rv);
            a.borderPaneLoad(EcranLogController.getStage(), "/ihm/Accueil.fxml");
        }
    }
   
    
    
    
}
