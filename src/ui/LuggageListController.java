package ui;

import backend.FoundLuggage;
import backend.LostLuggage;
import backend.Luggage;
import backend.LuggageEnum;
import backend.StatusEnum;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML
 *
 * @author Elwin Slokker
 */
public class LuggageListController implements Initializable {
    /*
    These lists need to be created for the table view.
    Because a table view can only display rows directly taken from objects in an observable list.
    */
    public static ObservableList<FoundLuggage> foundLuggageData;
    public static ObservableList<LostLuggage> lostLuggageData;

    @FXML
    private Tab tabFound;
    //TableView and their columns need to know which objects are contained.
    @FXML
    private TableView<FoundLuggage> tableFoundLuggage;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundLabelnumber;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundAirport;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundFlightnumber;
    @FXML
    private TableColumn<FoundLuggage, String> columnLostFound;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundDestination;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundType;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundBrand;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundColor;
    @FXML
    private TableColumn<FoundLuggage, Date> columnFoundDate;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundStatus;
    @FXML
    private Button buttonFoundSearch;
    @FXML
    private Button buttonFoundMatch;
    @FXML
    private Button buttonFoundExport;
    @FXML
    private Button buttonFoundImport;
    @FXML
    private Button buttonFoundEdit;
    @FXML
    private Button buttonFoundAdd;
    @FXML
    private Tab tabLost;
    @FXML
    private TableView<LostLuggage> tableLostLuggage;
    @FXML
    private TableColumn<LostLuggage, String> columnLostLabelnumber;
    @FXML
    private TableColumn<LostLuggage, String> columnLostAirport;
    @FXML
    private TableColumn<LostLuggage, String> columnLostFlightnumber;
    @FXML
    private TableColumn<LostLuggage, String> columnLostDestination;
    @FXML
    private TableColumn<LostLuggage, String> columnLostType;
    @FXML
    private TableColumn<LostLuggage, String> columnLostBrand;
    @FXML
    private TableColumn<LostLuggage, String> columnLostColor;
    @FXML
    private TableColumn<LostLuggage, Date> columnLostDate;
    @FXML
    private TableColumn<LostLuggage, String> columnLostStatus;
    @FXML
    private Button buttonLostSearch;
    @FXML
    private Button buttonLostMatch;
    @FXML
    private Button buttonLostExport;
    @FXML
    private Button buttonLostImport;
    @FXML
    private Button buttonLostEdit;
    @FXML
    private Button buttonLostAdd;

    @FXML
    private Tab tabMatches;
    @FXML
    private Button buttonMatchSearch;
    @FXML
    private Button buttonMatchMatch;
    @FXML
    private Button buttonMatchExport;
    @FXML
    private Button buttonMatchImport;
    @FXML
    private Button buttonMatchForm;
    

