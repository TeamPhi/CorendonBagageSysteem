/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Atori
 */
public class AddFoundLuggageController implements Initializable {

    @FXML
    private TextField textFieldDate;
    @FXML
    private TextField textFieldTime;
    @FXML
    private TextField textFieldAirport;
    @FXML
    private TextField textFieldLostFound;
    @FXML
    private TextField textFieldLabelId;
    @FXML
    private TextField textFieldFlightId;
    @FXML
    private TextField textFieldDestination;
    @FXML
    private TextField textFieldTravellerName;
    @FXML
    private TextField textFieldType;
    @FXML
    private TextField testFieldBrand;
    @FXML
    private TextField textFieldColor;
    @FXML
    private TextArea textFieldFeatures;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendDHL(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void saveData(ActionEvent event) {
    }

    @FXML
    private void saveMatch(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }
    
}
