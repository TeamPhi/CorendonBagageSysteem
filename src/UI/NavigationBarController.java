package ui;

import ui.MainUIController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Elwin Slokker
 */
public class NavigationBarController implements Initializable {
    
    private Node luggageList;
    private Node accountManager;
    
    @FXML
    private Button buttonHome;
    @FXML
    private Button buttonLuggageOverview;
    @FXML
    private Button buttonClaims;
    @FXML
    private Button buttonStatistics;
    @FXML
    private Button buttonAccountManager;
    @FXML
    private Button buttonSignOut;

    public NavigationBarController() throws IOException{
        this.luggageList = FXMLLoader.load(getClass().getResource("LuggageList.fxml"));
        this.accountManager = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void homeButtonClicked(ActionEvent event) {
    }

    @FXML
    private void luggageOverviewButtonClicked(ActionEvent event) {
        MainUIController.getContentBox().getChildren().setAll(this.luggageList);
        
    }

    @FXML
    private void claimsButtonClicked(ActionEvent event) {
    }

    @FXML
    private void statisticsButtonClicked(ActionEvent event) {
    }

    @FXML
    private void accountmanagementButtonClicked(ActionEvent event) {
        MainUIController.getContentBox().getChildren().setAll(this.accountManager);
    }

    @FXML
    private void logOutButtonClicked(ActionEvent event) {
    }
    
}
