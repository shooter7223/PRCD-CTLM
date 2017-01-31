package prcd.ctlm;


import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import prcd.ctlm.controller.UsersListController;

/**
 * @author Thomas Caspar and Thérésien Esberard
 */
public class CTLMProject extends Application {
    private Parent parent;
    private Stage primaryStage;

    public void load(String file, Stage stage) throws IOException {        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CTLMProject.class.getResource(file));
        parent = loader.load();
        Scene scene = new Scene(parent, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chozafer");
        load("view/Identification.fxml", primaryStage);
    }
    
    public void close(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        stage.close();
    }
    
    public void goHome(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("view/Home.fxml", stage);
    }
    
    public void viewTasks(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("view/ViewTasks.fxml", stage);
    }
    
    public void addTask(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("view/AddTask.fxml", stage);
    }
    
    public void finishTask(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("view/FinishTask.fxml", stage);
    }
    
    public void takeTask(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("view/TakeTask.fxml", stage);
    }
    
    public void attributeTask(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("view/AttributeTask.fxml", stage);
    }
    
    public void deleteTask(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("view/DeleteTask.fxml", stage);
    }
    
    public void logOut(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("view/Identification.fxml", stage);
    }
    
    public void showUsersList() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        Stage stage = new Stage();

        loader.setLocation(CTLMProject.class.getResource("view/UsersList.fxml"));
        parent = loader.load();
        Scene scene = new Scene(parent, 250, 250);
        stage.setScene(scene);
        stage.show();
        
        UsersListController controller = loader.getController();
        controller.setDialogStage(stage);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
