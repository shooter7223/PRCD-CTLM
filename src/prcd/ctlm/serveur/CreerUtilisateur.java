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
        FileWriter  xml = new FileWriter ("Utilisateurs.xml", true);
        xml.write("<utilisateur>\n");
        
        xml.write("<id>");
        xml.write(id);
        xml.write("</id>\n");
        
        xml.write("<nom>");
        xml.write(nom);
        xml.write("</nom>\n");
        
        xml.write("<prenom>");
        xml.write(prenom);
        xml.write("</prenom>\n");
        
        xml.write("<e-mail>");
        xml.write(mail);
        xml.write("</e-mail>\n");
        
        xml.write("<motDePasse>");
        xml.write(pass);
        xml.write("</motDePasse>\n");
        
        xml.write("</utilisateur>\n");
        
        xml.flush();
        xml.close();
    }
    
}
