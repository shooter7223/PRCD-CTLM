package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/*
 * @author Thomas Caspar and Thérésien Esberard
 */

public class IdentificationController {

    private CTLMProject ctlm = new CTLMProject();
    private MultieClient client = new MultieClient();
    
    @FXML
    private TextField identifiantBox, mdpBox;
    
    @FXML
    private void connection(ActionEvent e) throws IOException{
        
        //client.clientLog(identifiantBox.getText(), mdpBox.getText(), "n");
        ctlm.goHome(e);

    }
        
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
