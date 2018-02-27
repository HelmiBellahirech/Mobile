/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication25;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.sun.prism.PhongMaterial.MapType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author habib
 */
public class Map extends Application  implements MapComponentInitializedListener {
    
 GoogleMapView mapView;

@Override
public void start(Stage stage) throws Exception {

    //Create the JavaFX component and set this as a listener so we know when 
    //the map has been initialized, at which point we can then begin manipulating it.
    mapView = new GoogleMapView();
    mapView.addMapInializedListener(this);

    Scene scene = new Scene(mapView);

    stage.setTitle("JavaFX and Google Maps");
    stage.setScene(scene);
    stage.show();
}
  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }
  
  
  
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

  InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

    
  
  

@Override
public void mapInitialized() {
    //Set the initial properties of the map.
    Double l =0.0;
    Double log=0.0;
    Double l1 =0.0;
    Double log1=0.0;
    String adresse="jerba";
      String adresse1="Tunis";
    String lat, lon;
    String locationAddres1 = adresse1.replaceAll(" ", "%20");
       String locationAddres = adresse.replaceAll(" ", "%20");
        String str = "http://maps.googleapis.com/maps/api/geocode/json?address=" + locationAddres + "&sensor=true";    
           
        String str1 = "http://maps.googleapis.com/maps/api/geocode/json?address=" + locationAddres1 + "&sensor=true";    
          
 
           
      
     try {
         JSONObject json = readJsonFromUrl(str);
          JSONObject geoMetryObject = new JSONObject();
            JSONObject locations =json;
            JSONArray jarr = json.getJSONArray("results");
            int i;
            for (i = 0; i < jarr.length(); i++) {
                json = jarr.getJSONObject(i);
                geoMetryObject = json.getJSONObject("geometry");
                locations = geoMetryObject.getJSONObject("location");
                l = locations.getDouble("lat");
                log = locations.getDouble("lng");
     
            }
                         
 
         
     } catch (IOException ex) {
         Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
     } catch (JSONException ex) {
         Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
     }
  
     try {
         JSONObject json1 = readJsonFromUrl(str1);
          JSONObject geoMetryObject1 = new JSONObject();
            JSONObject locations1 =json1;
            JSONArray jarr = json1.getJSONArray("results");
            int i;
            for (i = 0; i < jarr.length(); i++) {
                json1 = jarr.getJSONObject(i);
                geoMetryObject1 = json1.getJSONObject("geometry");
                locations1 = geoMetryObject1.getJSONObject("location");
                l1 = locations1.getDouble("lat");
                log1 = locations1.getDouble("lng");
     
            }
                         
 
         
     } catch (IOException ex) {
         Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
     } catch (JSONException ex) {
         Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
     }

         
    
    MapOptions mapOptions = new MapOptions();

    mapOptions.center(new LatLong(l, log))
            .overviewMapControl(false)
            .panControl(false)
            .rotateControl(false)
            .scaleControl(false)
            .streetViewControl(false)
            .zoomControl(false)
            .zoom(7);

    map = mapView.createMap(mapOptions);

    //Add a marker to the map
    MarkerOptions markerOptions = new MarkerOptions();

    markerOptions.position( new LatLong(l, log) )
                .visible(Boolean.TRUE)
                .title("Depart");

    Marker marker = new Marker( markerOptions );
  MarkerOptions markerOptions1 = new MarkerOptions();

    markerOptions1.position( new LatLong(l1, log1) )
                .visible(Boolean.TRUE)
                .title("Arrive");

    Marker marker1 = new Marker( markerOptions1 );

   
    map.addMarker(marker);
     map.addMarker(marker1);

}

public static void main(String[] args) {
    launch(args);
}
}