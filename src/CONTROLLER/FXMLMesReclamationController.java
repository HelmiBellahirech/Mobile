 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Reclamation;
import SERVICE.ReclamationService;
import com.jfoenix.controls.JFXListView;
import javafx.scene.control.ListCell;
import com.sun.javafx.scene.control.skin.LabeledText;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
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
public class FXMLMesReclamationController implements Initializable {

    ReclamationService rs = new ReclamationService();
    List<Reclamation> reclamations = rs.findId_user(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getID());
   
    @FXML
    private JFXListView<Reclamation> List;
    @FXML
    private AnchorPane rootpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(reclamations);
        ObservableList<Reclamation> items = FXCollections.observableArrayList(reclamations);

        List.setCellFactory((ListView<Reclamation> arg0) -> {
            ListCell<Reclamation> cell = new ListCell<Reclamation>() {
                @Override
                protected void updateItem(Reclamation e, boolean btl) {
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
                                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                                    System.out.println("salut");
                                    Reclamation rec = List.getItems().get(List.getSelectionModel().getSelectedIndex());
                                    FXMLUpdateDeleteReclamationController l = new FXMLUpdateDeleteReclamationController();
                                    l.redirect(String.valueOf(rec.getId()));
                                    AnchorPane pane = new AnchorPane();
                                    try {
                                        pane = FXMLLoader.load(getClass().getResource("/GUI/FXMLUpdateDeleteReclamation.fxml"));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLUpdateDeleteReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    rootpane.getChildren().setAll(pane);
                                }
                            }

                        });
                            if("Reclamation Objet perdu".equals(e.getType())){
                            setText(" Type de Réclamation: " +e.getType()+" \n Description: " +e.getDescription()+ "\n Date: " + e.getDate_decouverte()+ "\n Lieu :"  + e.getLieu_decouverte()+ "\n Type d'objet perdu/trouvé: " + e.getTypeobj_perdu()+ "\n  autre: " + e.getAutretypeobj_perdu()+ "\n Ou exactement ? " + e.getLocalisation()+ "\n autre : " + e.getAutrelocalisation()+ "\n Etage: " + e.getEtage()+ "\n Salle: " + e.getSalle()+ "\n" );
                            }else if("Reclamation Objet trouvé".equals(e.getType())){
                            setText(" Type de Réclamation: " +e.getType()+"\n  Description: " +e.getDescription()+ "\n Date: " + e.getDate_decouverte()+ "\n Lieu :"  + e.getLieu_decouverte()+ "\n Type d'objet perdu/trouvé: " + e.getTypeobj_perdu()+ "\n  autre: " + e.getAutretypeobj_perdu()+ "\n Ou exactement ? " + e.getLocalisation()+ "\n autre : " + e.getAutrelocalisation()+ "\n Etage: " + e.getEtage()+ "\n Salle: " + e.getSalle()+ "\n" );
                            }else {
                            setText(" Type de Réclamation: " +e.getType()+"\n Matricule: " + e.getMatricule());
                            }
                       // setText(" Description: " +e.getDescription()+ "\n Date: " + e.getDate_decouverte()+ "\n Lieu :"  + e.getLieu_decouverte()+ "\n Type d'objet perdu/trouvé: " + e.getTypeobj_perdu()+ "\n type de votre réclamation: " + e.getType()+ "\n  autre: " + e.getAutretypeobj_perdu()+ "\n Ou exactement ? " + e.getLocalisation()+ "\n autre : " + e.getAutrelocalisation()+ "\n Etage: " + e.getEtage()+ "\n Matricule: " + e.getMatricule()+ "\n Salle: " + e.getSalle()+ "\n" );

                        setFont(Font.font("Berlin Sans FB Demi Bold", 13));

                        // setAlignment(Pos.CENTER);
                    }

                }

            };
            return cell;
        });
        System.out.println(items);
        List.setItems(items);

    }
}
