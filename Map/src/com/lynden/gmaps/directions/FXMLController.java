/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lynden.gmaps.directions;

import com.lynden.gmapsfx.GoogleMapView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author OrbitG
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField fromTextField;
    @FXML
    private TextField toTextField;
    @FXML
    private GoogleMapView mapView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       mapView.addMapInializedListener(this);
        to.bindBidirectional(toTextField.textProperty());
        from.bindBidirectional(fromTextField.textProperty());
    }    

    @FXML
    private void toTextFieldAction(ActionEvent event) {
    }
    
}
