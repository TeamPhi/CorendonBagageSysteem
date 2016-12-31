package corendonbagagesysteem;

import backend.I18N;
import backend.UIClass;
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
 * @author Elwin
 * @author Mark
 */
public class CorendonBagageSysteem extends Application {
    //This pane should always be the root and always hosts the other screens.
    private static AnchorPane root;
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent startScreen = FXMLLoader.load(getClass().getResource("/ui/logInScreen.fxml"));
        //Needs to be constructed/initzialized first.
        root = new AnchorPane();
        setRoot(startScreen);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");

        primaryStage.titleProperty().bind(I18N.createStringBinding(I18N.PROGRAM_NAME_KEY,(Object[]) null));
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
     * the passed Node onto it. In addition, the node is anchored to the edges of the rootpane.
     * @param e The screen or elements you want to display on the screen.
     */
    public static void setRoot(Node e){
        root.getChildren().clear();
        root.getChildren().add(e);
        UIClass.setAnchorDistance(e, 0.0);
    }
}
