package prcd.ctlm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import prcd.ctlm.CTLMProject;
import prcd.ctlm.client.MultieClient;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */

public class TakeTaskController {
    CTLMProject ctlm = new CTLMProject();
    private MultieClient client = new MultieClient();
    
    @FXML
    private ListView listTache;
    
    @FXML
    private void goHome(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void finish(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void logOut(ActionEvent e) throws IOException{
        ctlm.logOut(e);
    }
    
    public void initialize() throws InterruptedException {
        client.clientList("0");
        Thread.sleep(500);
        listTache.setItems( FXCollections.observableArrayList(client.listTacheUser.listTache) );
    }    
    
}
