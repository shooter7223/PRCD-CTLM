/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author thoma
 */
public class Serveur {
     static final int PORT = 1978;

    public static void main(String[] args){
		
		ServerSocket socket;
		try {
		socket = new ServerSocket(2009);
                System.out.println("Serveur créé ");
		Thread t = new Thread(new ServeurThread(socket));
		t.start();
		System.out.println("Mes employeurs sont prêts !");
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
    
}
