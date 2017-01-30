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
import static prcd.ctlm.client.Connexion.prenom;

/**
 *
 * @author ThomasPCGAME
 */
public class GestionTache implements Runnable {
    
    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private String idT = null, idU =  null, titre = null , p = null, d = null, dc = null, df = null, user = null, idUe = null, idTe = null;
    public boolean gestionTache = false;
    
    public GestionTache(Socket s, String user_){
		 socket = s;
                 user = user_;
		}
    
    public void run() {
	
		try {
			System.out.println("user : " + user);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
		
                    if(user.equals("addT")) 
                    {
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
                    
                        out.println("dateC :");
                        out.flush();
                        dc = in.readLine();
                    
                        out.println("dateF :");
                        out.flush();
                        df = in.readLine();
                    
                        out.println("d :");
                        out.flush();
                        d = in.readLine();
                    
                        CreerTaches creerTache = new CreerTaches();
                         creerTache.NouvelleTache(idT, idU, titre, d, dc, df, p);
                         gestionTache = true;
                    }
                    }
                    if(user.equals("lisT")) 
                    {
                        System.out.println("Recuperation des tache");
                        idU = in.readLine();
                        ReadXMLTaches tache = new ReadXMLTaches();
                        tache.read(idU);
                        //Thread.sleep(500);
                        
                        for(int i = 0; i < tache.listTache.size(); i++ )
                        {
                            out.println(tache.listTache.get(i));
                            out.flush();
                        }
                        out.println("fin");
                        out.flush();
                    }
                    
                    if(user.equals("editT")) 
                    {
                        while(!gestionTache){
                            
                        out.println("idUe :");
                        out.flush();
                        idUe = in.readLine();
                    
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
                    
                        out.println("dateC :");
                        out.flush();
                        dc = in.readLine();
                    
                        out.println("dateF :");
                        out.flush();
                        df = in.readLine();
                    
                        out.println("d :");
                        out.flush();
                        d = in.readLine();
                    
                        CreerTaches creerTache = new CreerTaches();
                        creerTache.EditTache(idUe, idT, idU, titre, d, dc, df, p);
                        gestionTache = true;
                    }
                    }
                     if(user.equals("editTE")) 
                    {
                        while(!gestionTache){
                            
                        out.println("idUe :");
                        out.flush();
                        idTe = in.readLine();
                    
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
                    
                        out.println("dateC :");
                        out.flush();
                        dc = in.readLine();
                    
                        out.println("dateF :");
                        out.flush();
                        df = in.readLine();
                    
                        out.println("d :");
                        out.flush();
                        d = in.readLine();
                    
                        CreerTaches creerTache = new CreerTaches();
                        creerTache.EditTacheEtat(idTe, idT, idU, titre, d, dc, df, p);
                        gestionTache = true;
                    }
                    }
                     if(user.equals("supT")) 
                    {
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
                    
                        out.println("dateC :");
                        out.flush();
                        dc = in.readLine();
                    
                        out.println("dateF :");
                        out.flush();
                        df = in.readLine();
                    
                        out.println("d :");
                        out.flush();
                        d = in.readLine();
                    
                        CreerTaches creerTache = new CreerTaches();
                        creerTache.EditTacheEtat(idTe, idT, idU, titre, d, dc, df, p);
                        gestionTache = true;
                    }
                    }
                
                
                } catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
		}
    }
    
}
