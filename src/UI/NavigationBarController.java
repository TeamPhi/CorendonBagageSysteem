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
    private Node statistics;
    private Node home;
    private Node claims;
    
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
    /**This constructor is only called by the FX thread and no instance of this controller 
     * should be created.
     * 
     * @throws IOException 
     */
    public NavigationBarController() throws IOException{
        //load the Luggage List and set the anchorproperties for proper resize.
        this.luggageList = FXMLLoader.load(getClass().getResource("LuggageList.fxml"));
        AnchorPane.setBottomAnchor(this.luggageList, 0.0);
        AnchorPane.setLeftAnchor(this.luggageList, 0.0);
        AnchorPane.setRightAnchor(this.luggageList, 0.0);
        AnchorPane.setTopAnchor(this.luggageList, 0.0);
        //load the Account Manager screen and set the anchorproperties for proper resize.
        this.accountManager = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));
        AnchorPane.setBottomAnchor(this.accountManager, 0.0);
        AnchorPane.setLeftAnchor(this.accountManager, 0.0);
        AnchorPane.setRightAnchor(this.accountManager, 0.0);
        AnchorPane.setTopAnchor(this.accountManager, 0.0);
        //load the Home screen and set the anchorproperties for proper resize.
        this.home = FXMLLoader.load(getClass().getResource("Home.fxml"));
        AnchorPane.setBottomAnchor(this.home, 0.0);
        AnchorPane.setLeftAnchor(this.home, 0.0);
        AnchorPane.setRightAnchor(this.home, 0.0);
        AnchorPane.setTopAnchor(this.home, 0.0);
        //load the Statistics screen and set the anchorproperties for proper resize.
        this.statistics = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
        AnchorPane.setBottomAnchor(this.statistics, 0.0);
        AnchorPane.setLeftAnchor(this.statistics, 0.0);
        AnchorPane.setRightAnchor(this.statistics, 0.0);
        AnchorPane.setTopAnchor(this.statistics, 0.0);

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
        MainUIController.getContentBox().getChildren().setAll(this.home);
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
         MainUIController.getContentBox().getChildren().setAll(this.statistics);
    }

    @FXML
    private void accountmanagementButtonClicked(ActionEvent event) {
        MainUIController.getContentBox().getChildren().setAll(this.accountManager);
    }

    @FXML
    private void logOutButtonClicked(ActionEvent event) {
        
    }
    
}
