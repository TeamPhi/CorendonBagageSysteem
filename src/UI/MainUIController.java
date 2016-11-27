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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
/**
 *
 * @author Elwin Slokker
 */
public class MainUIController implements Initializable{
    @FXML
    private AnchorPane paneHeader;
    @FXML
    private AnchorPane paneNavigation;
    @FXML
    private AnchorPane paneContent;
    @FXML
    private Button buttonTestNaam;
    @FXML
    private void testThis(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }   
}
