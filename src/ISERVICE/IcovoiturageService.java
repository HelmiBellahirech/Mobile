package ISERVICE;


import ISERVICE.Iservice;
import MODEL.Covoiturage;
import java.util.List;
import java.util.Observable;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author OrbitG
 */
public interface IcovoiturageService extends Iservice<Covoiturage,Integer>{
   public List<Covoiturage> findByDepartArrive(String Depart,String Arrive,Integer ID); 
    public List<Covoiturage> findId_user(Integer r) ;
     public List<Covoiturage> findByDepart(String Depart,Integer ID); 
      public List<Covoiturage> findByArrive(String Arrive,Integer ID); 
   public List<Covoiturage> getAllSaufUser(Integer ID);
}
