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
public class Professeur extends Utilisateur {

    private String Matiere;

    public Professeur(String Matiere, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Sexe, Date Date_Creation, String Role) {
        super(Email, username, Password, Nom, Prenom, Telephone, Sexe, Date_Creation, Role);
        this.Matiere = Matiere;
    }

    public Professeur(String Matiere, int ID, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Photo, String Sexe, String Role) {
        super(ID, Email, username, Password, Nom, Prenom, Telephone, Photo, Sexe, Role);
        this.Matiere = Matiere;
    }

    public String getMatiere() {
        return Matiere;
    }

    public void setMatiere(String Matiere) {
        this.Matiere = Matiere;
    }

}
