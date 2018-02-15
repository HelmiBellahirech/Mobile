/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import SERVICE.UtilisateurService;
import UTILS.InputValidation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author OrbitG
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Pane pane;
    @FXML
    private Label lbl_titr;
    @FXML
    private JFXTextField Input_email;
    @FXML
    private JFXButton btn_connexion;
    @FXML
    private JFXButton btn_inscrire;
    @FXML
    private JFXPasswordField Input_pw;
    @FXML
    private Hyperlink forgetpw;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img4;

    UtilisateurService us = new UtilisateurService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void on_btn_connexion(ActionEvent event) throws IOException {

        int resultatU;
        String email = Input_email.getText().toLowerCase();
        String mdp = Input_pw.getText();
        resultatU = us.login(email, mdp);
        System.out.println(resultatU);
        if (resultatU == 3) {
            esprit_entraide.Esprit_Entraide.getInstance().getStage().hide();
            esprit_entraide.Esprit_Entraide.getInstance().ChangeScene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXMLAcceuilAdministrateur.fxml"))));
            esprit_entraide.Esprit_Entraide.getInstance().getStage().show();
        } else if (resultatU == 0) {
            esprit_entraide.Esprit_Entraide.getInstance().getStage().hide();
            esprit_entraide.Esprit_Entraide.getInstance().ChangeScene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXMLAcceuilUtilisateur.fxml"))));
            esprit_entraide.Esprit_Entraide.getInstance().getStage().show();
        } else if (resultatU == 4) {
            esprit_entraide.Esprit_Entraide.getInstance().getStage().hide();
            esprit_entraide.Esprit_Entraide.getInstance().ChangeScene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXMLAccueilResponsable.fxml"))));
            esprit_entraide.Esprit_Entraide.getInstance().getStage().show();
        } else if (resultatU == 1) {
            Alert alertMDP = new InputValidation().getAlert("Mot de passe", "Mot de passe incorrect");
            alertMDP.showAndWait();
        } else if (resultatU == 2) {
            Alert alertEmail = new InputValidation().getAlert("Utilisateur inexistant", "Cette adresse email ne correspond à aucun utilisateur");
            alertEmail.showAndWait();
        }
    }

    @FXML
    private void On_btn_inscrire(ActionEvent event) {
    }

    @FXML
    private void On_forgetpw(ActionEvent event) {
    }

}
