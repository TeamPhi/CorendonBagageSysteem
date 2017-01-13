package ui;

import backend.I18N;
import backend.DBConnection;
import backend.FoundLuggage;
import backend.LostLuggage;
import backend.Luggage;
import backend.Passenger;
import backend.LuggageSearchBarLogic;
import backend.UIClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML
 *
 * @author Elwin Slokker & Jordy Quak
 */
public class LuggageListController implements Initializable {

    /*
    These lists need to be created for the table view.
    Because a table view can only display rows directly taken from objects in an observable list.
     */
    public static ObservableList<FoundLuggage> foundLuggageData;
    public static ObservableList<LostLuggage> lostLuggageData;
    public static ObservableList<FoundLuggage> matchedFoundLuggageData;
    public static ObservableList<LostLuggage> matchedLostLuggageData;
    private static ArrayList<Passenger> passengerList = new ArrayList<>();
    //private DBConnection dbc;
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
    private TableColumn<FoundLuggage, String> columnLostFound;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundFlightnumber;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundDestination;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundType;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundBrand;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundColor;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundDate;
    @FXML
    private TableColumn<FoundLuggage, String> columnFoundStatus;
    @FXML
    private TextField textFieldFoundSearch;
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
    private Button buttonFoundDelete;
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
    private TableColumn<LostLuggage, String> columnLostDate;
    @FXML
    private TableColumn<LostLuggage, String> columnLostStatus;
    @FXML
    private TextField textFieldFoundLost;//removable?
    @FXML
    private TextField textFieldLostSearch;
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
    private Button buttonLostDelete;

    @FXML
    private Tab tabMatches;
    @FXML
    private TableView<FoundLuggage> tableMatchedFoundLuggage;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedFoundLabelnumber;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedFoundAirport;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedLostFound;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedFoundFlightnumber;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedFoundDestination;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedFoundType;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedFoundBrand;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedFoundColor;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedFoundDate;
    @FXML
    private TableColumn<FoundLuggage, String> columnMatchedFoundStatus;

    @FXML
    private TableView<LostLuggage> tableMatchedLostLuggage;
    @FXML
    private TableColumn<LostLuggage, String> columnMatchedLostLabelnumber;
    @FXML
    private TableColumn<LostLuggage, String> columnMatchedLostAirport;
    @FXML
    private TableColumn<LostLuggage, String> columnMatchedLostFlightnumber;
    @FXML
    private TableColumn<LostLuggage, String> columnMatchedLostDestination;
    @FXML
    private TableColumn<LostLuggage, String> columnMatchedLostType;
    @FXML
    private TableColumn<LostLuggage, String> columnMatchedLostBrand;
    @FXML
    private TableColumn<LostLuggage, String> columnMatchedLostColor;
    @FXML
    private TableColumn<LostLuggage, String> columnMatchedLostDate;
    @FXML
    private TableColumn<LostLuggage, String> columnMatchedLostStatus;
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
    @FXML
    private Button buttonFoundLoad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //First load the passengers from data base
        //Then load there luggage and connect it.
        loadFoundLuggage();
        loadLostLuggage();
        //Passenger p 
        //LuggageListController.passengerList.add(p);
        //p.addLostLuggage(tempLuggage);
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
        I18N.bindText(this.buttonFoundDelete.getText(), this.buttonFoundDelete, (Object[]) null);

        //Connect list with table
//        this.tableFoundLuggage.setItems(foundLuggageData);
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
        I18N.bindText(this.buttonLostDelete.getText(), this.buttonLostDelete, (Object[]) null);
        //make the list.
        //LuggageListController.lostLuggageData = FXCollections.observableArrayList();
        /* The section of the matched luggage initialization.
        First all the controls are bound the translation.
         */
        I18N.bindTabText(this.tabMatches.getText(), this.tabMatches, (Object[]) null);

        this.columnMatchedFoundLabelnumber.setCellValueFactory(new PropertyValueFactory<>("labelNumber"));
        this.columnMatchedFoundAirport.setCellValueFactory(new PropertyValueFactory<>("airport"));
        this.columnMatchedFoundFlightnumber.setCellValueFactory(new PropertyValueFactory<>("flightnumber"));
        this.columnMatchedLostFound.setCellValueFactory(new PropertyValueFactory<>("lostFoundID"));
        this.columnMatchedFoundDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        //this.columnMatchedFoundType.setCellValueFactory(new PropertyValueFactory<>("type"));
        //this.columnMatchedFoundBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        //this.columnMatchedFoundColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        this.columnMatchedFoundDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.columnMatchedFoundStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        LuggageListController.matchedFoundLuggageData = FXCollections.observableArrayList();
        FoundLuggage f = new FoundLuggage("a", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);
        LuggageListController.matchedFoundLuggageData.add(f);

