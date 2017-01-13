/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.projet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author thoma
 */
public class MultieClient {
    public static void main(String[] args){
		
		Socket socket;
		try {
		socket = new Socket(InetAddress.getLocalHost(),2009);
		socket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
    
}
