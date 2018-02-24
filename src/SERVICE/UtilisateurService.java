/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DataSource.DataSource;
import ISERVICE.IutilisateurService;
import MODEL.Utilisateur;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OrbitG
 */
public class UtilisateurService implements IutilisateurService {

    private Connection connection;
    private PreparedStatement ps;
    private PreparedStatement ps1;

    public UtilisateurService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public boolean add(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findId(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int login(String Email, String mdp) {
        String req = "select * from utilisateur where Email =? ";
        Utilisateur u = new Utilisateur();
        UtilisateurService userService = new UtilisateurService();
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, Email);

            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.last())//utilisateur existe
            {
                if (rs.getString("Password").equals(mdp)) {
                    //u = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16));
                    u.setID(rs.getInt("ID"));
                    u.setEmail(rs.getString("Email"));
                    u.setUsername(rs.getString("Username"));
                    u.setPassword(rs.getString("password"));
                    u.setNom(rs.getString("Nom"));
                    u.setPrenom(rs.getString("Prenom"));
                    u.setTelephone(rs.getString("Telephone"));
                    u.setPhoto(rs.getString("Photo"));
                    u.setSexe(rs.getString("Sexe"));
                    u.setDate_Creation(rs.getDate("Date_Creation"));
                    u.setRole(rs.getString("Role"));

                    System.out.println(rs.getString(11));
                    if (userService.getById(rs.getInt(1)).getRole().equals("Admin")) {
                        esprit_entraide.Esprit_Entraide.getInstance().setLoggedAdmin(u);
                        return 3;//email et mdp vrais administrateur
                    } else if (userService.getById(rs.getInt(1)).getRole().equals("Etudiant") || userService.getById(rs.getInt(1)).getRole().equals("Professeur")) {
                        esprit_entraide.Esprit_Entraide.getInstance().setLoggedUser(u);
                        System.out.println(u);
                        return 0;//email et mdp vrais Etudiant
                    } else {
                        esprit_entraide.Esprit_Entraide.getInstance().setLoggedUser(u);
                        System.out.println(u);
                        return 4; //email et mdp vrais Responsable des club
                    }
                } else {
                    return 1;//mdp incorrect
                }
            } else {
                return 2;//utilisateur n'existe pas 
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 3;

        }
    }

    @Override
    public Utilisateur getById(Integer id) {
        String req = "select * from utilisateur where id =?";
        Utilisateur u = null;
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                u.setRole(rs.getString("Role"));
                u.setID(rs.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

}
