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
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author thoma
 */
public class MultieClient {
    public static void main(String[] args){
		
		Socket socket;
                BufferedReader in;
		PrintWriter out;
                
		try {
		socket = new Socket(InetAddress.getLocalHost(),2009);
                
                in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		String message_distant = in.readLine();
		System.out.println(message_distant);
                
		socket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
    
}
