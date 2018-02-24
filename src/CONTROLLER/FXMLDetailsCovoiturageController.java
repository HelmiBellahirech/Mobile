/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Covoiturage;
import MODEL.Reservationcov;
import MODEL.Utilisateur;
import SERVICE.Covoiturage_service;
import SERVICE.ReservationcovService;
import SERVICE.UtilisateurService;
import UTILS.InputValidation;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
    private static int id;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private JFXButton a;
    @FXML
    private JFXButton Reserver;
    @FXML
    private Label pubpar;
    @FXML
    private Label adresse;
    @FXML
    private Label numtel;
    @FXML
    private Label nbr;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Covoiturage c = new Covoiturage_service().findId(id);
        UtilisateurService us = new UtilisateurService();
        Utilisateur u = us.getById(c.getID_USER()) ;
        departtitre.setText(c.getDepart());
        arrivetitre.setText(c.getArrive());
        depart.setText(c.getDepart());
        arrive.setText(c.getArrive());
        datetitre.setText(c.getDate().toString());
        heure.setText(c.getHeure());
        prix.setText(String.valueOf(c.getPrix()));
        fumeur.setText(c.getFumeur());
        comfort.setText(c.getComfort());
        nbr.setText(String.valueOf(c.getNbrPlaces())) ;
        pubpar.setText(u.getNom()+" "+u.getPrenom());
        adresse.setText(u.getEmail());
        numtel.setText(u.getTelephone());
        File f = new File("C:\\xampp\\htdocs\\pi\\"+u.getPhoto());
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
        
        
    }

    public void redirect(String id) {
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

    @FXML
    private void On_btn_Reserver(ActionEvent event) {
        Covoiturage c = new Covoiturage_service().findId(id);
        Covoiturage_service cs = new Covoiturage_service();
        List<Integer> choices = new ArrayList<>();
        choices.add(1);
        choices.add(2);
        choices.add(3);
        choices.add(4);

        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(1, choices);
        dialog.setTitle("Reservation");
        dialog.setHeaderText("Reservation au trajet");
        dialog.setContentText("Choissizer le nombre de places souhaité:");

// Traditional way to get the response value.
        Optional<Integer> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Votre choix: " + result.get());

            if (result.get() > c.getNbrPlaces()) {

                Alert alert = new InputValidation().getAlert("ERREUR", "Le nombre de place est superieur au " + "\n    " + "nombre de place disponible");
                alert.showAndWait();

            }    
            else {
                
                Reservationcov reservation = new Reservationcov();
                reservation.setID_RESERVE(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getID());
                reservation.setID_CAHUFFEUR(c.getID_USER());
                reservation.setID_ANNONCE(c.getID());
                reservation.setETAT(false);
                reservation.setNBPLACES(result.get());
                ReservationcovService rs = new ReservationcovService();
                if(rs.verifReservation(reservation)!=null)
                {
                    Alert alert = new InputValidation().getAlert("ERREUR", "Vous avez deja reservé a ce trajet");
                alert.showAndWait();
                }
                else { rs.add(reservation);
                Alert alert = new InputValidation().getAlert("Succes", "Votre Demande a été envoyé avec succes");
                alert.showAndWait();
                AnchorPane pane = new AnchorPane();
                
                /*c.setNbrPlaces(c.getNbrPlaces() - result.get());
                cs.update(c);*/

                try {
                    pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLTajriba.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDetailsCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
                }
                rootpane.getChildren().setAll(pane);

            }
            }
        }

    }

}
