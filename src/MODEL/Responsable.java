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

    public String getNom_Club() {
        return Nom_Club;
    }

    public void setNom_Club(String Nom_Club) {
        this.Nom_Club = Nom_Club;
    }

    public String getPhoto_Club() {
        return Photo_Club;
    }

    public void setPhoto_Club(String Photo_Club) {
        this.Photo_Club = Photo_Club;
    }

    public Responsable(String Nom_Club, String Photo_Club, int ID, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Photo, String Sexe, String Matricule, String Role) {
        super(ID, Email, username, Password, Nom, Prenom, Telephone, Photo, Sexe, Matricule, Role);
        this.Nom_Club = Nom_Club;
        this.Photo_Club = Photo_Club;
    }

    public Responsable(String Nom_Club, String Photo_Club, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Sexe,  String Matricule) {
        super(Email, username, Password, Nom, Prenom, Telephone, Sexe,  Matricule);
        this.Nom_Club = Nom_Club;
        this.Photo_Club = Photo_Club;
    }

    public Responsable(String Nom_Club, String Photo_Club, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Photo, String Sexe, String Matricule) {
        super(Email, username, Password, Nom, Prenom, Telephone, Photo, Sexe, Matricule);
        this.Nom_Club = Nom_Club;
        this.Photo_Club = Photo_Club;
    }

    public Responsable(String Nom_Club, String Photo_Club) {
        this.Nom_Club = Nom_Club;
        this.Photo_Club = Photo_Club;
    }

   
}
