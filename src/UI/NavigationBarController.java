package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Elwin Slokker
 */
public class NavigationBarController implements Initializable {

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
    }

    @FXML
    private void claimsButtonClicked(ActionEvent event) {
    }

    @FXML
    private void statisticsButtonClicked(ActionEvent event) {
    }

    @FXML
    private void accountmanagementButtonClicked(ActionEvent event) {
    }

    @FXML
    private void logOutButtonClicked(ActionEvent event) {
    }
    
}
