/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Colocation;
import MODEL.Covoiturage;
import SERVICE.Colocation_service;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLInfoCollocationController implements Initializable {

    @FXML
    private Label typr_log;
    @FXML
    private Label nbChambre;
    @FXML
    private Label prix;
    @FXML
    private Label nbPersonne;
    @FXML
    private Label meu;
    @FXML
    private Label eta;
    @FXML
    private Label date_dis;
    @FXML
    private JFXButton retour;
    @FXML
    private AnchorPane pa;
    private static int id ; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Colocation col = new Colocation_service().findId(id);
        typr_log.setText(col.getType_log());
         nbChambre.setText(String.valueOf(col.getNbChambre()));
         prix.setText(String.valueOf(col.getPrix()));
          meu.setText(col.getMeuble());
         eta.setText(col.getEtage());
        nbPersonne.setText(String.valueOf(col.getNbPersonne()));
        date_dis.setText(col.getDate_dispo().toString());
       
        
    }    
      public void redirect(String id){
        System.out.println("Interface Affiche Details ");
        System.out.println(id);
        this.id = Integer.parseInt(id);
    
    }
    

    @FXML
    private void retour_but(ActionEvent event) {
           AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLChercherAll.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLInfoCollocationController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    pa.getChildren().setAll(pane);
    }
    
}
