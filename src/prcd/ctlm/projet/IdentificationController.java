package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Thomas Caspar and Thérésien Esberard
 */
public class IdentificationController {
    CTLMProject ctlm = new CTLMProject();
    
    @FXML
    private void connection(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
