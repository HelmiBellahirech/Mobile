/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DataSource.DataSource;
import ISERVICE.IreservationcovService;
import MODEL.Reservationcov;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OrbitG
 */
public class ReservationcovService implements IreservationcovService{
    
    Connection connection;

    public ReservationcovService() {
        connection = DataSource.getInstance().getConnection();
    }
    
    @Override
    public void add(Reservationcov t) {
        String req = "insert into reservationcovoiturage (ID_RESERVE,ID_CHAUFFEUR,ID_ANNONCE,ETAT,NBPLACES) values (?,?,?,?,?)";

        PreparedStatement preparedStatement;

//Tu fais tes traitement sur date_util...
//Tu castes à la fin pour insérer en base.
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            preparedStatement = connection.prepareStatement(req);

            // 
            preparedStatement.setInt(1, t.getID_RESERVE());
            preparedStatement.setInt(2, t.getID_CAHUFFEUR());
             preparedStatement.setInt(3, t.getID_ANNONCE());
              
            preparedStatement.setBoolean(4, t.isETAT());
            preparedStatement.setInt(5, t.getNBPLACES());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Reservationcov t) {
       String req = "update reservationcovoiturage set  ID_RESERVE=?,ID_CHAUFFEUR=?,ID_ANNONCE=?,ETAT=?,NBPLACES=? where ID = ?";
        PreparedStatement preparedStatement;
        java.util.Date date_util = new java.util.Date();
//Tu fais tes traitement sur date_util...

//Tu castes à la fin pour insérer en base.
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            preparedStatement = connection.prepareStatement(req);

           preparedStatement.setInt(1, t.getID_RESERVE());
            preparedStatement.setInt(2, t.getID_CAHUFFEUR());
            preparedStatement.setInt(3, t.getID_ANNONCE());
            preparedStatement.setBoolean(4, t.isETAT());
            preparedStatement.setInt(5, t.getNBPLACES());
             
             preparedStatement.setInt(6, t.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Integer r) {
  String req = "delete from reservationcovoiturage where ID=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Reservationcov findId(Integer r) {
      Reservationcov reservationcov = null;
        String req = "select * from reservationcovoiturage where ID =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reservationcov = new Reservationcov(resultSet.getInt("ID"), resultSet.getInt("ID_RESERVE"), resultSet.getInt("ID_CHAUFFEUR"), resultSet.getInt("ID_ANNONCE"),resultSet.getBoolean("ETAT"),resultSet.getInt("NBPLACES"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reservationcov;
    }

    @Override
    public List<Reservationcov> getAll() {
         Reservationcov reservationcov = null;
        List<Reservationcov> reservationcovs = new ArrayList<>();
        String req = "select * from reservationcovoiturage";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reservationcov = new Reservationcov(resultSet.getInt("ID"), resultSet.getInt("ID_RESERVE"), resultSet.getInt("ID_CHAUFFEUR"), resultSet.getInt("ID_ANNONCE"),  resultSet.getBoolean("ETAT"),  resultSet.getInt("NBPLACES"));
                reservationcovs.add(reservationcov);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reservationcovs;
    }
    @Override
    public List<Reservationcov> findByReserve(Integer r ) {
         Reservationcov reservationcov = null;
        List<Reservationcov> reservationcovs = new ArrayList<>();
        String req = "select * from reservationcovoiturage where ID_RESERVE=?";
        
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reservationcov = new Reservationcov(resultSet.getInt("ID"), resultSet.getInt("ID_RESERVE"), resultSet.getInt("ID_CHAUFFEUR"), resultSet.getInt("ID_ANNONCE"),  resultSet.getBoolean("ETAT"),  resultSet.getInt("NBPLACES"));
                reservationcovs.add(reservationcov);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reservationcovs;
    }
     @Override
    public List<Reservationcov> findByChauffeur(Integer r ) {
         Reservationcov reservationcov = null;
        List<Reservationcov> reservationcovs = new ArrayList<>();
        String req = "select * from reservationcovoiturage where ID_CHAUFFEUR=?";
        
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reservationcov = new Reservationcov(resultSet.getInt("ID"), resultSet.getInt("ID_RESERVE"), resultSet.getInt("ID_CHAUFFEUR"), resultSet.getInt("ID_ANNONCE"),  resultSet.getBoolean("ETAT"),  resultSet.getInt("NBPLACES"));
                reservationcovs.add(reservationcov);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reservationcovs;
    }
    @Override
    public Reservationcov verifReservation(Reservationcov res) 
    {
         Reservationcov reservationcov = null;
        String req = "select * from reservationcovoiturage where ID_RESERVE=? AND ID_CHAUFFEUR=? AND ID_ANNONCE=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, res.getID_RESERVE());
            preparedStatement.setInt(2, res.getID_CAHUFFEUR());
            preparedStatement.setInt(3, res.getID_ANNONCE());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reservationcov = new Reservationcov(resultSet.getInt("ID"), resultSet.getInt("ID_RESERVE"), resultSet.getInt("ID_CHAUFFEUR"), resultSet.getInt("ID_ANNONCE"),resultSet.getBoolean("ETAT"),resultSet.getInt("NBPLACES"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reservationcov;
    }
    @Override
public List<Reservationcov> findByChauffeurb(Integer r,Boolean b) {
         Reservationcov reservationcov = null;
        List<Reservationcov> reservationcovs = new ArrayList<>();
        String req = "select * from reservationcovoiturage where ID_CHAUFFEUR=? AND ETAT=?";
        
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.setBoolean(2, b);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reservationcov = new Reservationcov(resultSet.getInt("ID"), resultSet.getInt("ID_RESERVE"), resultSet.getInt("ID_CHAUFFEUR"), resultSet.getInt("ID_ANNONCE"),  resultSet.getBoolean("ETAT"),  resultSet.getInt("NBPLACES"));
                reservationcovs.add(reservationcov);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reservationcovs;
}

}