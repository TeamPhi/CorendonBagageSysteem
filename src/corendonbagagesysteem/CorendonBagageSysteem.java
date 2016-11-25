package corendonbagagesysteem;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * 
 * @author Jordy
 */
public class CorendonBagageSysteem extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getResource("/ui/TestMenu.fxml"));
        //AnchorPane root2 = FXMLLoader.load(getClass().getResource("/ui/LogInScreen.fxml"));
        //AnchorPane anchorRoot;
        //anchorRoot.getChildren().add(root2)
        //AnchorPane.setBottomAnchor(root2, 0.0);
        //AnchorPane.setLeftAnchor(root2, 0.0);
        //AnchorPane.setRightAnchor(root2, 0.0);
        //AnchorPane.setTopAnchor(root2, 0.0);
        Scene scene = new Scene(root);
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
    
}
