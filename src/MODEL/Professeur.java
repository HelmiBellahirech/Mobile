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

    private String Specialite;

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String Specialite) {
        this.Specialite = Specialite;
    }

    public Professeur(String Specialite, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Photo, String Sexe, String Matricule) {
        super(Email, username, Password, Nom, Prenom, Telephone, Photo, Sexe, Matricule);
        this.Specialite = Specialite;
    }

    public Professeur(String Specialite, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Sexe, String Matricule) {
        super(Email, username, Password, Nom, Prenom, Telephone, Sexe,  Matricule);
        this.Specialite = Specialite;
    }

    public Professeur(String Specialite, int ID, String Email, String username, String Password,
            String Nom, String Prenom, String Telephone, String Photo, String Sexe, String Matricule, String Role) {
        super(ID, Email, username, Password, Nom, Prenom, Telephone, Photo, Sexe, Matricule, Role);
        this.Specialite = Specialite;
    }

    
    
    

    public Professeur(String Specialite) {
        this.Specialite = Specialite;
    }

  
}
