package corendonbagagesysteem;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * 
 * @author Jordy
 */
public class CorendonBagageSysteem extends Application {
    //This pane should always be the root and always hosts the other screens.
    private static AnchorPane anchorRoot;
    @Override
    public void start(Stage primaryStage) throws IOException {
       
        //Parent root = FXMLLoader.load(getClass().getResource("/ui/TestMenu.fxml"));
        AnchorPane root2 = FXMLLoader.load(getClass().getResource("/ui/logInScreen.fxml"));
        //Needs to be constructed/initzialized first.
        anchorRoot = new AnchorPane();
        anchorRoot.getChildren().add(root2);
        AnchorPane.setBottomAnchor(root2, 0.0);
        AnchorPane.setLeftAnchor(root2, 0.0);
        AnchorPane.setRightAnchor(root2, 0.0);
        AnchorPane.setTopAnchor(root2, 0.0);
        Scene scene = new Scene(anchorRoot);
        primaryStage.setTitle("Corendon Bagage Systeem");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Change the screen by removing all nodes attached to anchorRoot and placing
     * the passed Node onto it.
     * @param e The screen or elements you want to display on the screen.
     */
    public static void setRoot(Node e){
        anchorRoot.getChildren().clear();
        anchorRoot.getChildren().add(e);
    }
}
