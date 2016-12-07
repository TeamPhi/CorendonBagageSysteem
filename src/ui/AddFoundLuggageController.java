package ui;

import backend.FoundLuggage;
import backend.LuggageEnum;
import backend.StatusEnum;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddFoundLuggageController implements Initializable{
 
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonSaveMatch;
    @FXML
    private Button buttonSend;
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
    private ComboBox comboBoxType;
    @FXML
    private TextArea textFieldFeatures;
    @FXML
    private TextField textFieldDate;
    @FXML
    private TextField textFieldTravellerName;
    @FXML
    private ComboBox comboBoxStatus;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.comboBoxType.setItems(FXCollections.observableArrayList(LuggageEnum.values()));
        this.comboBoxStatus.setItems(FXCollections.observableArrayList(StatusEnum.values()));
    }  
    public FoundLuggage makeFoundLuggage(){
        FoundLuggage foundLuggage;
        foundLuggage = new FoundLuggage(this.textFieldLabelId.getText(),this.textFieldFlightId.getText(), this.textFieldDestination.getText(),(LuggageEnum)this.comboBoxType.getValue(), this.textFieldBrand.getText(), this.textFieldColor.getText(), this.textFieldLostFound.getText(),new Date(this.textFieldDate.getText()),(StatusEnum) this.comboBoxStatus.getValue(), null);
        return foundLuggage;
    }
    @FXML
    void sendDHL(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage) this.buttonCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveData(ActionEvent event) {
        LuggageListController.foundLuggageData.add(makeFoundLuggage());
        Stage stage = (Stage) this.buttonSave.getScene().getWindow();
        stage.close();
    }

    @FXML
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