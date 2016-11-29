package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author Elwin Slokker
 */
public class MainUIController implements Initializable{
    private Button buttonTestNaam;
    private VBox navigationBar;
    private HBox languagebox;
    private AnchorPane paneHome;
        
    @FXML
    private AnchorPane paneContent;

    @FXML
    private AnchorPane paneHeader;

    @FXML
    private AnchorPane paneNavigation;
    
    public MainUIController() throws IOException {
        System.out.println("LOADING MAIN UI CONTROLLER");
        
        this.navigationBar = FXMLLoader.load(getClass().getResource("NavigationBar.fxml"));
        this.paneNavigation.getChildren().setAll(navigationBar);
        this.paneHome = FXMLLoader.load(getClass().getResource("Home.fxml"));
        this.paneContent.getChildren().setAll(paneHome);
        this.languagebox = FXMLLoader.load(getClass().getResource("LanguageBox.fxml"));
        this.paneHeader.getChildren().setAll(languagebox);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
}
