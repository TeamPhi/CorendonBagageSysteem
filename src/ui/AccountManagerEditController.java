package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    private TextField accountManagementLastNameTextField;
    @FXML
    private TextField accountManagementFirstNameTextField;
    @FXML
    private TextField accountManagementEmailAdress;
    @FXML
    private ChoiceBox<?> accountPrivilegeChoiceBox;
    @FXML
    private TextField newPasswordTextField;
    @FXML
    private TextField newPasswordConfirmTextField;
    @FXML
    private Button accountManagementResetPasswordButton;
    @FXML
    private Button accountManagementSaveChangesButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
