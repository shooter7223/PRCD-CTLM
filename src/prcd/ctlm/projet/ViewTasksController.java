package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private void dummy(ActionEvent e) throws IOException{
        ctlm.dummy(e);
    }
    
    @FXML
    private void task(ActionEvent e) throws IOException{
        Stage stage; 
        VBox task;
     
        // get reference to the button's stage to stay at the same page
        stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("Task.fxml"));
        task = loader.load();
        Scene scene = new Scene(task);
        stage.setScene(scene);
        stage.show();
        
    }
    
  
    public void initialize() throws InterruptedException {
        // TODO
        System.out.println("initialisation");
        System.out.println("az");
        client.clientList("az");
        Thread.sleep(1000);
        listTask.setItems( FXCollections.observableArrayList(client.listTacheUser.listTache) );
    }    
    
}
