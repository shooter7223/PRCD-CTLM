/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.projet;

import java.io.*;
import java.net.*;

public class MultieClient {

	public static Socket socket = null;
	public static Thread t1;
        public Connexion connect;
	
	public void clientLog(String login, String pass, String user) {
	
		
	try {
		
		System.out.println("Demande de connexion");
		socket = new Socket("127.0.0.1",2009);
		System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
		
		t1 = new Thread(connect = new Connexion(socket, login, pass, user));
		t1.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
	}
	
	

	}

}
