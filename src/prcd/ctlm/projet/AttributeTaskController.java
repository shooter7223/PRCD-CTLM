package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */

public class AttributeTaskController {
    CTLMProject ctlm = new CTLMProject();
    
    @FXML
    private void goHome(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void viewTasks(ActionEvent e) throws IOException{
        ctlm.viewTasks(e);
    }
    
    @FXML
    private void finish(ActionEvent e) throws IOException{
        ctlm.viewTasks(e);
    }
    
    @FXML
    private void attibuteTo() throws IOException{
        ctlm.showUsersList();
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
