/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.serveur;
import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Authentification implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login = null, pass =  null, user = null , nom = null, prenom = null , mail = null;
	public boolean authentifier = false;
	public Thread t2;
	
	public Authentification(Socket s){
		 socket = s;
		}
	public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
		while(!authentifier){
			
                        out.println("Créer un Compte y/n :");
			out.flush();
			user = in.readLine();
                        
                        if(user.equals("n"))
                        {
			out.println("Entrez votre login :");
			out.flush();
			login = in.readLine();
			
			
			out.println("Entrez votre mot de passe :");
			out.flush();
			pass = in.readLine();

			if(isValid(login, pass)){
				
				out.println("connecte");
				System.out.println(login +" vient de se connecter ");
				out.flush();
				authentifier = true;	
			}
			else {out.println("erreur"); out.flush();}
                        }
                        
                        else
                        {
                            out.println("Entrez un login de connextion:");
                            out.flush();
                            login = in.readLine();
                            
                            out.println("Entrez un mot de passe de connextion:");
                            out.flush();
                            pass = in.readLine();
                            
                            out.println("Entrez votre nom:");
                            out.flush();
                            nom = in.readLine();
                            
                            out.println("Entrez votre prenom:");
                            out.flush();
                            prenom = in.readLine();
                            
                            out.println("Entrez votre e-mail:");
                            out.flush();
                            mail = in.readLine();
                            
                            CreerUtilisateur utilisateur = new CreerUtilisateur();
                            utilisateur.NouveauUtilisateur(login, nom, prenom, mail, pass);
                            
                            if(isValid(login, pass)){
				
				out.println("connecte");
				System.out.println(login +" vient de se connecter ");
				out.flush();
				authentifier = true;	
                            }
                            else
                            {
                                out.println("nonconnecte");
				System.out.println(login +" vient de se connecter ");
				out.flush();
				authentifier = false;
                            }
                            
                        }
                        
		 }
			
		} catch (IOException e) {
			
			System.err.println(login+" ne répond pas !");
		}
	}
	
	private static boolean isValid(String login, String pass) {
		
		
		boolean connexion = false;
                System.out.println("login : " + login + " pass : "+pass);
                ReadXML user = new ReadXML();
                
                if(user.read(login, pass))connexion = true;
                else connexion = false;
            
                return connexion;
		
	}

}
