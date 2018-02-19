/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Covoiturage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import SERVICE.Covoiturage_service;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author OrbitG
 */
public class FXMLAjoutCovoiturageController implements Initializable {

    @FXML
    private JFXButton btn_valider;
    @FXML
    private JFXButton btn_retour;
    @FXML
    private Label FumeurRadio;
    @FXML
    private JFXTextField DepartInput;
    @FXML
    private JFXTextField ArriveInput;
    @FXML
    private JFXTimePicker HeureInput;
    @FXML
    private DatePicker DateInput;
    @FXML
    private JFXComboBox<String> ComfortCombobox;
    ObservableList<String> Comfortoption
            = FXCollections.observableArrayList("Basique", "Normale", "Comfortable", "Luxe");
    @FXML
    private JFXTextField PrixInput;
    @FXML
    private JFXComboBox<String> NbPlacesCombobox;
    ObservableList<String> Nbplacesoption
            = FXCollections.observableArrayList("1", "2", "3", "4");

    @FXML
    private ToggleGroup Mygroup;
    @FXML
    private RadioButton oui;
    @FXML
    private RadioButton non;
    @FXML
    private AnchorPane rootpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComfortCombobox.setItems(Comfortoption);
        NbPlacesCombobox.setItems(Nbplacesoption);
    }

    @FXML
    private void On_btn_valider(ActionEvent event) throws ParseException {
        String fumeur = "";
        String depart = DepartInput.getText();
        String arrive = ArriveInput.getText();
        Date date;
        if (DateInput.getValue() != null) {
            date = java.sql.Date.valueOf(DateInput.getValue());
        } else {
            date = null;
        }
        String heure;

        if (HeureInput.getValue() != null) {
            heure = HeureInput.getValue().toString();
        } else {
            heure = null;
        }
        String nbrplaces1 = NbPlacesCombobox.getValue();
        String comfort = ComfortCombobox.getValue();
        String prix1 = PrixInput.getText();
        int nbplace;
        if (NbPlacesCombobox.getValue() != null) {
            nbplace = Integer.parseInt(NbPlacesCombobox.getValue());
        } else {
            nbplace = 0;
        }
        if (oui.isSelected()) {
            fumeur = oui.getText();
        }
        if (non.isSelected()) {
            fumeur = non.getText();
        }
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

        if ((!"".equals(depart)) && (!"".equals(arrive)) && (date != null) && (!"".equals(heure)) && (!"".equals(nbrplaces1)) && (!"".equals(prix1))) {

            if (date.compareTo(date_sql) < 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Echec de l'ajout");
                alert.setHeaderText(null);
                alert.setContentText("Attention ! Date invalide !");
                alert.showAndWait();
            } else {
                float prix = Float.parseFloat(PrixInput.getText());
                int nbrplaces = Integer.parseInt(NbPlacesCombobox.getValue());
                Covoiturage C = new Covoiturage(depart, arrive, prix, date, heure, nbplace, comfort, fumeur);
                Covoiturage_service cs = new Covoiturage_service();
                cs.add(C);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ajout Annonce");
                alert.setHeaderText(null);
                alert.setContentText("Votre Annonce a ete ajouté !");

                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Echec de l'ajout");
            alert.setHeaderText(null);
            alert.setContentText("Attention ! Veuillez remplir tous les champs ");

            alert.showAndWait();
        }

    }

    @FXML
    private void On_btn_retour(ActionEvent event) throws IOException {

         AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLAfficheCovoiturage.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLAjoutCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    rootpane.getChildren().setAll(pane);
    }

}


/* Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Echec de l'ajout");
        alert.setHeaderText(null);
        alert.setContentText("Attention ! ");
        alert.showAndWait();*/
