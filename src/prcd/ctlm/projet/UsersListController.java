package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */

public class UsersListController {
    CTLMProject ctlm = new CTLMProject();
    private Stage stage;
    
    public void setDialogStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    private void close() throws IOException{
        stage.close();
    }
    
    @FXML
    private void validate(ActionEvent e) throws IOException{
        ctlm.viewTasks(e);
    }
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}