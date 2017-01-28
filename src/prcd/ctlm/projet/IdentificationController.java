package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/*
 * @author Thomas Caspar and Thérésien Esberard
 */

public class IdentificationController {

    private CTLMProject ctlm = new CTLMProject();
    private MultieClient client = new MultieClient() ;
    
    @FXML
    private TextField identifiantBox, mdpBox;
    
    @FXML
    private Label ConnexionOK = new Label();
    
    @FXML
    private void connection(ActionEvent e) throws IOException, InterruptedException{
        
        client.clientLog(identifiantBox.getText(), mdpBox.getText(), "n");
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
