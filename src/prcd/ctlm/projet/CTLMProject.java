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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */
public class CTLMProject extends Application {
    private AnchorPane identification;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CTLM");
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("Identification.fxml"));
        identification = loader.load();
        Scene scene = new Scene(identification);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * Shows the home inside the root.
     * @throws java.io.IOException
     */
    /*public void showHome() throws IOException {
        // Load home.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("Home.fxml"));
        GridPane home = loader.load();

        // Set home into the center of root layout.
        root.setCenter(home);
    }*/
    
    /*public void showIdentification() throws IOException {
        // Load identification.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("Identification.fxml"));
        AnchorPane identification = loader.load();

        // Set idenfication into the center of root layout.
        root.setCenter(identification);
    }*/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
