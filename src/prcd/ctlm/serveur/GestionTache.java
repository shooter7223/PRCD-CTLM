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

/**
 *
 * @author ThomasPCGAME
 */
public class GestionTache implements Runnable {
    
    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private String idT = null, idU =  null, titre = null , p = null, d = null;
    public boolean gestionTache = false;
    
    public GestionTache(Socket s){
		 socket = s;
		}
    
    public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
		while(!gestionTache){
                    
                    out.println("idT :");
                    out.flush();
                    idT = in.readLine();
                    
                    out.println("idU :");
                    out.flush();
                    idU = in.readLine();
                    
                    out.println("titre :");
                    out.flush();
                    titre = in.readLine();
                    
                    out.println("p :");
                    out.flush();
                    p = in.readLine();
                    
                    out.println("d :");
                    out.flush();
                    d = in.readLine();
                    
                    CreerTaches creerTache = new CreerTaches();
                    creerTache.NouvelleTache(idT, idU, titre, d, p);
                    gestionTache = true;
                }
                
                } catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
		}
    }
    
}
