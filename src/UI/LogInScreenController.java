package ui;

import corendonbagagesysteem.CorendonBagageSysteem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Enes
 */
public class LogInScreenController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelPassword;
    @FXML
    private PasswordField passwordFieldPassword;
    @FXML
    private TextField textFieldUserName;
    @FXML
    private Button buttonInloggen;
    
    private Node mainScreen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        I18N.bindText(this.labelUsername.getText(), this.labelUsername, (Object[]) null);
        I18N.bindText(this.labelPassword.getText(), this.labelPassword, (Object[]) null);
        I18N.bindText(this.buttonInloggen.getText(), this.buttonInloggen, (Object[]) null);
    }    
    
    public LogInScreenController() throws IOException{
        URL resource = getClass().getResource("Main.fxml");
        this.mainScreen = FXMLLoader.load(resource);
        //this.mainScreen = FXMLLoader.load(getClass().getResource("/ui/logInScreen.fxml"));
    }

    @FXML
    private void logInAction(ActionEvent event) {
        CorendonBagageSysteem.setRoot(mainScreen);
    }
    
}
