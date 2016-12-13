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
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Enes
 * @author Elwin
 */
public class LogInScreenController implements Initializable {
    private HBox languageBar;
    
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private AnchorPane paneLanguageBar;
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
    //the object that holds the main screen.
    private Node mainScreen;
    
    public LogInScreenController() throws IOException{
        //Load the main screen from FXML
        URL resource = getClass().getResource("Main.fxml");
        this.mainScreen = FXMLLoader.load(resource);
        //Load the languagebar from FXML.
        this.languageBar = FXMLLoader.load(getClass().getResource("LanguageBar.fxml"));
        //this.mainScreen = FXMLLoader.load(getClass().getResource("/ui/logInScreen.fxml"));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //bind all text to the translations.
        I18N.bindText(this.labelUsername.getText(), this.labelUsername, (Object[]) null);
        I18N.bindText(this.labelPassword.getText(), this.labelPassword, (Object[]) null);
        I18N.bindText(this.buttonInloggen.getText(), this.buttonInloggen, (Object[]) null);
        //I18N.bindText("some",this.passwordFieldPassword., (Object[]) null);
        //Add the languagebar and allign it.
        this.paneLanguageBar.getChildren().setAll(this.languageBar);
        AnchorPane.setRightAnchor(this.languageBar, 0.0);
    }    
    


    @FXML
    private void logInAction(ActionEvent event) {
        /*
        query to check the password and username
        */
        //Test account
        if (this.textFieldUserName.getText().equals("admin")  && this.passwordFieldPassword.getText().equals("1234")){
            
            //Change the root, so the screen switches.
            CorendonBagageSysteem.setRoot(mainScreen);
            
        }
        else{
            CorendonBagageSysteem.setRoot(mainScreen);
        }
    }

}
