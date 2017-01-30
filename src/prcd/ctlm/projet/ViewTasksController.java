package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/*
 * @author Thomas Caspar and Thérésien Esberard
 */

public class ViewTasksController {
    CTLMProject ctlm = new CTLMProject();
    
    @FXML
    private void goHome(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void logOut(ActionEvent e) throws IOException{
        ctlm.logOut(e);
    }
    
    @FXML
    private void finish(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void delete(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void attributeTo(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
