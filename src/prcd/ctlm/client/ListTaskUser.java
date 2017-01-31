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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ThomasPCGAME
 */
public class ListTaskUser implements Runnable {

	private Socket socket = null;
        private PrintWriter out = null;
	private BufferedReader in = null;
        private String reponseServeur = "";
	private Scanner sc = null;
	private boolean connect = false;
        private String idT, idU, titre, description, dc, df, prio; 
        public List<String> listTache = new ArrayList<String>();
        
        public ListTaskUser (Socket socket_, String idU_)
        {
            socket = socket_;
            idU = idU_;
        }
        
        public void run() {
		
		try {
			
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
                
                //System.out.println(in.readLine());
		//user = sc.nextLine();
		out.println(idU);
		out.flush();
                
                while(!connect )
                {
                    String reponse = in.readLine() ;
                    boolean descriptionFind = false;
                    System.out.println(reponse);
                    if(!reponse.equals("fin"))
                    {
                        String[] reponseSplit = reponse.split(" ");
                        for(int i = 0; i < reponseSplit.length ; i ++)
                        {
                            if(reponseSplit[i].equals("Description"))
                            {
                                descriptionFind = true;
                            }
                            
                        }
                        if(descriptionFind == false)
                        {
                            reponseServeur += reponse ;
                            reponseServeur += "\n" ;
                        }
                        else
                        {
                            reponseServeur += reponse ;
                            reponseServeur += "\n" ;
                            listTache.add(reponseServeur);
                            reponseServeur = "";
                        }
                        
                        
                    }
                    else connect = true; 
                }
                 //System.out.println( "premier add : " + listTache.get(0));//debug
                
                } catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
		}
        }
}
