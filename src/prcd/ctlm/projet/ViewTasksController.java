package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Thomas Caspar and Thérésien Esberard
 */
public class ViewTasksController {
        
    @FXML
    private void dummy(ActionEvent e) throws IOException{
        //ctlm.showHome();
        Stage stage; 
        VBox dummy;
     
        // get reference to the button's stage to stay at the same page
        stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("Dummy.fxml"));
        dummy = loader.load();
        Scene scene = new Scene(dummy);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void task(ActionEvent e) throws IOException{
        //ctlm.showHome();
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
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
