package ui;

import backend.UIClass;
import corendonbagagesysteem.CorendonBagageSysteem;
import ui.MainUIController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Node luggageForm;
    private Node accountManager;
    private Node accountManagerEdit;
    private Node statistics;
    private Node home;
    private Node claims;
    private Node logInScreen;
    
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
    /**This constructor is only called by the FX thread and no other instance of this controller 
     * should be created.
     * 
     * @throws IOException 
     */
    public NavigationBarController() throws IOException{
        //load the Luggage List and set the anchorproperties for proper resize.
        this.luggageList = FXMLLoader.load(getClass().getResource("LuggageList.fxml"));
        UIClass.setAnchorDistance(this.luggageList, 0.0);
        
        //load the Add Luggage Form and set the anchorproperties for proper resize.
        this.luggageForm = FXMLLoader.load(getClass().getResource("AddFoundLuggage.fxml"));
        UIClass.setAnchorDistance(this.luggageForm, 0.0);
        
        //load the Account Manager screen and set the anchorproperties for proper resize.
        this.accountManager = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));
        UIClass.setAnchorDistance(this.accountManager, 0.0);
        
        //load the Account editor and set the anchorproperties for proper resize.
        this.accountManagerEdit = FXMLLoader.load(getClass().getResource("AccountManagerEdit.fxml"));
        
        //load the Home screen and set the anchorproperties for proper resize.
        this.home = FXMLLoader.load(getClass().getResource("Home.fxml"));
        UIClass.setAnchorDistance(this.home, 0.0);
        
        //load the Statistics screen and set the anchorproperties for proper resize.
        this.statistics = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
        UIClass.setAnchorDistance(this.statistics, 0.0);
        
        //load the Login screen and set the anchorproperties for proper resize.
        //this.logInScreen = FXMLLoader.load(getClass().getResource("logInScreen.fxml"));
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
        //CorendonBagageSysteem.setRoot(this.logInScreen);
    }
    
}
