package prcd.ctlm.controller;

import prcd.ctlm.client.MultieClient;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import prcd.ctlm.CTLMProject;
import prcd.ctlm.client.SaveUser;

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
        ctlm.goHome(e);
        
    }
    
    @FXML
    private void viewTasks(ActionEvent e) throws IOException{
        ctlm.viewTasks(e);
    }
    
    @FXML
    private void validate(ActionEvent e) throws IOException, InterruptedException{
        
        String idUe = (String) userlist.getSelectionModel().getSelectedItem();
        String [] userSplit = idUe.split("\n");
        String [] userId = userSplit[0].split(" ");
        idUe = userId[2];
        
        String tache = (String) listTache.getSelectionModel().getSelectedItem();
        String [] tacheSplit = tache.split("\n");
        List<String> editTache = new ArrayList<String>();
        
        for(int i = 0; i < tacheSplit.length; i++)
        {
            String [] tacheId = tacheSplit[i].split(":");
            editTache.add(tacheId[1]);
            
        }
       
        
        client.clientEditT(idUe, editTache.get(1), editTache.get(2), editTache.get(0), editTache.get(6), editTache.get(3), editTache.get(4), editTache.get(5));
        Thread.sleep(500);
        ctlm.viewTasks(e);
    }
    
    @FXML
    private void finish(ActionEvent e) throws IOException{
       
        ctlm.viewTasks(e);
    }
    
     @FXML
    public void logOut(ActionEvent e) throws IOException{
        ctlm.logOut(e);
    }
    
   
    
    public void initialize() throws InterruptedException {
        
        client.clientListUser();
        Thread.sleep(500);
        userlist.setItems( FXCollections.observableArrayList(client.listUserview.listUser) );
        client.clientList(SaveUser.user);
        Thread.sleep(500);
        listTache.setItems( FXCollections.observableArrayList(client.listTacheUser.listTache) );
        
    }    
    
}
