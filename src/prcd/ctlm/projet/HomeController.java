package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Thomas Caspar and Thérésien Esberard
 */
public class HomeController {
        
    @FXML
    private void viewTasks(ActionEvent e) throws IOException{
        //ctlm.showHome();
        Stage stage; 
        VBox viewTasks;
     
        // get reference to the button's stage to stay at the same page
        stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("ViewTasks.fxml"));
        viewTasks = loader.load();
        Scene scene = new Scene(viewTasks);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void addTask(ActionEvent e) throws IOException{
        //ctlm.showHome();
        Stage stage; 
        GridPane addTask;
     
        // get reference to the button's stage to stay at the same page
        stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("AddTask.fxml"));
        addTask = loader.load();
        Scene scene = new Scene(addTask);
        stage.setScene(scene);
        stage.show();
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
