/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultieClient {

	public static Socket socket = null;
	public static Thread t1;
        public Connexion connect;
        public AddTaskClient addTache;
        public ListTaskUser listTacheUser;
        public String Utilisateur = null;
        public ListUserView listUserview;
        private PrintWriter out = null;
	private BufferedReader in = null;
	private Scanner sc = null;
	
	public void clientLog(String login, String pass, String user) throws InterruptedException {
	
		
	try {
		Utilisateur = login;
		System.out.println("Demande de connexion");
		socket = new Socket("127.0.0.1",2009);
		System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
                
                out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
                
                System.out.println(in.readLine());
		out.println("a");
                out.flush();
		
		t1 = new Thread(connect = new Connexion(socket, login, pass, user));
		t1.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
	}
	
	

	}
        
        public void clientIns(String login, String nom, String prenom, String mail, String pass, String user) {
	
		
	try {
		
		System.out.println("Demande de connexion");
		socket = new Socket("127.0.0.1",2009);
		System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
                
                out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
                
                System.out.println(in.readLine());
		out.println("i");
                out.flush();
		
		t1 = new Thread(connect = new Connexion(socket, login, nom, prenom, mail, pass , user));
		t1.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
	}
	
	

	}
        
        public void clientAddT(String idT, String idU, String titre, String description, String dc, String df, String prio) throws InterruptedException {
	
		
	try {
		
		System.out.println("Demande de connexion");
		socket = new Socket("127.0.0.1",2009);
		System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
                
                out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
                
                System.out.println(in.readLine());
		out.println("addT");
                out.flush();
		
		t1 = new Thread(addTache = new AddTaskClient(socket, idT, idU, titre, description, dc, df, prio));
		t1.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
	}
	
	

	}
        
        public void clientList(String idU) throws InterruptedException {
	
		
	try {
		
		System.out.println("Demande de connexion");
		socket = new Socket("127.0.0.1",2009);
		System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
                
                out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
                
                System.out.println(in.readLine());
		out.println("lisT");
                out.flush();
		
		t1 = new Thread(listTacheUser = new ListTaskUser(socket, idU));
		t1.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
	}
	
	

	}
        
        public void clientListUser() throws InterruptedException {
	
		
	try {
		
		System.out.println("Demande de connexion");
		socket = new Socket("127.0.0.1",2009);
		System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
                
                out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
                
              	System.out.println(in.readLine());
		out.println("lisU");
                out.flush();
                
		t1 = new Thread(listUserview = new ListUserView(socket));
		t1.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
	}
	
	

	}

}
