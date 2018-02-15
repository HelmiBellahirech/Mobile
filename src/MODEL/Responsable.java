/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Date;

/**
 *
 * @author OrbitG
 */
public class Responsable extends Utilisateur {

    private String Nom_Club;
    private String Photo_Club;

    public Responsable(String Nom_Club, String Photo_Club, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Sexe, Date Date_Creation, String Role) {
        super(Email, username, Password, Nom, Prenom, Telephone, Sexe, Date_Creation, Role);
        this.Nom_Club = Nom_Club;
        this.Photo_Club = Photo_Club;
    }

    public Responsable(String Nom_Club, String Photo_Club, int ID, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Photo, String Sexe, String Role) {
        super(ID, Email, username, Password, Nom, Prenom, Telephone, Photo, Sexe, Role);
        this.Nom_Club = Nom_Club;
        this.Photo_Club = Photo_Club;
    }

}
