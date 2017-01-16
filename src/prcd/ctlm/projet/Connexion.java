/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.projet;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Connexion implements Runnable {

	private Socket socket = null;
	public static Thread t2;
	public static String login = null, pass = null, message1 = null, message2 = null, message3 = null, user = null, nom = null, prenom = null, mail = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private Scanner sc = null;
	private boolean connect = false;
	
	public Connexion(Socket s){
		
		socket = s;
	}
	
	public void run() {
		
		try {
			
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
	
		
		while(!connect ){
		
		System.out.println(in.readLine());
		user = sc.nextLine();
		out.println(user);
		out.flush();
		
                if(user.equals("n"))
                {
                    System.out.println(in.readLine());
                    login = sc.nextLine();
                    out.println(login);
                    out.flush();
                    
                    System.out.println(in.readLine());
                    pass = sc.nextLine();
                    out.println(pass);
                    out.flush();
                }
                else 
                {
                    System.out.println(in.readLine());
                    login = sc.nextLine();
                    out.println(login);
                    out.flush();
                    
                    System.out.println(in.readLine());
                    pass = sc.nextLine();
                    out.println(pass);
                    out.flush();
                    
                    System.out.println(in.readLine());
                    nom = sc.nextLine();
                    out.println(nom);
                    out.flush();
                    
                    System.out.println(in.readLine());
                    prenom = sc.nextLine();
                    out.println(prenom);
                    out.flush();
                    
                    System.out.println(in.readLine());
                    mail = sc.nextLine();
                    out.println(mail);
                    out.flush();
                    
                }
		/*System.out.println(in.readLine());
		pass = sc.nextLine();
		out.println(pass);
		out.flush();*/
		
		if(in.readLine().equals("connecte")){
			
		System.out.println("Je suis connecté "); 
		connect = true;
		  }
		
		else {
			System.err.println("Vos informations sont incorrectes "); 
		  }
		
	}
			
		
		} catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
		}
	}

}

