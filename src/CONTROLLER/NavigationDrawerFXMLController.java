/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nadia
 */
public class NavigationDrawerFXMLController implements Initializable {

    @FXML
    private Label usernameLB;
    @FXML
    private Label NameLB;
       public static NavigationDrawerFXMLController instance;
    public static String page;
    @FXML
    private JFXButton about;
    @FXML
    private JFXButton exit;
    @FXML
    private ImageView photo;
    @FXML
    private Label Email;
    @FXML
    private AnchorPane Anchorpane;
    
        public NavigationDrawerFXMLController()
    {
        instance = this;
    }
        public static NavigationDrawerFXMLController getInstance()
    {
        return instance;
    }
         public void setPage(String page) {
            
             this.page=page;
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(page=="Utilisateur"){
        usernameLB.setText(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getUsername());
        NameLB.setText(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getNom()+" "+esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getPrenom());
        Email.setText(esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getEmail());
        File f = new File("C:\\xampp\\htdocs\\pi\\"+esprit_entraide.Esprit_Entraide.getInstance().getLoggedUser().getPhoto());
        System.out.println(f.toURI().toString());
        
        
                        Image IMAGE_RUBY = new Image(f.toURI().toString());
                        //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());
                            
                        photo.setFitHeight(100);
                        photo.setFitWidth(100);
                        Rectangle clip = new Rectangle(
                                photo.getFitWidth(), photo.getFitHeight()
                        );

                        clip.setArcWidth(20);
                        clip.setArcHeight(20);
                        photo.setClip(clip);

                        // snapshot the rounded image.
                        SnapshotParameters parameters = new SnapshotParameters();
                        parameters.setFill(Color.TRANSPARENT);
                        WritableImage image = photo.snapshot(parameters, null);

                        // remove the rounding clip so that our effect can show through.
                        photo.setClip(null);

                        // apply a shadow effect.
                        photo.setEffect(new DropShadow(20, Color.BLACK));

        photo.setImage(IMAGE_RUBY);
        }
       
// TODO
        
    }    


    @FXML
    private void about(ActionEvent event) throws IOException {
    
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
                 esprit_entraide.Esprit_Entraide.getInstance().getStage().hide();
   esprit_entraide.Esprit_Entraide.getInstance().ChangeScene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/FXMLLogin.fxml"))));
 
 esprit_entraide.Esprit_Entraide.getInstance().getStage().show();
    }
    
}
