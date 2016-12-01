package ui;

import backend.Luggage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
/**
 * FXML 
 * 
 * @author Elwin Slokker
 */
public class LuggageListController implements Initializable{

    @FXML
    private Tab tabFound;
    @FXML
    private TableView<Luggage> tableFoundLuggage;
    @FXML
    private TableColumn<Luggage, String> columnFoundLabelnumber;
    @FXML
    private TableColumn<Luggage, String> columnFoundAirport;
    @FXML
    private TableColumn<Luggage, String> columnFoundFlightnumber;
    @FXML
    private TableColumn<Luggage, String> columnFoundDestination;
    @FXML
    private TableColumn<Luggage, String> columnFoundType;
    @FXML
    private TableColumn<Luggage, String> columnFoundBrand;
    @FXML
    private TableColumn<Luggage, String> columnFoundColor;
    @FXML
    private TableColumn<Luggage, String> columnFoundDate;
    @FXML
    private TableColumn<Luggage, String> columnFoundStatus;
    @FXML
    private Tab tabLost;
    @FXML
    private TableView<?> tableLostLuggage;
    @FXML
    private TableColumn<?, ?> columnLostLabelnumber;
    @FXML
    private TableColumn<?, ?> columnLostAirport;
    @FXML
    private TableColumn<?, ?> columnLostFlightnumber;
    @FXML
    private TableColumn<?, ?> columnLostDestination;
    @FXML
    private TableColumn<?, ?> columnLostType;
    @FXML
    private TableColumn<?, ?> columnLostBrand;
    @FXML
    private TableColumn<?, ?> columnLostColor;
    @FXML
    private TableColumn<?, ?> columnLostDate;
    @FXML
    private TableColumn<?, ?> columnLostStatus;
    @FXML
    private Tab tabMatches;
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
