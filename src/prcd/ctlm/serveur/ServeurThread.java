/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.serveur;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;
import java.net.*;


public class ServeurThread implements Runnable{

	private ServerSocket socketserver = null;
	private Socket socket = null;

	public Thread t1;
	public ServeurThread(ServerSocket ss){
	 socketserver = ss;
	}
	
	public void run() {
		
		try {
			while(true){
				
			socket = socketserver.accept();
			System.out.println("Un zéro veut se connecter  ");
			
			t1 = new Thread(new Authentification(socket));
			t1.start();
			
			}
		} catch (IOException e) {
			
			System.err.println("Erreur serveur");
		}
		
	}
}
