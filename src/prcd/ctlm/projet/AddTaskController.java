package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */

public class AddTaskController {
    CTLMProject ctlm = new CTLMProject();
    private MultieClient client = new MultieClient() ;
    
    @FXML
    private TextArea descriptionBox;
    
    @FXML
    private ComboBox userlist;
    
    @FXML
    private TextField titreBox, dC, dF;
    
    @FXML
    private void goHome(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void create(ActionEvent e) throws IOException, InterruptedException{
        client.clientAddT("idTachen1","idu2", titreBox.getText(), descriptionBox.getText(),dC.getText(),dF.getText(),"p1" );;
        Thread.sleep(500);
        ctlm.viewTasks(e);
    }
    
    @FXML
    private void attributeTo() throws IOException{
        ctlm.showUsersList();
    }
    
    public void initialize() throws InterruptedException {
        // TODO
        client.clientListUser();
        Thread.sleep(500);
        userlist.setItems( FXCollections.observableArrayList(client.listUserview.listUser) );
    }    
    
}
