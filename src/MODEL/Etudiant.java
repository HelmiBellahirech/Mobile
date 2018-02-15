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
public class Etudiant extends Utilisateur {

    private String Classe;

    public Etudiant(String Classe, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Sexe, Date Date_Creation, String Role) {
        super(Email, username, Password, Nom, Prenom, Telephone, Sexe, Date_Creation, Role);
        this.Classe = Classe;
    }

    public Etudiant(String Classe, int ID, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Photo, String Sexe, String Role) {
        super(ID, Email, username, Password, Nom, Prenom, Telephone, Photo, Sexe, Role);
        this.Classe = Classe;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String Classe) {
        this.Classe = Classe;
    }

}
