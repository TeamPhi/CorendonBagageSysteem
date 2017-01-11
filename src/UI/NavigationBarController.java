package ui;

import backend.I18N;
import backend.Account;
import backend.UIClass;
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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Elwin Slokker
 */
public class NavigationBarController implements Initializable {

    private Node luggageList;
    private Node accountManager;
    private Node statistics;
    private Node configuration;
    private Node claims;
    private Node logInScreen;
    @FXML
    private VBox vboxNavigation;
    @FXML
    private Button buttonLuggageOverview;
    @FXML
    private Button buttonClaims;
    @FXML
    private Button buttonStatistics;
    @FXML
    private Button buttonAccountManager;
    @FXML
    private Button buttonConfiguration;
    @FXML
    private Button buttonSignOut;

    /**
     * This constructor is only called by the FX thread and no other instance of
     * this controller should be created.
     *
     * @throws IOException
     */
    public NavigationBarController() throws IOException {
        //load the Luggage List and set the anchorproperties for proper resize.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LuggageList.fxml"));
        this.luggageList = fxmlLoader.load();
        UIClass.setAnchorDistance(this.luggageList, 0.0);
        //TEMP CODE FOR SCROLLING PROBLEM
        //((LuggageListController)fxmlLoader.getController()).setScrollBarBinding();
        //this.luggageList = CorendonBagageSysteem.getLuggageList();

        //load the Account Manager screen and set the anchorproperties for proper resize.
        this.accountManager = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));
        UIClass.setAnchorDistance(this.accountManager, 0.0);
        
        //load the Statistics screen and set the anchorproperties for proper resize.
        this.statistics = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
        UIClass.setAnchorDistance(this.statistics, 0.0);

        //load the configuration screen and set the anchorproperties for proper resize.
        this.configuration = FXMLLoader.load(getClass().getResource("Config.fxml"));
        UIClass.setAnchorDistance(this.configuration, 0.0);

        //load the Login screen and set the anchorproperties for proper resize.
        this.logInScreen = FXMLLoader.load(getClass().getResource("logInScreen.fxml"));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Bind all the texts to the translation.
        I18N.bindText(this.buttonLuggageOverview.getText(), this.buttonLuggageOverview, (Object[]) null);
        I18N.bindText(this.buttonClaims.getText(), this.buttonClaims, (Object[]) null);
        I18N.bindText(this.buttonStatistics.getText(), this.buttonStatistics, (Object[]) null);
        I18N.bindText(this.buttonAccountManager.getText(), this.buttonAccountManager, (Object[]) null);
        I18N.bindText(this.buttonConfiguration.getText(), this.buttonConfiguration, (Object[]) null);
        I18N.bindText(this.buttonSignOut.getText(), this.buttonSignOut, (Object[]) null);
        //Check privilege and hide buttons accordingly.
        if (Account.getUser().getPrivilege().equals(Account.SIMPLE_PRIVILEGE)) {
            this.vboxNavigation.getChildren().remove(this.buttonAccountManager);
            this.vboxNavigation.getChildren().remove(this.buttonStatistics);
        } else if (Account.getUser().getPrivilege().equals(Account.ADVANCED_PRIVILEGE)) {
            //leave the bar as is.
        } else {
            this.vboxNavigation.getChildren().remove(this.buttonAccountManager);
            this.vboxNavigation.getChildren().remove(this.buttonStatistics);
            this.vboxNavigation.getChildren().remove(this.buttonLuggageOverview);
            //this.vboxNavigation.getChildren().remove(this.buttonClaims);
            this.vboxNavigation.getChildren().remove(this.buttonConfiguration);
        }
        //there is no claim screen yet, so disable the button.
        this.vboxNavigation.getChildren().remove(this.buttonClaims);
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
    private void configurationButtonClicked(ActionEvent event) {
        MainUIController.getContentBox().getChildren().setAll(this.configuration);
    }

    @FXML
    private void logOutButtonClicked(ActionEvent event) {
        CorendonBagageSysteem.setRoot(this.logInScreen);
    }
    public Node getLuggageNode()
    {
        return this.luggageList;
    }
}
