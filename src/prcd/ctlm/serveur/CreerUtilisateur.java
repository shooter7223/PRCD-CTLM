/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.serveur;

import java.io.*;
import java.beans.*;

/**
 *
 * @author thoma
 */
public class CreerUtilisateur {
    
    public void NouveauUtilisateur(String id, String nom, String prenom, String mail, String pass) throws IOException
    {
        JunkXML user1 = new JunkXML("id", id);
        JunkXML user2 = new JunkXML("nom", nom);
        JunkXML user3 = new JunkXML("prenom", prenom);
        JunkXML user4 = new JunkXML("e-mail", mail);
        JunkXML user5 = new JunkXML("motDePasse", pass);
        
        FileOutputStream xml = new FileOutputStream("Utilisateurs.xml");
        XMLEncoder encoder = new XMLEncoder(xml);
        encoder.writeObject(user1);
        encoder.writeObject(user2);
        encoder.writeObject(user3);
        encoder.writeObject(user4);
        encoder.writeObject(user5);
    }
    
}
