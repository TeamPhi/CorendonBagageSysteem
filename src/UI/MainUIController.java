package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author Elwin Slokker
 */
public class MainUIController implements Initializable{
    private VBox navigationBar;
    private HBox languageBar;
    
    private static AnchorPane contentBox = new AnchorPane();
        
    @FXML
    private AnchorPane paneContent;
    @FXML
    private AnchorPane paneHeader;
    @FXML
    private AnchorPane paneNavigation;
    
    public MainUIController() throws IOException {
        this.navigationBar = FXMLLoader.load(getClass().getResource("NavigationBar.fxml"));
        this.languageBar = FXMLLoader.load(getClass().getResource("LanguageBar.fxml"));        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.paneNavigation.getChildren().setAll(this.navigationBar);
         this.paneHeader.getChildren().setAll(this.languageBar);
         AnchorPane.setRightAnchor(this.languageBar, 0.0);
         MainUIController.contentBox = this.paneContent;
    }  
    /**This method is used for changing the main screen contents.
     * 
     * 
     * @return A reference to the content holding screen.
     */
    public static AnchorPane getContentBox(){
        return MainUIController.contentBox;
    }
     
}
