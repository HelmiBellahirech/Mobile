/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DataSource.DataSource;
import ISERVICE.IProfService;
import MODEL.Cours;
import MODEL.Professeur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nadaghanem
 */
public class ProfService implements IProfService {

    Connection connection;

    public ProfService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public boolean add(Professeur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Professeur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professeur findId(Integer r) {
        Professeur prof = null;
        String req = "SELECT * from Utilisateur WHERE ID=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            prof = new Professeur("", resultSet.getInt("ID"), resultSet.getString("Email"),
                    resultSet.getString("username"), resultSet.getString("Password"), resultSet.getString("Nom"),
                    resultSet.getString("Prenom"), resultSet.getString("Telephone"), resultSet.getString("Sexe"),
                    resultSet.getString("Date_Creation"), resultSet.getString("Role"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return prof;
    }

    @Override
    public List<Professeur> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
