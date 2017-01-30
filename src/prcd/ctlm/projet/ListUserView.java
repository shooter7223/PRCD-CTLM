/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author thoma
 */
public class ListUserView implements Runnable {

	private Socket socket = null;
        private PrintWriter out = null;
	private BufferedReader in = null;
	private Scanner sc = null;
        private String user;
        private String reponseServeur = null;
        public List<String> listUser = new ArrayList<String>();
	private boolean connect = false;
        
        public ListUserView(Socket s)
        {
            socket = s;
            
        }
        
        public void run()
        {
            try {
			
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
                
                while(!connect )
                {
                    String reponse = in.readLine() ;
                    boolean Email = false;
                    System.out.println(reponse);
                    
                    if(!reponse.equals("fin"))
                    {
                        String[] reponseSplit = reponse.split(" ");
                        for(int i = 0; i < reponseSplit.length ; i ++)
                        {
                            if(reponseSplit[i].equals("E-mail"))
                            {
                                Email = true;
                            }
                            
                        }
                        if(Email == false)
                        {
                            reponseServeur += reponse ;
                            reponseServeur += "\n" ;
                        }
                        else
                        {
                            reponseServeur += reponse ;
                            reponseServeur += "\n" ;
                            listUser.add(reponseServeur);
                            reponseServeur = "";
                        }
                        
                        
                    }
                    else connect = true;
                }
                
                } catch (IOException e) 
                {
			
			System.err.println("Le serveur ne répond plus ");
		}
                System.out.println("Sortie du thread "); 
        }
}
