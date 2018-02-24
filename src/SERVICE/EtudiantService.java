/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DataSource.DataSource;
import ISERVICE.IEtudiantService;
import MODEL.Etudiant;
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
public class EtudiantService implements IEtudiantService {

    Connection connection;

    public EtudiantService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public boolean add(Etudiant t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Etudiant t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant findId(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> getAll() {
        Etudiant etudiant;
        List<Etudiant> etudiantList = new ArrayList<>();
        String req = "SELECT * FROM utilisateur where ROLE='Etudiant'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                etudiant = new Etudiant(resultSet.getString("Classe"), resultSet.getString("Email"), resultSet.getString("Username"), resultSet.getString("Password"), resultSet.getString("Nom"), resultSet.getString("Prenom"), resultSet.getString("Telephone"), resultSet.getString("Sexe"), resultSet.getDate("Date_Creation"), resultSet.getString("Role"));
                etudiantList.add(etudiant);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return etudiantList;
    }
}
