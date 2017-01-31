package prcd.ctlm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import prcd.ctlm.CTLMProject;
import prcd.ctlm.client.MultieClient;
import prcd.ctlm.client.SaveUser;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */

public class DeleteTaskController {
    CTLMProject ctlm = new CTLMProject();
    private MultieClient client = new MultieClient();
    
    @FXML
    private ListView listTache;
    
    
    @FXML
    private void goHome(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void finish(ActionEvent e) throws IOException, InterruptedException{
        String tache = (String) listTache.getSelectionModel().getSelectedItem();
        String [] tacheSplit = tache.split("\n");
        List<String> editTache = new ArrayList<String>();
        
        for(int i = 0; i < tacheSplit.length; i++)
        {
            String [] tacheId = tacheSplit[i].split(":");
            editTache.add(tacheId[1]);
            
        }
       
        
        client.clientEditSup(editTache.get(5), editTache.get(2), editTache.get(0), editTache.get(6), editTache.get(3), editTache.get(4), editTache.get(1));
        Thread.sleep(500);
        //ctlm.viewTasks(e);
        ctlm.goHome(e);
    }
    
    @FXML
    private void logOut(ActionEvent e) throws IOException{
        ctlm.logOut(e);
    }
    
    public void initialize() throws InterruptedException {
        client.clientList(SaveUser.user);
        Thread.sleep(500);
        listTache.setItems( FXCollections.observableArrayList(client.listTacheUser.listTache) );
        
    }    
    
}
