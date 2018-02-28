/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Reclamation;
import SERVICE.ReclamationService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLUpdateDeleteReclamationController implements Initializable {

    private static int id;
    

    @FXML
    private JFXTextField description;
    @FXML
    private JFXComboBox<String> lieu_decouverte;
    ObservableList<String> typeoption5
            = FXCollections.observableArrayList("Esprit Ghazela", "Esprit Charguia");
    @FXML
    private JFXDatePicker date_decouverte;
    @FXML
    private JFXComboBox<String> typeobj_perdu;
    ObservableList<String> typeoption
            = FXCollections.observableArrayList("Calculatrice", "Chargeur", "Clés", "Clé USB", "CIN", "Monnaie", "Passeport", "PC", "Portefeuille", "Porte-documents", "Télephone", "Feuilles","Autre");
    @FXML
    private Button Update;
    @FXML
    private JFXTextField autretypeobj_perdu;
    @FXML
    private JFXComboBox<String> localisation;
    ObservableList<String> typeoption4
            = FXCollections.observableArrayList("Buvette", "Bloc A", "Bloc B", "Bloc C", "Bloc D", "Bloc E", "Bloc H", "Autre");

    @FXML
    private JFXComboBox<String> type;
    ObservableList<String> typeoption1
            = FXCollections.observableArrayList("Reclamation Objet perdu", "Reclamation Objet trouvé");
    
@FXML
    private JFXTextField autrelocalisation;
    @FXML
    private JFXComboBox<String> etage;
    ObservableList<String> typeoption3
            = FXCollections.observableArrayList("Rez-de-chaussée", "1er étage", "2éme étage", "3éme étage", "4éme étage");
    @FXML
    private JFXTextField matricule;
    @FXML
    private JFXTextField salle;
    
    @FXML
    private Label autreLocalisationLabel;
    @FXML
    private Label salleLabel;
    @FXML
    private Label matriculeLabel;
@FXML
    private JFXTextField actionStatus;
    ReclamationService rs = new ReclamationService(); 
    List<Reclamation> reclamations = rs.getAll();
    @FXML
    private Label typeLabel;
    @FXML
    private Label typeobj_perduLabel;
    @FXML
    private Label lieu_decouverteLabel;
    @FXML
    private Label localisationLabel;
    @FXML
    private Label etageLabel;
    @FXML
    private Label date_decouverteLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label photoLabel;
    @FXML
    private JFXRadioButton recobj;
    @FXML
    private ToggleGroup recc;
    @FXML
    private JFXRadioButton recmalst;
    @FXML
    private Label photo2Label;
    @FXML
    private Button photo2;
    @FXML
    private JFXTextField actionStatus2;
    @FXML
    private Button On_btn_annuler;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button photo;
    @FXML
    private Label autretypeobj_perduLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             type.setVisible(false);
        typeLabel.setVisible(false);
        typeobj_perdu.setVisible(false);
        typeobj_perduLabel.setVisible(false);
        lieu_decouverte.setVisible(false);
        lieu_decouverteLabel.setVisible(false);
        localisation.setVisible(false);
        localisationLabel.setVisible(false);
        etage.setVisible(false);
        etageLabel.setVisible(false);
        date_decouverte.setVisible(false);
        date_decouverteLabel.setVisible(false);
        description.setVisible(false);
        descriptionLabel.setVisible(false);
        photo.setVisible(false);
        photoLabel.setVisible(false);
        photo2.setVisible(false);
        photo2Label.setVisible(false);
        matricule.setVisible(false);
        matriculeLabel.setVisible(false);
        autretypeobj_perdu.setVisible(false);
        autretypeobj_perduLabel.setVisible(false);
        autrelocalisation.setVisible(false);
        autreLocalisationLabel.setVisible(false);
        salleLabel.setVisible(false);
        salle.setVisible(false);
        //mail.setVisible(false);

        recc.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                System.out.println("u");
                if (recobj.isSelected()) {
                    type.setVisible(true);
                    typeLabel.setVisible(true);
                    typeobj_perdu.setVisible(true);
                    typeobj_perduLabel.setVisible(true);
                    lieu_decouverte.setVisible(true);
                    lieu_decouverteLabel.setVisible(true);
                    localisation.setVisible(true);
                    localisationLabel.setVisible(true);
                    date_decouverte.setVisible(false);
                    date_decouverteLabel.setVisible(false);
                    etage.setVisible(true);
                    etageLabel.setVisible(true);
                    description.setVisible(true);
                    descriptionLabel.setVisible(true);
                    photo.setVisible(true);
                    photoLabel.setVisible(true);
                    date_decouverte.setVisible(true);
                    date_decouverteLabel.setVisible(true);
                    matricule.setVisible(false);
                    matriculeLabel.setVisible(false);
                    photo2.setVisible(false);
                    photo2Label.setVisible(false);
                    actionStatus2.setVisible(false);
                    actionStatus.setVisible(true);
                    // mail.setVisible(false);

                }
                if (recmalst.isSelected()) {
                    type.setVisible(false);
                    typeLabel.setVisible(false);
                    typeobj_perdu.setVisible(false);
                    typeobj_perduLabel.setVisible(false);
                    lieu_decouverte.setVisible(false);
                    lieu_decouverteLabel.setVisible(false);
                    localisation.setVisible(false);
                    localisationLabel.setVisible(false);
                    etage.setVisible(false);
                    etageLabel.setVisible(false);
                    date_decouverte.setVisible(false);
                    date_decouverteLabel.setVisible(false);
                    description.setVisible(false);
                    descriptionLabel.setVisible(false);
                    photo.setVisible(false);
                    photoLabel.setVisible(false);
                    matricule.setVisible(true);
                    matriculeLabel.setVisible(true);
                    actionStatus2.setVisible(true);
                    photo2.setVisible(true);
                    photo2Label.setVisible(true);
                    autretypeobj_perdu.setVisible(false);
                    autretypeobj_perduLabel.setVisible(false);
                    autrelocalisation.setVisible(false);
                    autreLocalisationLabel.setVisible(false);
                    salleLabel.setVisible(false);
                    salle.setVisible(false);
                    actionStatus.setVisible(false);
                    //mail.setVisible(true);
                }
            }
        });
        typeobj_perdu.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (typeobj_perdu.getValue().equals("Autre")) {
                autretypeobj_perdu.setVisible(true);
                autretypeobj_perduLabel.setVisible(true);
            } else {
                autretypeobj_perdu.setVisible(false);
                autretypeobj_perduLabel.setVisible(false);
            }
        });

        localisation.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (localisation.getValue().equals("Autre")) {
                autrelocalisation.setVisible(true);
                autreLocalisationLabel.setVisible(true);
            } else {
                autrelocalisation.setVisible(false);
                autreLocalisationLabel.setVisible(false);
            }
        }); 
        
         localisation.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (localisation.getValue().equals("Bloc A")) {
                salle.setVisible(true);
                salleLabel.setVisible(true);
            } else if (localisation.getValue().equals("Bloc B")) {
                salle.setVisible(true);
                salleLabel.setVisible(true);
            } else if (localisation.getValue().equals("Bloc C")) {
                salle.setVisible(true);
                salleLabel.setVisible(true);
            } else if (localisation.getValue().equals("Bloc D")) {
                salle.setVisible(true);
                salleLabel.setVisible(true);
            } else if (localisation.getValue().equals("Bloc E")) {
                salle.setVisible(true);
                salleLabel.setVisible(true);
            } else if (localisation.getValue().equals("Bloc H")) {
                salle.setVisible(true);
                salleLabel.setVisible(true);
            } else {
                salle.setVisible(false);
                salleLabel.setVisible(false);
            }
        });
        actionStatus.setVisible(false);
        actionStatus2.setVisible(false);
        matricule.setVisible(false);
        matriculeLabel.setVisible(false);
        
        
        
         Reclamation rec1 =new ReclamationService().findId(id);
                lieu_decouverte.setItems(typeoption5);
                typeobj_perdu.setItems(typeoption);
                type.setItems(typeoption1);
                etage.setItems(typeoption3);
                localisation.setItems(typeoption4);

        
        ////////
               String idd = String.valueOf(rec1.getId());
               date_decouverte.setPromptText("");
                if (rec1.getType().equals("Reclamation Objet perdu")) {
                recc.selectToggle(recobj);
                date_decouverte.setPromptText(rec1.getDate_decouverte().toString());
                date_decouverte.setValue(rec1.getDate_decouverte().toLocalDate());
                lieu_decouverte.setValue(rec1.getLieu_decouverte());
                typeobj_perdu.setPromptText(rec1.getTypeobj_perdu());
                typeobj_perdu.setValue(rec1.getTypeobj_perdu());
                type.setPromptText(rec1.getType());
                type.setValue(rec1.getType());
                autretypeobj_perdu.setText(rec1.getAutretypeobj_perdu());
                localisation.setPromptText(rec1.getLocalisation());
                localisation.setValue(rec1.getLocalisation());
                autrelocalisation.setText(rec1.getAutrelocalisation());
                etage.setPromptText(rec1.getEtage());
                etage.setValue(rec1.getEtage());
                description.setText(rec1.getDescription());
                salle.setText(rec1.getSalle());
                actionStatus.setText(rec1.getPhoto());  
                 }else if(rec1.getType().equals("Reclamation Objet trouvé")){
                 recc.selectToggle(recobj);
                date_decouverte.setPromptText(rec1.getDate_decouverte().toString());
                date_decouverte.setValue(rec1.getDate_decouverte().toLocalDate());
                lieu_decouverte.setValue(rec1.getLieu_decouverte());
                typeobj_perdu.setPromptText(rec1.getTypeobj_perdu());
                typeobj_perdu.setValue(rec1.getTypeobj_perdu());
                type.setPromptText(rec1.getType());
                type.setValue(rec1.getType());
                autretypeobj_perdu.setText(rec1.getAutretypeobj_perdu());
                localisation.setPromptText(rec1.getLocalisation());
                localisation.setValue(rec1.getLocalisation());
                autrelocalisation.setText(rec1.getAutrelocalisation());
                etage.setPromptText(rec1.getEtage());
                etage.setValue(rec1.getEtage());
                description.setText(rec1.getDescription());
                salle.setText(rec1.getSalle());
                actionStatus.setText(rec1.getPhoto());  
                 } 
                 else{
                 recc.selectToggle(recmalst);
                  matricule.setText(rec1.getMatricule());
                  /////
                  actionStatus2.setText(rec1.getPhoto2());
                 
                  }
                //////////
                
               /*
                String idd = String.valueOf(rec1.getId());
                //  id.setText(idd);
                description.setText(rec1.getDescription());
                date_decouverte.setPromptText(rec1.getDate_decouverte().toString());
                date_decouverte.setValue(rec1.getDate_decouverte().toLocalDate());
                lieu_decouverte.setValue(rec1.getLieu_decouverte());
                typeobj_perdu.setPromptText(rec1.getTypeobj_perdu());
                typeobj_perdu.setValue(rec1.getTypeobj_perdu());
                type.setPromptText(rec1.getType());
                type.setValue(rec1.getType());
                autretypeobj_perdu.setText(rec1.getAutretypeobj_perdu());
                localisation.setPromptText(rec1.getLocalisation());
                localisation.setValue(rec1.getLocalisation());
                autrelocalisation.setText(rec1.getAutrelocalisation());
                etage.setPromptText(rec1.getEtage());
                etage.setValue(rec1.getEtage());
                matricule.setText(rec1.getMatricule());
                salle.setText(rec1.getSalle());
                actionStatus.setText(rec1.getPhoto());  
                actionStatus2.setText(rec1.getPhoto2()); 
                
                if (rec1.getType().equals("Reclamation Objet perdu")) {
                recc.selectToggle(recobj);
                 } else if (rec1.getType().equals("Reclamation Objet trouvé")) {
                 recc.selectToggle(recmalst);
                  }*/
    }  
    
     public void redirect(String id) {
        System.out.println("Interface Affiche Mod/supp ");
        System.out.println(id);
        this.id = Integer.parseInt(id);
        System.out.println(id);
    }

    

    @FXML
    private void On_btn_Update(ActionEvent event) {
        if (recobj.isSelected()){
          
           
           String typeRec;
        if (type.getValue() != null) {
             typeRec = type.getValue();
        }else{typeRec = null;}
        
        
        String typeobj_perduRec;
        if (typeobj_perdu.getValue() != null) {
             typeobj_perduRec = typeobj_perdu.getValue();
        }else {
            typeobj_perduRec = null;}
        
        String autretypeobj_perduRec;
        if (autretypeobj_perdu.getText()!= null) {
             autretypeobj_perduRec = autretypeobj_perdu.getText();
        }else {
            autretypeobj_perduRec = null;}
        
        
        
        String lieu_decouverteRec;
        if (lieu_decouverte.getValue() != null) {
             lieu_decouverteRec = lieu_decouverte.getValue();
        }else {
            lieu_decouverteRec = null;}
        
         String localisationRec;
        if (localisation.getValue() != null) {
             localisationRec = localisation.getValue();
        }else {
            localisationRec = null;}
        
        
        String autrelocalisationRec;
        if (autrelocalisation.getText()!= null) {
             autrelocalisationRec = autrelocalisation.getText();
        }else {
            autrelocalisationRec = null;}
        
        
         String etageRec;
        if (etage.getValue() != null) {
             etageRec = etage.getValue();
        }else {
            etageRec = null;}
        
        
        String salleRec;
        if (salle.getText()!= null) {
             salleRec = salle.getText();
        }else {
            salleRec = null;}
        
         Date date;
        if (date_decouverte.getValue() != null) {
            date = java.sql.Date.valueOf(date_decouverte.getValue());
        } else {
            date = null;}
        
       String descriptionRec=description.getText();
         if (description.getText()!= null) {
            descriptionRec = description.getText();
        } else {
            descriptionRec = null;}
        
        String photoRec;
        if (actionStatus.getText()!= null) {
            photoRec = actionStatus.getText();
        } else {
            photoRec = null;}
      
        Reclamation rec = new Reclamation(id,descriptionRec, date, lieu_decouverteRec, typeobj_perduRec, typeRec, autretypeobj_perduRec, localisationRec, autrelocalisationRec, etageRec, salleRec, photoRec);

        ReclamationService s = new ReclamationService();
        s.update(rec);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modification Annonce");
                alert.setHeaderText(null);
                alert.setContentText("Votre Annonce a été Modifié avec succés!");
                alert.showAndWait();
       }
       else if(recmalst.isSelected()){
           
        String matriculeRec;
        if (matricule.getText()!= null) {
            matriculeRec = matricule.getText();
        } else {
            matriculeRec = null;}
        
        
        String photo2Rec;
        if (actionStatus2.getText()!= null) {
            photo2Rec = actionStatus2.getText();
        } else {
            photo2Rec = null;}
        
        String typeRec;
        if (recmalst.isSelected()) {
             typeRec = recmalst.getText();
        }else {
            typeRec = null;}
        
        Reclamation rec1 = new Reclamation(id,matriculeRec,photo2Rec,typeRec);

        ReclamationService rs = new ReclamationService();
        rs.updateMal(rec1);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modification Annonce");
                alert.setHeaderText(null);
                alert.setContentText("Votre Annonce a été modifier avec succés !");
                alert.showAndWait();
       }else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Echec de l'ajout");
            alert.setHeaderText(null);
            alert.setContentText("Attention ! Veuillez remplir tous les champs ");

            alert.showAndWait();
       }
       
    }
   
    private void On_btn_annuler(ActionEvent event) {
          AnchorPane pane = new AnchorPane();
                try {
                    pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLMesReclamation.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLUpdateDeleteReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    private void On_btn_supprimer(ActionEvent event) {
        
        ReclamationService cs = new ReclamationService();
        System.out.println("faraaah");
       cs.remove(id);
        System.out.println(id);
        Alert alert = new Alert(AlertType.CONFIRMATION, "Etes vous sur de vouloir supprimer " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
       AnchorPane pane = new AnchorPane();
                try {
                    pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLMesReclamation.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLUpdateDeleteReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                rootpane.getChildren().setAll(pane);
    }}
    @FXML
    private void savePhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
      /*  //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", ".JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", ".PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
            */
            /*
               try {
                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
               imageview1.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(Esprit_Entraide.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        if (selectedFile != null) {
            //image =new Image(selectedFile.toURI().toString(),100,500,true,true);//path , prefered width , prefered heigh, PreserveRatio,Smooth
            //System.out.println(image);
            //imageview1 = new ImageView(image);
           // System.out.println(imageview1);
            //imageview1.setFitWidth(100);
            //imageview1.setFitHeight(150);
            //imageview1.setPreserveRatio(true);
            actionStatus.setText(selectedFile.getName());
            System.out.println(selectedFile.getName());
        } else {
           actionStatus.setText("File selection cancelled."); }
    }
    
      @FXML
    private void savePhoto2(ActionEvent event) {
        FileChooser fileChooser2 = new FileChooser();
        File selectedFile2 = fileChooser2.showOpenDialog(null);
        
        if (selectedFile2 != null) {
           // image =new Image(selectedFile2.toURI().toString(),100,500,true,true);//path , prefered width , prefered heigh, PreserveRatio,Smooth
            //System.out.println(image);
            //imageview1 = new ImageView(image);
            //System.out.println(imageview1);
            //imageview1.setFitWidth(100);
            //imageview1.setFitHeight(150);
            //imageview1.setPreserveRatio(true);
            actionStatus2.setText(selectedFile2.getName());
            System.out.println(selectedFile2.getName());
        } else {
           actionStatus2.setText("File selection cancelled."); }
    }
}
