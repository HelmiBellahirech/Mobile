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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author OrbitG
 */
public class FXMLAcceuilAdministrateurController implements Initializable {

    @FXML
    private Pane Contenu;
    @FXML
    private JFXButton Decnx;
    @FXML
    private ImageView img;
    @FXML
    private JFXButton Profil;
    @FXML
    private JFXButton Annonce;
    @FXML
    private JFXButton Utilisateur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void On_btn_Decnx(ActionEvent event) throws IOException {
        esprit_entraide.Esprit_Entraide.getInstance().getStage().hide();
   esprit_entraide.Esprit_Entraide.getInstance().ChangeScene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXMLLogin.fxml"))));
 
 esprit_entraide.Esprit_Entraide.getInstance().getStage().show();
    }

    @FXML
    private void On_btn_Profil(ActionEvent event) {
    }

    @FXML
    private void On_btn_Annonce(ActionEvent event) {
    }

    @FXML
    private void On_btn_Utilisateur(ActionEvent event) {
    }
    
}
