package ui;

import backend.I18N;
import backend.Account;
import backend.DBConnection;
import corendonbagagesysteem.CorendonBagageSysteem;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
    //private Node mainScreen;
    
    public LogInScreenController() throws IOException{
        //Load the main screen from FXML
        //URL resource = getClass().getResource("Main.fxml");
        //this.mainScreen = FXMLLoader.load(resource);
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
        Connection conn = DBConnection.connectDb();
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM account WHERE username = \'" +
                    this.textFieldUserName.getText() + "\' AND password = \'" +
                    this.passwordFieldPassword.getText() + "\';");
            int counter = 0;
            while (rs.next()) {
                counter++;
                Account.setNewUser(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
            if (counter == 1){
                //If exactly one account matches the user is sent to the mainScreen.
                Node mainScreen;
                URL resource = getClass().getResource("Main.fxml");
                try {
                    mainScreen = FXMLLoader.load(resource);
                    CorendonBagageSysteem.setRoot(mainScreen);
                } catch (IOException ex) {
                    Logger.getLogger(LogInScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if(counter == 0){
                //No matching account so do nothing and alert the user.
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No such account");//ripe for translation
                alert.setHeaderText(null);
                alert.setContentText("Username or password is wrong.");//ripe for translation
                alert.showAndWait();
            }else{
                //Too many matching account so do nothing and alert the user.
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Database error");//ripe for translation
                alert.setHeaderText(null);
                alert.setContentText("There are two or more accounts with the same name. Contact the system-manager.");//ripe for translation
                alert.showAndWait();
                Account.setUser(null);
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }

}
