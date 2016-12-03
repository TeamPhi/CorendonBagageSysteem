package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddFoundLuggageController implements Initializable{
 
    @FXML
    private TextField textFieldTime;

    @FXML
    private TextField textFieldLostFound;

    @FXML
    private TextField textFieldLabelId;

    @FXML
    private TextField textFieldAirport;

    @FXML
    private TextField textFieldDestination;

    @FXML
    private TextField textFieldFlightId;

    @FXML
    private TextField testFieldBrand;

    @FXML
    private TextField textFieldColor;

    @FXML
    private TextField textFieldType;

    @FXML
    private TextArea textFieldFeatures;

    @FXML
    private TextField textFieldDate;

    @FXML
    private TextField textFieldTravellerName;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    void sendDHL(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void saveData(ActionEvent event) {

    }

    @FXML
    void saveMatch(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {
        System.out.println("delete");

    }

}