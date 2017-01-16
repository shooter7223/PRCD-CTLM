/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.serveur;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXML {
    boolean idTest = false;
    boolean accept = false;
   
   public boolean read(String Id_ , String pass_) {
    System.out.println("id : " + Id_ + "pass : " + pass_);
    try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() {

	boolean utilisateur = false;
	boolean id = false;
	boolean nom = false;
	boolean prenom = false;
        boolean mail = false;
        boolean motDePasse = false;

	public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {

		System.out.println("Start Element :" + qName);

		if (qName.equalsIgnoreCase("utilisateurs")) {
			utilisateur = true;
		}

		if (qName.equalsIgnoreCase("id")) {
			id = true;
		}

		if (qName.equalsIgnoreCase("nom")) {
			nom = true;
		}

		if (qName.equalsIgnoreCase("prenom")) {
			prenom = true;
		}
                if (qName.equalsIgnoreCase("e-mail")) {
			mail = true;
		}
                if (qName.equalsIgnoreCase("motDePasse")) {
			motDePasse = true;
		}
               

	}

	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		System.out.println("End Element :" + qName);

	}

	public void characters(char ch[], int start, int length) throws SAXException {
               
		if (utilisateur) {
			System.out.println(" " + new String (ch, start, length));
			utilisateur = false;
		}

		if (id) {
                        String Id = new String (ch, start, length);
			System.out.println("id : " + Id);
                        
                        if(Id.equals(Id_)){
                            System.out.println("ID TROUVER " + Id);
                            idTest = true;
                        }
                        
			id = false;
		}

		if (nom) {
			System.out.println("nom : " + new String(ch, start, length));
			nom = false;
		}

		if (prenom) {
			System.out.println("prenom : " + new String(ch, start, length));
			prenom = false;
		}
                if (mail) {
			System.out.println("mail : " + new String(ch, start, length));
			mail = false;
		}
                if (motDePasse) {
                        String Mot = new String(ch, start, length);
			System.out.println("motDePasse : " + Mot);
                        if(Mot.equals(pass_) && idTest == true)
                        {
                            accept = true;
                            idTest = false;
                        }
			motDePasse = false;
		}

	}

     };

       saxParser.parse("Utilisateurs.xml", handler);

     } catch (Exception e) {
       e.printStackTrace();
     }
    
    return accept;

   }

}