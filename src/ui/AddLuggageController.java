package ui;

import backend.DBConnection;
import backend.FoundLuggage;
import backend.I18N;
import backend.LostLuggage;
import backend.Luggage;
import backend.Passenger;
import backend.UIClass;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

/**
 * FXML Controller class
 *
 * @author Elwin Slokker
 * @author Jordy Quak
 */
public class AddLuggageController implements Initializable {

    private boolean addMode;
    private boolean foundMode;
    private Luggage editableLuggage = null;
    private Passenger editablePassenger = null;
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
    private Label labelFlightID;
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
    private Label labelPassengerHeader;
    @FXML
    private Label labelName;
    @FXML
    private Label labelAddress;
    @FXML
    private Label labelCity;
    @FXML
    private Label labelZipcode;
    @FXML
    private Label labelCountry;
    @FXML
    private Label labelPhoneNumber;
    @FXML
    private Label labelEmail;

    @FXML
    private TextField textFieldTime;
    @FXML
    private TextField textFieldLAFID;
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
    private TextField textFieldType;
    @FXML
    private TextField textFieldStatus;
    @FXML
    private TextArea textAreaFeatures;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldAddress;
    @FXML
    private TextField textFieldCity;
    @FXML
    private TextField textFieldZipcode;
    @FXML
    private TextField textFieldCountry;
    @FXML
    private TextField textFieldPhoneNumber;
    @FXML
    private TextField textFieldEmail;

    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonSend;
    @FXML
    private Button buttonAddMore;
    @FXML
    private Button buttonMatchSave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //The send button should be disabled by default.
        this.buttonSend.disableProperty().set(true);
        this.buttonSend.visibleProperty().set(false);
        
