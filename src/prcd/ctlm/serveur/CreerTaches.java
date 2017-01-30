/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.serveur;

import java.io.*;
import java.beans.*;
import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class CreerTaches {
    
    public void NouvelleTache(String idT, String idU, String titre, String description, String dateC, String dateF, String prio) throws IOException
    {        
        BufferedReader br = new BufferedReader(new FileReader("Taches.xml"));
        String line;
        ArrayList<String> xml_save = new ArrayList<String>();
        boolean doc_vide = true;
        
        while ((line = br.readLine()) != null) {
                doc_vide = false;
                System.out.println(line);
                xml_save.add(line);
               
        }
        
        FileWriter  xml = new FileWriter ("Taches.xml");
        
        
        
        if(doc_vide)
        {
            xml.write("<root>\n");
        
        }else xml.write(xml_save.get(0)+"\n\n");
       
        
        
        xml.write("<Tache etat=\"" + idT + "\" idU=\"" + idU + "\" titre=\"" + titre +"\" dateC=\""+ dateC+"\" dateF=\""+ dateF + "\"  priorite=\"" + prio + "\" >" );
         xml.write(description); 
        xml.write("</Tache>"); 
        
        if(doc_vide == false)
        {
            for(int j = 1;j < xml_save.size();j++)
            {
                xml.write(xml_save.get(j));
            }
        
        }
        else xml.write("</root>\n");
        
        xml.flush();
        xml.close();
    }
    
}
