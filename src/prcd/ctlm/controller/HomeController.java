package prcd.ctlm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import prcd.ctlm.CTLMProject;

/*
 * @author Thomas Caspar and Thérésien Esberard
 */

public class HomeController {
    CTLMProject ctlm = new CTLMProject();
    
    @FXML
    private void addTask(ActionEvent e) throws IOException{
        ctlm.addTask(e);
    }
    
    @FXML
    private void viewTasks(ActionEvent e) throws IOException{
        ctlm.viewTasks(e);
    }
    
    public void finishTask(ActionEvent e) throws IOException{
        ctlm.finishTask(e);
    }
    
    public void takeTask(ActionEvent e) throws IOException{
        ctlm.takeTask(e);
    }
    
    public void attributeTask(ActionEvent e) throws IOException{
        ctlm.attributeTask(e);
    }
    
    public void deleteTask(ActionEvent e) throws IOException{
        ctlm.deleteTask(e);
    }
    
    public void logOut(ActionEvent e) throws IOException{
        ctlm.close(e);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
