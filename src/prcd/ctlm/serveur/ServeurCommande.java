/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThomasPCGAME
 */
public class ServeurCommande implements Runnable {

	private Socket socket;
        private PrintWriter out = null;
	private BufferedReader in = null;
        private String cmd = null;
        public static Thread t;
        
        public ServeurCommande(Socket s){
		 socket = s;
        }
        
        public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
                        
                        while(true)
                        {
                            System.out.println("Thread Commande");
                            out.println("Entrer une commande :");
                            out.flush();
                            cmd = in.readLine();
                            System.out.println(cmd);
                            
                            if(cmd.equals("a"))
                            {
                                    System.out.println("comande a lancée");
                                    t = new Thread(new Authentification(socket));
                                    t.start();
                                    t.join();
                            }
                            if(cmd.equals("i"))
                            {
                                    System.out.println("comande i lancée");
                                    t = new Thread(new Authentification(socket));
                                    t.start();
                                    t.join();
                            }
                            if(cmd.equals("addT"))
                            {
                                    System.out.println("comande addT lancée");
                                    t = new Thread(new GestionTache(socket,"addT"));
                                    t.start();
                                    t.join();
                            }
                            if(cmd.equals("lisT"))
                            {
                                    System.out.println("comande lisT lancée");
                                    t = new Thread(new GestionTache(socket,"lisT"));
                                    t.start();
                                    t.join();
                            }
                            if(cmd.equals("lisU"))
                            {
                                    System.out.println("comande lisT lancée");
                                    t = new Thread(new GestionUser(socket));
                                    t.start();
                                    t.join();
                            }
                        }
                        
                        	
		} catch (IOException e) {
			
			System.err.println(" ne répond pas !");
		} catch (InterruptedException ex) {
                Logger.getLogger(ServeurCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
