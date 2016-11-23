package ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Elwin Slokker
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
        Parent page = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(page);
        primaryStage.setTitle("Corendon Bagage Systeem");
        primaryStage.setScene(scene);
        primaryStage.show();
        }catch (Exception ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
