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
public class IdentificationController {
    
    private CTLMProject ctlm;
    
    @FXML
    private void connection(ActionEvent e) throws IOException{
        //ctlm.showHome();
        Stage stage; 
        VBox home;
     
        // get reference to the button's stage to stay at the same page
        stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("Home.fxml"));
        home = loader.load();
        Scene scene = new Scene(home);
        stage.setScene(scene);
        stage.show();
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
