package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Elwin Slokker
 */
public class AccountManagerEditController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private ChoiceBox<?> accountPrivilegeChoiceBox;
    @FXML
    private Label labelSurname;
    @FXML
    private TextField textFieldSurname;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelPrivilege;
    @FXML
    private Label labelChangePass;
    @FXML
    private Label labelPassPrompt;
    @FXML
    private Label labelPassRepeat;
    @FXML
    private TextField textFieldNewPasswordRepeat;
    @FXML
    private Label labelResetPass;
    @FXML
    private Button buttonResetPassword;
    @FXML
    private Button buttonSave;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void resetPassword(ActionEvent event) {
    }

    @FXML
    private void Save(ActionEvent event) {
    }

}
