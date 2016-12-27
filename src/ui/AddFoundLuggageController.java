package ui;

import backend.FoundLuggage;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddFoundLuggageController implements Initializable {

    @FXML
    private Label labelHeader;
    @FXML
    private Label labelDate;
    @FXML
    private Label labelTime;
    @FXML
    private Label labelAirport;
    @FXML
    private Label labelLAFID;
    @FXML
    private Label labelFlightHeader;
    @FXML
    private Label labelLabelID;
    @FXML
    private Label labelFlighID;
    @FXML
    private Label labelName;
    @FXML
    private Label labelDestination;
    @FXML
    private Label labelLuggageHeader;
    @FXML
    private Label labelType;
    @FXML
    private Label labelBrand;
    @FXML
    private Label labelColor;
    @FXML
    private Label labelFeatures;
    @FXML
    private Label labelStatus;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonDelete;//might be pointless
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonSaveMatch;
    @FXML
    private Button buttonSend;
    @FXML
    private Button buttonAddMore;
    @FXML
    private Button buttonMatchSave;
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
    private TextField textFieldBrand;
    @FXML
    private TextField textFieldColor;
    @FXML
    private TextField textFieldDate;
    @FXML
    private TextField textFieldTravellerName;
    @FXML
    private TextField testFieldBrand;
    @FXML
    private TextField textFieldType;
    @FXML
    private TextField textFieldStatus;
    @FXML
    private TextArea textAreaFeatures;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //The send button should be disabled by default.
        this.buttonSend.disableProperty().set(true);
        this.buttonSend.visibleProperty().set(false);
    }

    public FoundLuggage makeFoundLuggage() {
        FoundLuggage foundLuggage;
        foundLuggage = new FoundLuggage(this.textFieldLabelId.getText(), this.textFieldFlightId.getText(), this.textFieldDestination.getText(),
                this.textFieldType.getText(), this.textFieldBrand.getText(), this.textFieldColor.getText(), this.textFieldLostFound.getText(),
                this.textFieldDate.getText(), this.textFieldStatus.getText(), null);
        return foundLuggage;
    }

    void sendDHL(ActionEvent event) {

    }

    void cancel(ActionEvent event) {
        Stage stage = (Stage) this.buttonCancel.getScene().getWindow();
        stage.close();
    }

    void saveData(ActionEvent event) {
        LuggageListController.foundLuggageData.add(makeFoundLuggage());
        Stage stage = (Stage) this.buttonSave.getScene().getWindow();
        stage.close();
    }

    void saveMatch(ActionEvent event) {
        LuggageListController.foundLuggageData.add(makeFoundLuggage());
        //MATCH
        Stage stage = (Stage) this.buttonSaveMatch.getScene().getWindow();
        stage.close();
    }

    @FXML
    void delete(ActionEvent event) {
        //System.out.println("delete"); COMPLETE 

    }
}