    /**Only the FXML thread may call the controller constructor. 
     * It can be used to initialize variables or controls before the initialize method.
     *
     */
    public LuggageListController() {
        //The list is filled with a test data.
        LuggageListController.foundLuggageData = FXCollections.observableArrayList(
                new FoundLuggage("11223344", "Schiphol", "14253443", LuggageEnum.MISC, "samsonite", "black", "1234", new Date(100000L), StatusEnum.REGISTERED, "empty"));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* The section of the found luggage initialization.
        First all the controls are bound the translation.
        */
        I18N.bindTabText(this.tabFound.getText(), this.tabFound, (Object[]) null);
        I18N.bindTableText(this.columnFoundLabelnumber.getText(), this.columnFoundLabelnumber, (Object[]) null);
        I18N.bindTableText(this.columnFoundAirport.getText(), this.columnFoundAirport, (Object[]) null);
        I18N.bindTableText(this.columnFoundFlightnumber.getText(), this.columnFoundFlightnumber, (Object[]) null);
        I18N.bindTableText(this.columnLostFound.getText(), this.columnLostFound, (Object[]) null);
        I18N.bindTableText(this.columnFoundDestination.getText(), this.columnFoundDestination, (Object[]) null);
        I18N.bindTableText(this.columnFoundType.getText(), this.columnFoundType, (Object[]) null);
        I18N.bindTableText(this.columnFoundBrand.getText(), this.columnFoundBrand, (Object[]) null);
        I18N.bindTableText(this.columnFoundColor.getText(), this.columnFoundColor, (Object[]) null);
        I18N.bindTableText(this.columnFoundDate.getText(), this.columnFoundDate, (Object[]) null);
        I18N.bindTableText(this.columnFoundStatus.getText(), this.columnFoundStatus, (Object[]) null);
        I18N.bindText(this.buttonFoundSearch.getText(), this.buttonFoundSearch, (Object[]) null);
        I18N.bindText(this.buttonFoundMatch.getText(), this.buttonFoundMatch, (Object[]) null);
        I18N.bindText(this.buttonFoundExport.getText(), this.buttonFoundExport, (Object[]) null);
        I18N.bindText(this.buttonFoundImport.getText(), this.buttonFoundImport, (Object[]) null);
        I18N.bindText(this.buttonFoundEdit.getText(), this.buttonFoundEdit, (Object[]) null);
        I18N.bindText(this.buttonFoundAdd.getText(), this.buttonFoundAdd, (Object[]) null);

        //init collumns and decide what values are stored in them.
        this.columnFoundLabelnumber.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, String>("labelNumber"));
        this.columnFoundAirport.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, String>("registeredAirport"));
        this.columnFoundFlightnumber.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, String>("flightnumber"));
        this.columnLostFound.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, String>("lostFoundID"));
        this.columnFoundDestination.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, String>("destination"));
        this.columnFoundType.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, String>("type"));
        this.columnFoundBrand.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, String>("brand"));
        this.columnFoundColor.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, String>("color"));
        this.columnFoundDate.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, Date>("date"));
        this.columnFoundStatus.setCellValueFactory(
                new PropertyValueFactory<FoundLuggage, String>("status"));
        //Connect list with table
        this.tableFoundLuggage.setItems(foundLuggageData);
        /* The section of the lost luggage initialization.
        First all the controls are bound the translation.
        */
        I18N.bindTabText(this.tabLost.getText(), this.tabLost, (Object[]) null);
        I18N.bindTableText(this.columnLostLabelnumber.getText(), this.columnLostLabelnumber, (Object[]) null);
        I18N.bindTableText(this.columnLostAirport.getText(), this.columnLostAirport, (Object[]) null);
        I18N.bindTableText(this.columnLostFlightnumber.getText(), this.columnLostFlightnumber, (Object[]) null);
        I18N.bindTableText(this.columnLostDestination.getText(), this.columnLostDestination, (Object[]) null);
        I18N.bindTableText(this.columnLostType.getText(), this.columnLostType, (Object[]) null);
        I18N.bindTableText(this.columnLostBrand.getText(), this.columnLostBrand, (Object[]) null);
        I18N.bindTableText(this.columnLostColor.getText(), this.columnLostColor, (Object[]) null);
        I18N.bindTableText(this.columnLostDate.getText(), this.columnLostDate, (Object[]) null);
        I18N.bindTableText(this.columnLostStatus.getText(), this.columnLostStatus, (Object[]) null);
        I18N.bindText(this.buttonLostSearch.getText(), this.buttonLostSearch, (Object[]) null);
        I18N.bindText(this.buttonLostMatch.getText(), this.buttonLostMatch, (Object[]) null);
        I18N.bindText(this.buttonLostExport.getText(), this.buttonLostExport, (Object[]) null);
        I18N.bindText(this.buttonLostImport.getText(), this.buttonLostImport, (Object[]) null);
        I18N.bindText(this.buttonLostEdit.getText(), this.buttonLostEdit, (Object[]) null);
        I18N.bindText(this.buttonLostAdd.getText(), this.buttonLostAdd, (Object[]) null);
        
        /* The section of the matched luggage initialization.
        First all the controls are bound the translation.
        */
        I18N.bindTabText(this.tabMatches.getText(), this.tabMatches, (Object[]) null);
    }

    public ObservableList<FoundLuggage> getFoundLuggageDate() {
        return LuggageListController.foundLuggageData;
    }

    public ObservableList<LostLuggage> getLostLuggageDate() {
        return LuggageListController.lostLuggageData;
    }

    @FXML
    private void searchFoundButtonClicked(ActionEvent event) {

    }

    @FXML
    private void matchFoundButtonClicked(ActionEvent event) {

    }

    @FXML
    private void exportFoundButtonClicked(ActionEvent event) {

    }

    @FXML
    private void importFoundButtonClicked(ActionEvent event) {

    }

    @FXML
    private void ediFoundButtonClicked(ActionEvent event) {

    }

    @FXML
    private void addFoundButtonClicked(ActionEvent event) {
        /* Load the add screen.
        First the FXML file is loaded and then a new Stage is made (a window) and shown.
        */
        try {
            //this.tableFoundLuggage.setItems(foundLuggageData); ONLY FOR TESTING
            Parent addScreen = FXMLLoader.load(getClass().getResource("AddFoundLuggage.fxml"));
            Stage add = new Stage();
            Scene scene = new Scene(addScreen);
            add.setTitle("Corendon Bagage Systeem");
            add.setScene(scene);
            add.show();
        } catch (IOException ex) {
            Logger.getLogger(LuggageListController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void searchLostButtonClicked(ActionEvent event) {

    }

    @FXML
    private void matchLostButtonClicked(ActionEvent event) {

    }

    @FXML
    private void exportLostButtonClicked(ActionEvent event) {

    }

    @FXML
    private void importLostButtonClicked(ActionEvent event) {

    }

    @FXML
    private void ediLostButtonClicked(ActionEvent event) {

    }

    @FXML
    private void addLostButtonClicked(ActionEvent event) {

    }
}
