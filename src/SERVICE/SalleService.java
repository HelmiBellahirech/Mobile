/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DataSource.DataSource;
import ISERVICE.ISalleService;
import MODEL.Salle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nadaghanem
 */
public class SalleService implements ISalleService {

    Connection connection;

    public SalleService() {
        connection = DataSource.getInstance().getConnection();
    }

    public boolean add(Salle s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(Salle s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean remove(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Salle findId(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Salle> getAll() {
        Salle salle;
        List<Salle> salleList = new ArrayList<>();
        String req = "SELECT * FROM salle";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                salle = new Salle(resultSet.getInt("num_salle"), resultSet.getInt("num_bloc"), resultSet.getInt("nbr_chaise"), resultSet.getInt("nbr_table"));
                salleList.add(salle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return salleList;
    }
}
