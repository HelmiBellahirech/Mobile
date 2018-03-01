/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLAfficheCollocationController implements Initializable {

    @FXML
    private ImageView imacol;
   
    @FXML
    private JFXButton pub;
    @FXML
    private JFXButton rechercher;
    public static String Adresse;
    @FXML
    private AnchorPane pane1;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXTextField Adresse_in;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   

    @FXML
    private void but_pub(ActionEvent event) {
           AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLAjoutCollocation.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLAjoutCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    pane1.getChildren().setAll(pane);

    }

    @FXML
    private void rechercher_Ann(ActionEvent event) {
                   Adresse=Adresse_in.getText(); 
       
        AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLChercherAll.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLChercherAllController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    pane1.getChildren().setAll(pane);
    } 

     @FXML
    private void but_retour(ActionEvent event) {
         AnchorPane pane = new AnchorPane();
        try {
            pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLAcceuilUtilisateur.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDetailsCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pane1.getChildren().setAll(pane);
    }
}
    

