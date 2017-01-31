package prcd.ctlm.controller;

import prcd.ctlm.client.MultieClient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import prcd.ctlm.CTLMProject;


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
    private ToggleGroup etat, prio;
    
    @FXML
    private RadioButton e1,e2,e3,p1,p2,p3;
            
    @FXML
    private void goHome(ActionEvent e) throws IOException{
        ctlm.goHome(e);
    }
    
    @FXML
    private void create(ActionEvent e) throws IOException, InterruptedException{
        String user = (String) userlist.getSelectionModel().getSelectedItem();
        String [] userSplit = user.split("\n");
        String [] userId = userSplit[0].split(" ");
        user = userId[2];
        
        String Etat = null;
        String Prio = null;
        
        if(e1.isSelected() == true)
        {
            Etat = "faible";
        }
        if(e2.isSelected() == true)
        {
            Etat = "Moyenne";
        }
        if(e3.isSelected() == true)
        {
            Etat = "Elevee";
        }
        
        if(p1.isSelected() == true)
        {
            Prio = "A faire";
        }
        if(p2.isSelected() == true)
        {
            Prio = "En cours";
        }
        if(p3.isSelected() == true)
        {
            Prio = "Fini";
        }
        
        client.clientAddT( Etat,user, titreBox.getText(), descriptionBox.getText(),dC.getText(),dF.getText(),Prio );
        Thread.sleep(500);
        ctlm.viewTasks(e);
    }
    
    @FXML
    private void attributeTo() throws IOException{
        ctlm.showUsersList();
    }
    @FXML
    public void logOut(ActionEvent e) throws IOException{
        ctlm.logOut(e);
    }
    
    public void initialize() throws InterruptedException {
        // TODO
        client.clientListUser();
        Thread.sleep(500);
        userlist.setItems( FXCollections.observableArrayList(client.listUserview.listUser) );
    }    
    
}
