package prcd.ctlm.projet;

import prcd.ctlm.projet.MultieClient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */

public class AttributeTaskController {
    CTLMProject ctlm = new CTLMProject();
    private MultieClient client = new MultieClient();
    
    @FXML
    private ComboBox userlist;
    
    @FXML
    private ListView listTache;
    
    @FXML
    private void goHome(ActionEvent e) throws IOException{
        String user = (String) userlist.getSelectionModel().getSelectedItem();
        String [] userSplit = user.split("\n");
        String [] userId = userSplit[0].split(" ");
        user = userId[2];
        
    }
    
    @FXML
    private void viewTasks(ActionEvent e) throws IOException{
        ctlm.viewTasks(e);
    }
    
    @FXML
    private void validate(ActionEvent e) throws IOException{
        ctlm.viewTasks(e);
    }
    
    @FXML
    private void finish(ActionEvent e) throws IOException{
        ctlm.viewTasks(e);
    }
    
   
    
    public void initialize() throws InterruptedException {
        
        client.clientListUser();
        Thread.sleep(500);
        userlist.setItems( FXCollections.observableArrayList(client.listUserview.listUser) );
        client.clientList("0");
        Thread.sleep(500);
        listTache.setItems( FXCollections.observableArrayList(client.listTacheUser.listTache) );
        
    }    
    
}
