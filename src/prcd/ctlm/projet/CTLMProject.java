/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prcd.ctlm.projet;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */
public class CTLMProject extends Application {
    private Parent parent;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("The Collaborative Todo List Manager");
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("Identification.fxml"));
        parent = loader.load();
        Scene scene = new Scene(parent, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void goHome(ActionEvent e) throws IOException{
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
    
    public void viewTasks(ActionEvent e) throws IOException {
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
    
    public void addTask(ActionEvent e) throws IOException{
        Stage stage; 
        GridPane addTask;
     
        // get reference to the button's stage to stay at the same page
        stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        
        // load up AddTask.fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource("AddTask.fxml"));
        addTask = loader.load();
        Scene scene = new Scene(addTask);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
