/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLAcceuilReclamationController implements Initializable {

    @FXML
    private ImageView img11;
    @FXML
    private JFXButton Rechercher;
    @FXML
    private JFXButton Ajouter;
    @FXML
    private AnchorPane rootpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void On_btn_Menu(ActionEvent event) {
        AnchorPane pane = new AnchorPane();
            try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLAcceuilUtilisateur.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLAjoutReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    rootpane.getChildren().setAll(pane);
    
    }

    @FXML
    private void On_btn_Rechercher(ActionEvent event) {
          AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLSearchReclamation.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLSearchReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    rootpane.getChildren().setAll(pane);

    
    }

    @FXML
    private void On_btn_Ajouter(ActionEvent event) {
         AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLAjoutReclamation.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLAjoutReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    rootpane.getChildren().setAll(pane);

    
    }
    
}
