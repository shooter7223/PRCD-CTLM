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

public class ReadXMLTaches {
    boolean idTest = false;
    boolean accept = false;
   
   public boolean read(String IdT_ , String IdU_) {
    System.out.println("id : " + IdT_ + "pass : " + IdU_);
    try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() {
	boolean Tache = false;
	
	public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {

		System.out.println("Start Element :" + qName);

		if (qName.equalsIgnoreCase("Tache")) {
			String idT = attributes.getValue("idT");
			String idU = attributes.getValue("idU");
                        String titre = attributes.getValue("titre");
                        String priorite = attributes.getValue("priorite");
		}
	}

	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		System.out.println("End Element :" + qName);

	}

	public void characters(char ch[], int start, int length) throws SAXException {
               
		if (Tache) {
			System.out.println(" " + new String (ch, start, length));
			Tache = false;
		}

	}

     };

       saxParser.parse("Taches.xml", handler);

     } catch (Exception e) {
       e.printStackTrace();
     }
    
    return accept;

   }

}