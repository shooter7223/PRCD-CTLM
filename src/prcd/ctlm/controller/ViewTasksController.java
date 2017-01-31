package prcd.ctlm.controller;

import prcd.ctlm.client.MultieClient;
import prcd.ctlm.client.SaveUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import prcd.ctlm.CTLMProject;

/*
 * @author Thomas Caspar and Thérésien Esberard
 */

public class ViewTasksController {
    CTLMProject ctlm = new CTLMProject(); 
    private MultieClient client = new MultieClient();
   
    @FXML
    private ListView listTask = new ListView();
    
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
    
  
    public void initialize() throws InterruptedException {
        // TODO
        System.out.println("initialisation");
        System.out.println(SaveUser.user);
        client.clientList(SaveUser.user);
        Thread.sleep(1000);
        listTask.setItems( FXCollections.observableArrayList(client.listTacheUser.listTache) );
    }    
    
}
