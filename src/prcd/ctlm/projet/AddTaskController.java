package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */

public class AddTaskController {
    CTLMProject ctlm = new CTLMProject();
    private MultieClient client = new MultieClient() ;
    
    @FXML
    private TextArea titreBox, descriptionBox;
    
    @FXML
    private void goHome(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void create(ActionEvent e) throws IOException, InterruptedException{
        client.clientAddT("2", "toto", titreBox.getText(), descriptionBox.getText(), "2");
        Thread.sleep(500);
        ctlm.viewTasks(e);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
