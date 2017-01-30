package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */

public class UsersListController {
    CTLMProject ctlm = new CTLMProject();
    private Stage stage;
    private MultieClient client = new MultieClient();
    
    @FXML
    private ListView  listUser = new ListView();
    
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
    
    
    public void initialize() throws InterruptedException {
        // TODO
        client.clientListUser();
        Thread.sleep(500);
        listUser.setItems( FXCollections.observableArrayList(client.listUserview.listUser) );
        
        
        
    }    
    
}