package ui;

import corendonbagagesysteem.CorendonBagageSysteem;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
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
    private TextField textFieldUserName;
    private PasswordField passwordFieldPassword;
    private Button buttonInloggen;

    private SplitPane mainScreen;

    LogInScreenController() throws IOException {
        URL resource = getClass().getResource("TestMenu.fxml");
        this.mainScreen = FXMLLoader.load(resource);
    }

    @FXML
    private void logInAction(ActionEvent event) {

        ///try {
        //Dit is test code die niet werkt.
        //anchorr.getChildren().
        CorendonBagageSysteem.setRoot(this.mainScreen);
        AnchorPane.setBottomAnchor(this.mainScreen, 0.0);
        AnchorPane.setLeftAnchor(this.mainScreen, 0.0);
        AnchorPane.setRightAnchor(this.mainScreen, 0.0);
        AnchorPane.setTopAnchor(this.mainScreen, 0.0);
        //} catch (IOException ex) {
        // Logger.getLogger(LogInScreenController.class.getName()).log(Level.SEVERE, null, ex);
        ///}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
