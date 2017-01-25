/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.serveur;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thoma
 */
public class UtilisateurTab 
{
    private String id;
    private String nom;
    private String prenom;
    private String mail;
    private String motDePasse;
    
    public UtilisateurTab()
    {
        
    }
    
    public String getId()
    {
        return id;
    }
    public void setId(String id_)
    {
        this.id = id_;
    }
    public String getNom()
    {
        return nom;
    }
    public void setNom(String nom_)
    {
        this.nom = nom_;
    }
    public String getPrenom()
    {
        return prenom;
    }
    public void setPrenom(String prenom_)
    {
        this.prenom = prenom_;
    }
    public String getMail()
    {
        return mail;
    }
    public void setMail(String mail_)
    {
        this.mail = mail_;
    }
    public String getMotDePasse()
    {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse_)
    {
        this.motDePasse = motDePasse_;
    }
    
    
}
