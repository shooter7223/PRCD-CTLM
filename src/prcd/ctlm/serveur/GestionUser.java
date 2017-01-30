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
 * @author thoma
 */
public class GestionUser implements Runnable {
    
    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    
     public GestionUser(Socket s){
		 socket = s;
                 
		}
     public void run()
     {
         try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
                        
                        System.out.println("Recuperation des tache");
                        
                        ReadXML user = new ReadXML();
                        user.read("0","0");
                        //Thread.sleep(500);
                        
                        for(int i = 0; i < user.listUser.size(); i++ )
                        {
                            out.println(user.listUser.get(i));
                            out.flush();
                        }
                        out.println("fin");
                        out.flush();
                        
          } catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
		}
     }
    
}
