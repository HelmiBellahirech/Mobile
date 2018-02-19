/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Covoiturage;
import SERVICE.Covoiturage_service;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author OrbitG
 */
public class FXMLDetailsCovoiturageController implements Initializable {

    @FXML
    private Label depart;
    @FXML
    private Label arrive;
    @FXML
    private Label heure;
    @FXML
    private Label comfort;
    @FXML
    private Label fumeur;
    @FXML
    private Label prix;
    @FXML
    private Label departtitre;
    @FXML
    private Label arrivetitre;
    @FXML
    private Label datetitre;
    private static int id ; 
    @FXML
    private AnchorPane rootpane;
    @FXML
    private JFXButton a;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Covoiturage c= new Covoiturage_service().findId(id); 
        departtitre.setText(c.getDepart());
        arrivetitre.setText(c.getArrive());
        depart.setText(c.getDepart());
        arrive.setText(c.getArrive());
        datetitre.setText(c.getDate().toString());
        heure.setText(c.getHeure());
        prix.setText(String.valueOf(c.getPrix()));
        fumeur.setText(c.getFumeur());
        comfort.setText(c.getComfort());
        
    }    
     public void redirect(String id){
        System.out.println("Interface Affiche Details ");
        System.out.println(id);
        this.id = Integer.parseInt(id);
    
    }

   

    @FXML
    private void a(ActionEvent event) throws IOException {
        
         AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLTajriba.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLDetailsCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    rootpane.getChildren().setAll(pane);
    }
}