        //this.tableMatchedFoundLuggage.setItems(null);
        this.tableMatchedFoundLuggage.setItems(LuggageListController.matchedFoundLuggageData);

        this.columnMatchedLostLabelnumber.setCellValueFactory(new PropertyValueFactory<>("labelNumber"));
        this.columnMatchedLostAirport.setCellValueFactory(new PropertyValueFactory<>("airport"));
        this.columnMatchedLostFlightnumber.setCellValueFactory(new PropertyValueFactory<>("flightnumber"));
        this.columnMatchedLostDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        //this.columnMatchedLostType.setCellValueFactory(new PropertyValueFactory<>("type"));
        //this.columnMatchedLostBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        //this.columnMatchedLostColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        this.columnMatchedLostDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.columnMatchedLostStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        LuggageListController.matchedLostLuggageData = FXCollections.observableArrayList();
        LostLuggage l = new LostLuggage("a", "a", "b", "c", "d", "e", "f", "g", "h", "i");
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        LuggageListController.matchedLostLuggageData.add(l);
        //this.tableMatchedLostLuggage.setItems(null);
        this.tableMatchedLostLuggage.setItems(LuggageListController.matchedLostLuggageData);
    }

    @FXML
    public void loadDataFromFoundLuggage(ActionEvent event) {
        loadFoundLuggage();
    }

    @FXML
    private void deleteFoundLuggage(ActionEvent event) {
        if (isTableSelection(this.tableFoundLuggage)) {
            if (UIClass.promptDelete()) {
                /*
                SQL-Statement to delete the luggage.
                 */
                LuggageListController.foundLuggageData.remove(this.tableFoundLuggage.getSelectionModel().getSelectedItem());
            } else {
                //nothing
            }
        } else {
            UIClass.showPopup("errorNoSelectionTitle", "errorNSDeleteDesc");
        }
    }

    @FXML
    private void deleteLostLuggage(ActionEvent event) {
        if (isTableSelection(this.tableLostLuggage)) {
            if (UIClass.promptDelete()) {
                /*
                SQL-Statement to delete the luggage.
                 */
                LuggageListController.lostLuggageData.remove(this.tableLostLuggage.getSelectionModel().getSelectedItem());
            } else {
                //nothing
            }
        } else {
            UIClass.showPopup("errorNoSelectionTitle", "errorNSDeleteDesc");
        }
    }

    @FXML
    private void searchActionFound(ActionEvent event) {
        this.tableFoundLuggage.setItems((ObservableList) FXCollections.observableArrayList(LuggageSearchBarLogic.interpretSearchString(this.textFieldFoundSearch.getText(),
                new ArrayList<>(LuggageListController.foundLuggageData), true)));
    }

    @FXML
    private void matchFoundButtonClicked(ActionEvent event) {
        matchLuggage(tableFoundLuggage.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void exportFoundButtonClicked(ActionEvent event) {

    }

    @FXML
    private void importFoundButtonClicked(ActionEvent event) {

    }

    @FXML
    private void addFoundButtonClicked(ActionEvent event) {
        showAddLuggage(null, null, true, true);
    }

    @FXML
    private void editFoundButtonClicked(ActionEvent event) {
        if (isTableSelection(this.tableFoundLuggage)) {
            /*
            Passenger information needs to be retrieved here.
             */
            //showAddLuggage(this.tableFoundLuggage.getSelectionModel().getSelectedItem(), false, true);
        } else if (LuggageListController.foundLuggageData.isEmpty()) {
            //error if there is no luggage yet.
            UIClass.showPopup("errorNoEntriesTitle", "errorNELuggageDesc");
        } else {
            //error if here is no selection.
            UIClass.showPopup("errorNoSelectionTitle", "errorNSLugaggeDesc");
        }
    }

    @FXML
    private void searchActionLost(ActionEvent event) {
        this.tableLostLuggage.setItems((ObservableList) FXCollections.observableArrayList(LuggageSearchBarLogic.interpretSearchString(this.textFieldLostSearch.getText(),
                new ArrayList<>(LuggageListController.foundLuggageData), false)));
    }

    @FXML
    private void matchLostButtonClicked(ActionEvent event) {
        matchLuggage(tableLostLuggage.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void exportLostButtonClicked(ActionEvent event) {

    }

    @FXML
    private void importLostButtonClicked(ActionEvent event) {

    }

    @FXML
    private void addLostButtonClicked(ActionEvent event) {
        showAddLuggage(null, null, true, false);
    }

    @FXML
    private void editLostButtonClicked(ActionEvent event) {
        if (isTableSelection(this.tableLostLuggage)) {
            /*
            Passenger information needs to be retrieved here.
             */
            //showAddLuggage(this.tableLostLuggage.getSelectionModel().getSelectedItem(), false, false);
        } else if (LuggageListController.lostLuggageData.isEmpty()) {
            //error if there is no luggage yet.
            UIClass.showPopup("errorNoEntriesTitle", "errorNELuggageDesc");//ripe for translation
        } else {
            //error if here is no selection.
            UIClass.showPopup("errorNoSelectionTitle", "errorNSLuggageDesc");//ripe for translation
        }
    }

    @FXML
    private void matchMain(ActionEvent event) {
        /*
        Connection conn = DBConnection.connectDb();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM account WHERE username = \'" +
                    this.textFieldUserName.getText() + "\' AND password = \'" +
                    this.passwordFieldPassword.getText() + "\';");
            int counter = 0;
            while (rs.next()) {
                counter++;
                Account.setNewUser(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        FoundLuggages worden gemaakt door de Select eveneens de LostLuggages
        
        Statements that all need to be executed in order.
        every statement needs to be created to retrieve lostLuggage & foundLuggage
        1:check if (SELECT luggageID) lostLuggage.labelID = foundLuggage.labelID
        2:check if lostLuggage.type = foundLuggage.type
        3:check if lostLuggage.type = foundLuggage.type
        4:check if lostLuggage.color = foundLuggage.color
        5:check if lostLuggage.brand = foundLuggage.brand
        6:check if lostLuggage.flightID = foundLuggage.flightID
        
        7:check if lostLuggage.type = foundLuggage.type
        8:check if lostLuggage.type = foundLuggage.type
        9:check if lostLuggage.passengerInfo = foundLuggage.passengerInfo
        

         */

    }

    @FXML
    private void scrollFoundTable(ScrollEvent event) {

        this.tableMatchedLostLuggage.scrollTo((int) (event.getDeltaY() * event.getMultiplierY()));

    }

    @FXML
    private void scrollLostTable(ScrollEvent event) {
        //this.tableMatchedFoundLuggage
    }

    /*
    @SuppressWarnings("rawtypes")
    private void bindScrollBars(TableView<?> tableView1, TableView<?> tableView2,
            Orientation orientation) {

        // Get the scrollbar of first table
        VirtualFlow vf = (VirtualFlow) tableView1.getChildrenUnmodifiable().get(1);
        ScrollBar scrollBar1 = null;
        for (final Node subNode : vf.getChildrenUnmodifiable()) {
            if (subNode instanceof ScrollBar
                    && ((ScrollBar) subNode).getOrientation() == orientation) {
                scrollBar1 = (ScrollBar) subNode;
            }
        }

        // Get the scrollbar of second table
        vf = (VirtualFlow) tableView2.getChildrenUnmodifiable().get(1);
        ScrollBar scrollBar2 = null;
        for (final Node subNode : vf.getChildrenUnmodifiable()) {
            if (subNode instanceof ScrollBar
                    && ((ScrollBar) subNode).getOrientation() == orientation) {
                scrollBar2 = (ScrollBar) subNode;
            }
        }

        // Set min/max of visible scrollbar to min/max of a table scrollbar
        //scrollBar.setMin(scrollBar1.getMin());
        //scrollBar.setMax(scrollBar1.getMax());

        // bind the hidden scrollbar valueProterty the visible scrollbar
        scrollBar2.valueProperty().bindBidirectional(scrollBar1.valueProperty());
        scrollBar1.valueProperty().bindBidirectional(scrollBar2.valueProperty());
    }
     */
 /*
    * This method must be called in Application.start() after the stage is shown,
    * because the hidden scrollbars exist only when the tables are rendered
     */
 /*
    public void setScrollBarBinding() {
        bindScrollBars(this.tableMatchedFoundLuggage, this.tableMatchedLostLuggage, Orientation.VERTICAL);
    }*/
    /**
     *
     */
    public void loadFoundLuggage() {
        Connection conn = DBConnection.connectDb();
        foundLuggageData = FXCollections.observableArrayList();

        try {
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT l.luggageID, labelID, fl.flightID, airport, lostAndFoundID, destination, type, brand, color, date\n"
                    + "FROM luggage l INNER JOIN foundluggage f ON f.luggageID=l.luggageID INNER JOIN flight fl ON l.flightID=fl.flightID;");
            // string from database
            while (rs.next()) {
                foundLuggageData.add(new FoundLuggage(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), "kek"));
                //TODO status
            }

            conn.close();

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        this.columnFoundLabelnumber.setCellValueFactory(new PropertyValueFactory<>("labelNumber"));
        this.columnFoundAirport.setCellValueFactory(new PropertyValueFactory<>("airport"));
        this.columnFoundFlightnumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        this.columnLostFound.setCellValueFactory(new PropertyValueFactory<>("lostFoundID"));
        this.columnFoundDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        this.columnFoundType.setCellValueFactory(new PropertyValueFactory<>("type"));
        this.columnFoundBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        this.columnFoundColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        this.columnFoundDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.columnFoundStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableFoundLuggage.setItems(null);
        tableFoundLuggage.setItems(foundLuggageData);

    }

    public void loadLostLuggage() {
        Connection conn = DBConnection.connectDb();
        lostLuggageData = FXCollections.observableArrayList();

        try {
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT lug.luggageID, labelID, fli.flightID, airport, destination, type, brand, color, date\n"
                    + "FROM luggage lug INNER JOIN lostluggage los ON los.luggageID=lug.luggageID INNER JOIN flight fli ON lug.flightID=fli.flightID;");
            // string from database
            while (rs.next()) {
                lostLuggageData.add(new LostLuggage(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), "kek"));
                //TODO status
            }

            conn.close();

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        this.columnLostLabelnumber.setCellValueFactory(new PropertyValueFactory<>("labelNumber"));
        this.columnLostAirport.setCellValueFactory(new PropertyValueFactory<>("airport"));
        this.columnLostFlightnumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        this.columnLostDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        this.columnLostType.setCellValueFactory(new PropertyValueFactory<>("type"));
        this.columnLostBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        this.columnLostColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        this.columnLostDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.columnLostStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableLostLuggage.setItems(null);
        tableLostLuggage.setItems(lostLuggageData);
    }

    public void matchLuggage(Luggage selectedLuggage) {

        Connection conn = DBConnection.connectDb();

        String luggageID = selectedLuggage.getLuggageID();

        try {
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT luggageID FROM luggage WHERE luggageID=(\n"
                    + "SELECT b.luggageID FROM luggage a INNER JOIN luggage b ON\n"
                    + "a.flightID=b.flightID\n"
                    + "OR a.labelID=b.labelID\n"
                    + "WHERE a.luggageID=" + luggageID + " AND NOT b.luggageID=" + luggageID + "\n"
                    + "AND a.type=b.type\n"
                    + "AND a.brand=b.brand\n"
                    + "AND a.color=b.color);"
            );
            if (rs.next()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Match");//ripe for translation
                alert.setHeaderText(null);
                alert.setContentText(rs.getString(1));//ripe for translation
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No matches");//ripe for translation
                alert.setHeaderText(null);
                alert.setContentText("No matches have been found.");//ripe for translation
                alert.showAndWait();
            }

            conn.close();

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

    }

    /**This method opens the AddLuggage screen.
     * Depening on the arguments, the screen will be in 'add' or 'edit', 'found' or 'lost' modes.
     * @param editLuggage 
     * @param addMode
     * @param foundMode
     */
    private void showAddLuggage(Luggage editLuggage, Passenger editPassenger, boolean addMode, boolean foundMode) {
        /* Load the add/edit screen.
        First the FXML file is loaded and then a new Stage is made (a window) and shown.
        The initData method passes the arguments to the controller.
         */
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddLuggage.fxml"));

        Stage stage = new Stage();
        try {
            stage.setScene(new Scene((Pane) loader.load()));
            loader.<AddLuggageController>getController().initData(editLuggage, editPassenger, addMode, foundMode);
            stage.titleProperty().bind(I18N.createStringBinding(I18N.PROGRAM_NAME_KEY, (Object[]) null));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AccountManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * maybe if Lost and Found need seperate methods.
     *
     */
    private void showAddLostLuggage() {

    }

    /**
     * Check if the table has a selected item.
     *
     * @param table The tableView to check.
     * @return true if there is a selection, false otherwise.
     */
    private boolean isTableSelection(TableView table) {
        return (table.getSelectionModel().getSelectedItem() != null);
    }
}