        I18N.bindText(this.labelDate.getText(), this.labelDate, (Object[]) null);
        I18N.bindText(this.labelTime.getText(), this.labelTime, (Object[]) null);
        I18N.bindText(this.labelAirport.getText(), this.labelAirport, (Object[]) null);
        I18N.bindText(this.labelLAFID.getText(), this.labelLAFID, (Object[]) null);
        I18N.bindText(this.labelStatus.getText(), this.labelStatus, (Object[]) null);
        I18N.bindText(this.labelFlightHeader.getText(), this.labelFlightHeader, (Object[]) null);
        I18N.bindText(this.labelLabelID.getText(), this.labelLabelID, (Object[]) null);
        I18N.bindText(this.labelFlightID.getText(), this.labelFlightID, (Object[]) null);
        I18N.bindText(this.labelDestination.getText(), this.labelDestination, (Object[]) null);
        I18N.bindText(this.labelLuggageHeader.getText(), this.labelLuggageHeader, (Object[]) null);
        I18N.bindText(this.labelType.getText(), this.labelType, (Object[]) null);
        I18N.bindText(this.labelBrand.getText(), this.labelBrand, (Object[]) null);
        I18N.bindText(this.labelColor.getText(), this.labelColor, (Object[]) null);
        I18N.bindText(this.labelFeatures.getText(), this.labelFeatures, (Object[]) null);
        I18N.bindText(this.labelPassengerHeader.getText(), this.labelPassengerHeader, (Object[]) null);
        I18N.bindText(this.labelName.getText(), this.labelName, (Object[]) null);
        I18N.bindText(this.labelAddress.getText(), this.labelAddress, (Object[]) null);
        I18N.bindText(this.labelCity.getText(), this.labelCity, (Object[]) null);
        I18N.bindText(this.labelZipcode.getText(), this.labelZipcode, (Object[]) null);
        I18N.bindText(this.labelCountry.getText(), this.labelCountry, (Object[]) null);
        I18N.bindText(this.labelPhoneNumber.getText(), this.labelPhoneNumber, (Object[]) null);
        I18N.bindText(this.labelEmail.getText(), this.labelEmail, (Object[]) null);
        I18N.bindText(this.buttonSend.getText(), this.buttonSend, (Object[]) null);
        I18N.bindText(this.buttonCancel.getText(), this.buttonCancel, (Object[]) null);
        I18N.bindText(this.buttonMatchSave.getText(), this.buttonMatchSave, (Object[]) null);
        I18N.bindText(this.buttonSave.getText(), this.buttonSave, (Object[]) null);
        I18N.bindText(this.buttonAddMore.getText(), this.buttonAddMore, (Object[]) null);
       
        
        
    }

    @FXML
    private void cancel(ActionEvent event) {
        //useless beacause of the x button?
        Stage stage = (Stage) this.buttonCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void saveRegular(ActionEvent event) {
        if (this.save()) {
            Stage stage = (Stage) this.buttonSave.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    private void saveAndMatch(ActionEvent event) {
        if (this.save()) {
            //MATCH
            Stage stage = (Stage) this.buttonMatchSave.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    private void saveAndContinue(ActionEvent event) {
        if (this.save()) {
            //empty all luggage information so the user can start a new luggage registration.
            this.textFieldBrand.setText("");
            this.textFieldType.setText("");
            this.textFieldTime.setText("");
            this.textFieldDate.setText("");
            this.textFieldLabelId.setText("");
            this.textFieldFlightId.setText("");
            this.textFieldColor.setText("");
            this.textFieldStatus.setText("");
            this.textFieldLAFID.setText("");
            this.textFieldAirport.setText("");
            this.textFieldDestination.setText("");
            this.textAreaFeatures.setText("");
        }
    }

    @FXML
    private void sendDHL(ActionEvent event) {

    }

    /**
     * Save the data from the form (in the database and in the table).
     *
     * @return true if the data was put in the database and written to the table
     * correctly.
     */
    private boolean save() {
        boolean passed = true;
        if (this.isFilledCorrectly()) {
            Connection conn = DBConnection.connectDb();
            try {
                if (this.foundMode) {
                    
                    String luggageID = "1";
                    //make FoundLuggage
                    FoundLuggage newLuggage = new FoundLuggage(
                            luggageID,
                            this.textFieldLabelId.getText(),
                            this.textFieldFlightId.getText(),
                            this.textFieldAirport.getText(),
                            this.textFieldLAFID.getText(),
                            this.textFieldDestination.getText(),
                            this.textFieldType.getText(),
                            this.textFieldBrand.getText(),
                            this.textFieldColor.getText(),
                            this.textFieldDate.getText(),
                            this.textFieldStatus.getText());
                    if (this.addMode) {
                        /*
                        SQL INSERT INTO statement
                        IT Does not work yet.
                         */
                        /*
                        String sql = "INSERT INTO foundluggage (userid, username, password,"
                                + " privilege, name, surname, email)"
                                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, this.textFieldLabelId.getText());
                        preparedStatement.setString(2, this.textFieldFlightId.getText());
                        preparedStatement.setString(3, this.textFieldAirport.getText());
                        preparedStatement.setString(4, this.textFieldLAFID.getText());
                        preparedStatement.setString(5, this.textFieldDestination.getText());
                        preparedStatement.setString(6, this.textFieldType.getText());
                        preparedStatement.setString(7, this.textFieldBrand.getText());
                        preparedStatement.setString(8, this.textFieldColor.getText());
                        preparedStatement.setString(9, this.textFieldDate.getText());
                        preparedStatement.setString(10, this.textFieldStatus.getText());
                        preparedStatement.executeUpdate();
                        */
                        //if the data is put in the database, add it to the tableview.
                        LuggageListController.foundLuggageData.add(newLuggage);

                    } else {//edit mode
                        /*
                        SQL UPDATE statement
                        Does not work yet.
                         */
                        String sql = "UPDATE foundLuggage SET username = ?, password = ?,"
                                + " privilege = ?, name = ?, surname = ?, email = ? "
                                + "WHERE userid = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, this.textFieldLabelId.getText());
                        preparedStatement.setString(2, this.textFieldFlightId.getText());
                        preparedStatement.setString(3, this.textFieldAirport.getText());
                        preparedStatement.setString(4, this.textFieldLAFID.getText());
                        preparedStatement.setString(5, this.textFieldDestination.getText());
                        preparedStatement.setString(6, this.textFieldType.getText());
                        preparedStatement.setString(7, this.textFieldBrand.getText());
                        preparedStatement.setString(8, this.textFieldColor.getText());
                        preparedStatement.setString(9, this.textFieldDate.getText());
                        preparedStatement.setString(10, this.textFieldStatus.getText());
                        preparedStatement.executeUpdate();
                        //if the data is replaced in the database, also replace it in the tableview.
                        int replaceIndex = LuggageListController.foundLuggageData.indexOf(this.editableLuggage);
                        LuggageListController.foundLuggageData.remove(replaceIndex);
                        LuggageListController.foundLuggageData.add(replaceIndex, newLuggage);
                        //LuggageListController.foundLuggageData.get(LuggageListController.foundLuggageData.indexOf(this.editableLuggage)).setLabelNumber(this.textFieldLabelId.getText());
                    }

                } else {//lost mode
                    //make LostLuggge
                    LostLuggage newLuggage = new LostLuggage(
                            "1",
                            this.textFieldLabelId.getText(),
                            this.textFieldFlightId.getText(),
                            this.textFieldAirport.getText(),
                            this.textFieldDestination.getText(),
                            this.textFieldType.getText(),
                            this.textFieldBrand.getText(),
                            this.textFieldColor.getText(),
                            this.textFieldDate.getText(),
                            this.textFieldStatus.getText());
                    if (this.addMode) {
                        /*
                    SQL INSERT INTO statement
                         */
                        LuggageListController.lostLuggageData.add(newLuggage);
                    } else {//edit mode
                        /*
                    SQL UPDATE statement
                         */
                        int replaceIndex = LuggageListController.lostLuggageData.indexOf(this.editableLuggage);
                        LuggageListController.lostLuggageData.remove(replaceIndex);
                        LuggageListController.lostLuggageData.add(replaceIndex, newLuggage);
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                passed = false;
                System.err.println("Error" + ex);
            }
        } else {
            passed = false;
        }
        return passed;
    }

    /**
     * A method that is called after the initialisation.
     *
     * @param editLuggage The luggage that needs to be edited.
     * @param editPassenger The passenger information that needs to be edited.
     * @param addMode Whether the screen should be in add (true) or edit mode.
     * @param foundMode Whether the screen should be in found (true) or lost
     * mode.
     */
    public void initData(Luggage editLuggage, Passenger editPassenger, boolean addMode, boolean foundMode) {
        this.addMode = addMode;
        this.foundMode = foundMode;
        this.editableLuggage = editLuggage;
        if (!foundMode) {
            //in the lost mode, there should be no Lost and Found ID.
            this.textFieldLAFID.disableProperty().set(true);
            this.textFieldLAFID.setVisible(false);
            this.labelLAFID.disableProperty().set(true);
            this.labelLAFID.setVisible(false);
            this.labelStatus.setLayoutY(this.labelStatus.getLayoutY() - 28.0);
            this.textFieldStatus.setLayoutY(this.textFieldStatus.getLayoutY() - 28.0);
            I18N.bindText("labelHeaderFound", this.labelHeader, (Object[]) null);
        }else{
            I18N.bindText("labelHeaderLost", this.labelHeader, (Object[]) null);
        }
        if (!addMode) {
            //add all editable information to the textFields
            //luggage information here.
            this.textFieldName.setText(editPassenger.getName());
            this.textFieldAddress.setText(editPassenger.getAddress());
            this.textFieldCity.setText(editPassenger.getCity());
            this.textFieldZipcode.setText(editPassenger.getZipcode());
            this.textFieldCountry.setText(editPassenger.getCountry());
            this.textFieldPhoneNumber.setText(String.valueOf(editPassenger.getPhoneNumber()));//WATCH OUT
            this.textFieldEmail.setText(editPassenger.getEmail());
        }
    }

    /**
     * Checks if all the right textfields contain data.
     *
     * @return Depending on the mode, true if all textFields are filled in,
     * false otherwise.
     */
    private boolean isFilledCorrectly() {
        boolean check = true;
        if (this.foundMode) {
            check = this.isEmptyTextField(this.textFieldTime, check);
            check = this.isEmptyTextField(this.textFieldDate, check);
            check = this.isEmptyTextField(this.textFieldType, check);
            check = this.isEmptyTextField(this.textFieldColor, check);
            check = this.isEmptyTextField(this.textFieldStatus, check);
            check = this.isEmptyTextField(this.textFieldLAFID, check);
        } else {
            check = this.isEmptyTextField(this.textFieldTime, check);
            check = this.isEmptyTextField(this.textFieldDate, check);
            check = this.isEmptyTextField(this.textFieldType, check);
            check = this.isEmptyTextField(this.textFieldColor, check);
            check = this.isEmptyTextField(this.textFieldStatus, check);
            check = this.isEmptyTextField(this.textFieldName, check);
            check = this.isEmptyTextField(this.textFieldAddress, check);
            check = this.isEmptyTextField(this.textFieldZipcode, check);
            check = this.isEmptyTextField(this.textFieldCity, check);
            check = this.isEmptyTextField(this.textFieldCountry, check);
        }
        if (!check) {
            //error message
            UIClass.showPopup("errorRegistrationTitle", "errorEmptyFieldsDesc");
            return check;
        } else {
            /*
            For all text fields, check if they do not contain too many characters.
            if(this.textFieldDate.getText().length() > 45){
                this.setTextFieldIndicatorBorder(this.textFieldDate, check)
                check = false;
            }else{
                this.setTextFieldIndicatorBorder(this.textFieldDate, !check)
            }
             */
        }
        if (!check) {
            UIClass.showPopup("errorRegistrationTitle", "errorTooManyCharsDesc");
        }
        return check;

    }

    /**
     * Might be replaced to some utility class.
     *
     * @return
     */
    private boolean isEmptyTextField(TextField textField, boolean check) {
        if (!check) {
            if (textField.getText().isEmpty()) {
                this.setTextFieldIndicatorBorder(textField, true);
            } else {
                this.setTextFieldIndicatorBorder(textField, false);
            }
        } else {
            if (textField.getText().isEmpty()) {
                check = false;
            } else {
                check = true;
            }
            this.setTextFieldIndicatorBorder(textField, !check);
        }

        return check;
    }

    /**
     * Could also be a utility class.
     *
     * @param textField
     * @param indicatorNeeded
     */
    private void setTextFieldIndicatorBorder(TextField textField, boolean indicatorNeeded) {
        if (indicatorNeeded) {
            textField.setStyle("-fx-border-color: red");
        } else {
            textField.setStyle("-fx-border-color: darkgrey");
        }
    }
    /*
    It would be nice to have a utility method that checks if a textField contains more characters than
    the database can handle....
    private boolean isTextTooLong(TextField textField, boolean check){
        
        return false;
    }
     */
 /*
    Useless method.
    private FoundLuggage makeFoundLuggage() {
        return new FoundLuggage(this.textFieldLabelId.getText(), this.textFieldFlightId.getText(), this.textFieldDestination.getText(),
                this.textFieldType.getText(), this.textFieldBrand.getText(), this.textFieldColor.getText(), this.textFieldLAFID.getText(),
                this.textFieldDate.getText(), this.textFieldStatus.getText(), null);
    }
     */
}
