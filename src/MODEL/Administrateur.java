/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.Objects;

/**
 *
 * @author OrbitG
 */
public class Administrateur extends Utilisateur {

    public Administrateur() {
    }

    public Administrateur(int ID, String Email, String username, String Password, String Nom, String Prenom, String Telephone, String Photo, String Sexe, String Role) {
        super(ID, Email, username, Password, Nom, Prenom, Telephone, Photo, Sexe, Role);
    }
    

    

    
}
