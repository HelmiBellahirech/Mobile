/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Covoiturage;
import MODEL.Etudiant;
import MODEL.Utilisateur;
import SERVICE.Covoiturage_service;
import SERVICE.UtilisateurService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author OrbitG
 */
public class FXMLProfilUtilisateurController implements Initializable {

    @FXML
    private JFXButton Retour;
    @FXML
    private Label NomPrenom;
    @FXML
    private Label Classelbl;
    @FXML
    private JFXTextField UsernameInput;
    @FXML
    private JFXTextField EmailInput;
    @FXML
    private JFXTextField AnMdp;
    @FXML
    private JFXTextField TelInput;
    @FXML
    private JFXTextField Mdp;
    @FXML
    private JFXTextField ValidMdp;
    @FXML
    private JFXButton Update;
    @FXML
    private JFXButton Desactivez;
    @FXML
    private JFXButton Annonce;
    @FXML
    private Label Date_Creation;
    @FXML
    private Label Mdplbl;
    @FXML
    private Label ValidMdplbl;
    @FXML
    private Label AnMdplbl;
    @FXML
    private ImageView img;
    @FXML
    private Label UsernameInput1;
    @FXML
    private Label EmailInput1;
    @FXML
    private Label TelInput1;
    @FXML
    private AnchorPane rootpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Mdp.setVisible(false);
        Mdplbl.setVisible(false);
        AnMdp.setVisible(false);
        AnMdplbl.setVisible(false);
        ValidMdp.setVisible(false);
        ValidMdplbl.setVisible(false);
        UsernameInput.setVisible(false);
        EmailInput.setVisible(false);
        TelInput.setVisible(false);
        Update.setVisible(false);

        //   if(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getRole().equals("Etudiant"))
        //Etudiant e = (Etudiant) esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser() ; 
       
        Date_Creation.setText("Compte Crée le " + esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getDate_Creation());
        NomPrenom.setText(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getNom() + " " + esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getPrenom());
         if(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser() instanceof Etudiant)
        {
            Etudiant e =(Etudiant) esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser();
        Classelbl.setText(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getRole()+" en "+e.getClasse());
        UsernameInput1.setText(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getUsername());
       
        File f = new File("C:\\xampp\\htdocs\\pi\\" + esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getPhoto());
        System.out.println(f.toURI().toString());

        Image IMAGE_RUBY = new Image(f.toURI().toString());
        //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

        img.setFitHeight(100);
        img.setFitWidth(100);
        Rectangle clip = new Rectangle(
                img.getFitWidth(), img.getFitHeight()
        );

        clip.setArcWidth(20);
        clip.setArcHeight(20);
        img.setClip(clip);

        // snapshot the rounded image.
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = img.snapshot(parameters, null);

        // remove the rounding clip so that our effect can show through.
        img.setClip(null);

        // apply a shadow effect.
        img.setEffect(new DropShadow(20, Color.BLACK));

        img.setImage(IMAGE_RUBY);
        EmailInput1.setText(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getEmail());
        TelInput1.setText(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getTelephone());
        }
        
    }

    @FXML
    private void On_btn_Retour(ActionEvent event) {
        AnchorPane pane = new AnchorPane();
        try {
            pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLAcceuilUtilisateur.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLAfficheCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void On_btn_Modifier(ActionEvent event) {
       
        
    }

    @FXML
    private void On_btn_Desactiver(ActionEvent event) {

    }

    @FXML
    private void Consulter_Annonce(ActionEvent event) {
        AnchorPane pane = new AnchorPane();
        try {
            pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLMesAnnonces.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLAfficheCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void On_MDP(KeyEvent event) {
        ValidMdp.setVisible(true);
        ValidMdplbl.setVisible(true);

    }

    @FXML
    private void On_Username_Clicked(MouseEvent event) {
        UsernameInput.setVisible(true);
        Update.setVisible(true);
        Mdp.setVisible(true);
        Mdplbl.setVisible(true);
        UsernameInput1.setVisible(false);

    }

    @FXML
    private void On_Email_Clicked(MouseEvent event) {
        EmailInput.setVisible(true);
        Update.setVisible(true);
        Mdp.setVisible(true);
        Mdplbl.setVisible(true);
        EmailInput1.setVisible(false);
    }

    @FXML
    private void On_Telephone_Clicked(MouseEvent event) {
        TelInput.setVisible(true);
        Update.setVisible(true);
        Mdp.setVisible(true);
        Mdplbl.setVisible(true);
        TelInput1.setVisible(false);
    }

}
