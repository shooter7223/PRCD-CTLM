/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import static prcd.ctlm.client.Connexion.mail;
import static prcd.ctlm.client.Connexion.nom;
import static prcd.ctlm.client.Connexion.prenom;

/**
 *
 * @author ThomasPCGAME
 */
public class AddTaskClient implements Runnable {

	private Socket socket = null;
        private String idT = null, idU = null, titre = null, p = null , d = null, dc = null, df = null;
        private PrintWriter out = null;
	private BufferedReader in = null;
        private boolean connect = false;
        
        public AddTaskClient(Socket s, String idT_, String idU_, String titre_, String d_ ,String dc_, String df_, String p_){
		
		socket = s;
                idT = idT_;
                idU = idU_;
                titre = titre_;
                dc = dc_;
                df = df_;
                p = p_;
                d = d_;
                
	}
        
        
        public void run() {
		
		try {
			
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));		
		
		while(!connect ){
		
		System.out.println(in.readLine());
		//user = sc.nextLine();
		out.println(idT);
		out.flush();
                
                System.out.println(in.readLine());
		//user = sc.nextLine();
		out.println(idU);
		out.flush();
                
                System.out.println(in.readLine());
		//user = sc.nextLine();
		out.println(titre);
		out.flush();
                
                System.out.println(in.readLine());
		//user = sc.nextLine();
		out.println(p);
		out.flush();
                
                System.out.println(in.readLine());
		//user = sc.nextLine();
		out.println(dc);
		out.flush();
                
                System.out.println(in.readLine());
		//user = sc.nextLine();
		out.println(df);
		out.flush();
                
                 System.out.println(in.readLine());
		//user = sc.nextLine();
		out.println(d);
		out.flush();
                
                connect = true;
                
                }
			
		
		} catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
		}
                System.out.println("Sortie du thread "); 
	}
    
}
