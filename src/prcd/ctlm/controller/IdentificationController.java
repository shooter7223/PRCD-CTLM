package prcd.ctlm.controller;

import prcd.ctlm.client.MultieClient;
import prcd.ctlm.client.SaveUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import prcd.ctlm.CTLMProject;

/*
 * @author Thomas Caspar and Thérésien Esberard
 */

public class IdentificationController {

    private CTLMProject ctlm = new CTLMProject();
    private MultieClient client = new MultieClient() ;
    
    @FXML
    private TextField identifiantBox, iid, inom, iprenom, imail;
    
    @FXML
    private PasswordField mdpBox, imdp;
    
    @FXML
    private Label ConnexionOK = new Label();
    
    @FXML
    private void connexion(ActionEvent e) throws IOException, InterruptedException{
       
        client.clientLog((SaveUser.user = identifiantBox.getText()), mdpBox.getText(), "n");;
        Thread.sleep(500);
        //System.out.println(client.connect.connect);
        if(client.connect.connectServer)ctlm.goHome(e);
        else 
        {
            ConnexionOK.setText("Identifiant ou mot de passe Incorrecte");
        }

    }
    
    @FXML
    private void inscription(ActionEvent e) throws IOException, InterruptedException{
        
        client.clientIns((SaveUser.user = iid.getText()), inom.getText(), iprenom.getText(), imail.getText(), imdp.getText(),  "y");
        Thread.sleep(500);
        //System.out.println(client.connect.connect);
        if(client.connect.connectServer)ctlm.goHome(e);
        else 
        {
            ConnexionOK.setText("Identifiant ou mot de passe Incorrecte");
        }

    }
        
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
