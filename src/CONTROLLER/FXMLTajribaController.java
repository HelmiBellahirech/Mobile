/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Covoiturage;
import SERVICE.Covoiturage_service;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.control.skin.LabeledText;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author OrbitG
 */
public class FXMLTajribaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Covoiturage_service cs = new Covoiturage_service();
    List<Covoiturage> covoiturages = cs.findByDepartArrive(FXMLAfficheCovoiturageController.Depart, FXMLAfficheCovoiturageController.Arrive);
    String depart = FXMLAfficheCovoiturageController.Depart;
    String arrive = FXMLAfficheCovoiturageController.Arrive;
    @FXML
    private JFXListView<Covoiturage> List;
    private final ObservableList<Covoiturage> data = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<String> ComfortCombobox;
    ObservableList<String> Comfortoption
            = FXCollections.observableArrayList("Basique", "Normale", "Comfortable", "Luxe");
    @FXML
    private JFXTextField min;
    @FXML
    private JFXTextField max;
    @FXML
    private JFXButton Recherche;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private JFXButton Retour;

    @Override

    public void initialize(URL url, ResourceBundle rb) {

        ComfortCombobox.setItems(Comfortoption);

        ObservableList<Covoiturage> items = FXCollections.observableArrayList(covoiturages);

        List.setCellFactory((ListView<Covoiturage> arg0) -> {
            ListCell<Covoiturage> cell = new ListCell<Covoiturage>() {
                @Override
                protected void updateItem(Covoiturage e, boolean btl) {
                    super.updateItem(e, btl);

                    if (e != null) {
                        //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                        File file = new File("src\\images.png");
                        file.getParentFile().mkdirs();
                        Image IMAGE_RUBY = new Image(file.toURI().toString());
                        //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                        ImageView imgview = new ImageView(IMAGE_RUBY);

                        setGraphic(imgview);

                        imgview.setFitHeight(70);
                        imgview.setFitWidth(70);
                        Rectangle clip = new Rectangle(
                                imgview.getFitWidth(), imgview.getFitHeight()
                        );

                        clip.setArcWidth(20);
                        clip.setArcHeight(20);
                        imgview.setClip(clip);

                        // snapshot the rounded image.
                        SnapshotParameters parameters = new SnapshotParameters();
                        parameters.setFill(Color.TRANSPARENT);
                        WritableImage image = imgview.snapshot(parameters, null);

                        // remove the rounding clip so that our effect can show through.
                        imgview.setClip(null);

                        // apply a shadow effect.
                        imgview.setEffect(new DropShadow(20, Color.BLACK));

                        // store the rounded image in the imageView.
                        imgview.setImage(image);
                        TextField id = new TextField(String.valueOf(e.getID()));
                            id.setVisible(true);
                             setId(String.valueOf(e.getID()));
                        List.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                                   Covoiturage cov = List.getItems().get(List.getSelectionModel().getSelectedIndex()) ; 

                                    FXMLDetailsCovoiturageController l = new FXMLDetailsCovoiturageController();
                                    l.redirect(String.valueOf(cov.getID()));
                                    System.out.println(cov.getID());
                                    AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLDetailsCovoiturage.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLDetailsCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    rootpane.getChildren().setAll(pane);
                                }
                            }

                        });

                        setText(e.getDepart() + "----->" + e.getArrive() + "\n" + " En " + e.getDate() + " à " + e.getHeure() + "\n  " + "    Nombre de Places disponible " + e.getNbrPlaces() + "\n" + "                   Prix En DT " + e.getPrix());

                        setFont(Font.font("Berlin Sans FB Demi Bold", 13));

                        // setAlignment(Pos.CENTER);
                    }

                }

            };
            return cell;
        });
        List.setItems(items);

    }

    @FXML
    private void On_btn_Recherche(ActionEvent event) {
        if (min.getText().equals("") == true) {
            min.setText("0");
        }
        if (max.getText().equals("") == true) {
            max.setText("99999999");
        }
        if (ComfortCombobox.getValue() == null) {
            ComfortCombobox.setValue("");
        }

        covoiturages = new Covoiturage_service().getAll().stream()
                .filter(s -> s.getDepart().equals(depart))
                .filter(s -> s.getArrive().equals(arrive))
                .filter(s -> s.getComfort().contains(ComfortCombobox.getValue()))
                .filter(s -> s.getPrix() >= Integer.parseInt(min.getText()))
                .filter(s -> s.getPrix() <= Integer.parseInt(max.getText()))
                .collect(Collectors.toList());

        ObservableList<Covoiturage> items = FXCollections.observableArrayList(covoiturages);
        items.clear();
        List.getItems().clear();
        max.setText("");
        min.setText("");
        covoiturages.forEach(e -> {
            items.add(e);
            System.out.println(e);
        });
        ComfortCombobox.setItems(Comfortoption);

        List.setCellFactory((ListView<Covoiturage> arg0) -> {
            ListCell<Covoiturage> cell = new ListCell<Covoiturage>() {
                @Override
                protected void updateItem(Covoiturage e, boolean btl) {
                    super.updateItem(e, btl);

                    if (e != null) {
                        //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                        File file = new File("src\\images.png");
                        file.getParentFile().mkdirs();
                        Image IMAGE_RUBY = new Image(file.toURI().toString());
                        //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                        ImageView imgview = new ImageView(IMAGE_RUBY);

                        setGraphic(imgview);

                        imgview.setFitHeight(70);
                        imgview.setFitWidth(70);
                        Rectangle clip = new Rectangle(
                                imgview.getFitWidth(), imgview.getFitHeight()
                        );

                        clip.setArcWidth(20);
                        clip.setArcHeight(20);
                        imgview.setClip(clip);

                        // snapshot the rounded image.
                        SnapshotParameters parameters = new SnapshotParameters();
                        parameters.setFill(Color.TRANSPARENT);
                        WritableImage image = imgview.snapshot(parameters, null);

                        // remove the rounding clip so that our effect can show through.
                        imgview.setClip(null);

                        // apply a shadow effect.
                        imgview.setEffect(new DropShadow(20, Color.BLACK));

                        // store the rounded image in the imageView.
                        imgview.setImage(image);
                        List.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2
                                        && (event.getTarget() instanceof LabeledText || ((GridPane) event.getTarget()).getChildren().size() > 0)) {
                                    System.out.println("salut");

                                    FXMLDetailsCovoiturageController l = new FXMLDetailsCovoiturageController();
                                    l.redirect(String.valueOf(e.getID()));
                                    AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLDetailsCovoiturage.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLDetailsCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    rootpane.getChildren().setAll(pane);
                                }
                            }

                        });
                        setText(e.getDepart() + "----->" + e.getArrive() + "\n" + " En " + e.getDate() + " à " + e.getHeure() + "\n" + " Nombre de Places disponible " + e.getNbrPlaces() + "\n" + "               Prix En DT " + e.getPrix() + e.getID_USER());

                        setFont(Font.font("Berlin Sans FB Demi Bold", 13));

                        // setAlignment(Pos.CENTER);
                    }

                }

            };
            return cell;
        });
        List.setItems(items);

    }

    @FXML
    private void On_btn_Retour(ActionEvent event) {
        AnchorPane pane = new AnchorPane();
        try {
            pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLAfficheCovoiturage.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDetailsCovoiturageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootpane.getChildren().setAll(pane);
    }

}
