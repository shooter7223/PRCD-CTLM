/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.projet;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Thomas Caspar and Thérésien Esberard
 */
public class CTLMProject extends Application {
    private BorderPane root;

    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Root.fxml"));

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        showIdentification();
    }
    /**
     * Shows the home inside the root.
     */
    public void showHome() {
        try {
            // Load home.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CTLMProject.class.getResource("Identification.fxml"));
            GridPane home = (GridPane) loader.load();

            // Set recipe into the center of root layout.
            root.setCenter(home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showIdentification() {
        try {
            // Load identification.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CTLMProject.class.getResource("Identification.fxml"));
            AnchorPane identification = (AnchorPane) loader.load();

            // Set recipe into the center of root layout.
            root.setCenter(identification);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
