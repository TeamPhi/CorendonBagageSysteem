package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Enes
 */
public class LogInScreenController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @FXML
    AnchorPane anchorr;
    @FXML
    private TextField textFieldGebruikersnaam;
    @FXML
    private PasswordField passwordFieldWachtwoord;
    @FXML
    private Button buttonInloggen;
    
    @FXML
    private void logInAction(ActionEvent event) {
        //anchorr.getChildren().

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
