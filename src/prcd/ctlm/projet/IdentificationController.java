package prcd.ctlm.projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Thomas Caspar and Thérésien Esberard
 */
public class IdentificationController {
    
    private CTLMProject ctlm;
    
    @FXML
    private void connection(ActionEvent e) throws IOException{
        //ctlm.showHome();
        Stage stage; 
        BorderPane root;
     
        // get reference to the button's stage
        // rester sur la même page
        stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("Root.fxml"));
        root = loader.load();
      
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      
        // Load home.
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(CTLMProject.class.getResource("Home.fxml"));
        GridPane home = loader2.load();

        // Set home into the center of root layout.
        root.setCenter(home);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
