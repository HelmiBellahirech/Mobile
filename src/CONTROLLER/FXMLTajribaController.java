/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Covoiturage;
import SERVICE.Covoiturage_service;
import com.jfoenix.controls.JFXListView;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
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
    Covoiturage_service cs= new Covoiturage_service(); 
    List<Covoiturage> covoiturages = cs.findByDepartArrive(FXMLAfficheCovoiturageController.Depart, FXMLAfficheCovoiturageController.Arrive) ; 
    @FXML
    private JFXListView<Covoiturage> List;
    @Override
            
    
    
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Covoiturage> items = FXCollections.observableArrayList(covoiturages);

        List.setCellFactory((ListView<Covoiturage> arg0) -> {
            ListCell<Covoiturage> cell = new ListCell<Covoiturage>() {
                @Override
                protected void updateItem(Covoiturage e, boolean btl) {
                    super.updateItem(e, btl);

                    if (e != null) {
                        //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                        File file = new File("C:\\Users\\OrbitG\\Desktop\\3A9\\JAVA\\Esprit_Entraide\\src\\images.png");
                        file.getParentFile().mkdirs();
                        Image IMAGE_RUBY = new Image(file.toURI().toString());
                        //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                        ImageView imgview = new ImageView(IMAGE_RUBY);

                        setGraphic(imgview);

                        imgview.setFitHeight(100);
                        imgview.setFitWidth(100);
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

                        setText(" De "+FXMLAfficheCovoiturageController.Depart + " à " + FXMLAfficheCovoiturageController.Arrive + "\n" + "  en " + e.getDate() + " a "  + e.getHeure() + "\n" +" Nombre de Places disponible "+e.getNbrPlaces() );

                        setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                        // setAlignment(Pos.CENTER);
                    }

                }

            };
            return cell;
        });
        List.setItems(items);
        
    }    
    
}
