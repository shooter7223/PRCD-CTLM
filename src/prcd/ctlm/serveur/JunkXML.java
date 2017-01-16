/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.serveur;

/**
 *
 * @author thoma
 */
public class JunkXML {
    private String a;
    private String b;
    
    public JunkXML(){
       seta("");
       setb("");
    }
    
    public JunkXML(String a, String b)
    {
        seta("");
        setb("");
    }
    
    public void seta(String a_){this.a = a_;}
    public void setb(String b_){this.a = b_;}
    public String geta(){return a;}
    public String getb(){return b;}
    
}
