package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private TextField textFieldGebruikersnaam;
    private PasswordField passwordFieldWachtwoord;
    private Button buttonInloggen;
    
    private void logInAction(ActionEvent event) {
        System.out.println("todo");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
