package ui;

import backend.DBConnection;
import backend.I18N;
import backend.UIClass;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Atori
 */
public class AddFoundLuggageController implements Initializable {

    private static boolean textFieldDateIncorrectInput = false;
    private static boolean textFieldTimeIncorrectInput = false;
    private static boolean textFieldLAFIDIncorrectInput = false;
    private static boolean textFieldLabelIdIncorrectInput = false;
    private static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STRING);

    private boolean edit = true;
    private String luggageID = "1";

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
    private Label labelName;
    @FXML
    private Label labelOnlyNumericLAFID;
    @FXML
    private Label labelOnlyNumericLuggageID;
    @FXML
    private Label labelRequiredTimeFormat;

    @FXML
    private DatePicker datePicker;
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
    private TextField textFieldType;
    @FXML
    private TextField textFieldStatus;
    @FXML
    private TextArea textAreaFeatures;
    @FXML
    private TextField textFieldName;

    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonSend;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.buttonSend.disableProperty().set(true);
        this.buttonSend.visibleProperty().set(false);
        this.textFieldStatus.disableProperty().set(true);
        this.textFieldStatus.visibleProperty().set(false);
        this.labelStatus.disableProperty().set(true);
        this.labelStatus.visibleProperty().set(false);
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
        I18N.bindText(this.labelName.getText(), this.labelName, (Object[]) null);

        I18N.bindText(this.buttonSend.getText(), this.buttonSend, (Object[]) null);
        I18N.bindText(this.buttonCancel.getText(), this.buttonCancel, (Object[]) null);
        I18N.bindText(this.buttonSave.getText(), this.buttonSave, (Object[]) null);
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
        //textFieldDateInputChecker();
        textFieldTimeInputChecker();
        textFieldLAFIDInputChecker();
        textFieldLabelIDInputChecker();
    }

    public void setLuggageID(String luggageID) {
        this.luggageID = luggageID;
        //textFieldDateInputChecker();
        textFieldTimeInputChecker();
        textFieldLAFIDInputChecker();
        textFieldLabelIDInputChecker();
    }

    @FXML
    private void cancel(ActionEvent event) {
        //useless beacause of the x button?
        Stage stage = (Stage) this.buttonCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * Checks if the input in textFieldTime is correct and notifies the user if
     * it isn't
     *
     */
    private void textFieldTimeInputChecker() {
        textFieldTime.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!textFieldTime.getText().matches("^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
                labelRequiredTimeFormat.setVisible(true);
                setTextFieldIndicatorBorder(textFieldTime, true);
                textFieldTimeIncorrectInput = true;
            } else {
                labelRequiredTimeFormat.setVisible(false);
                setTextFieldIndicatorBorder(textFieldTime, false);
                textFieldTimeIncorrectInput = false;
            }
        });
    }

    /**
     * Checks if the input in TextFieldLAFID is correct and notifies the user if
     * it isn't
     *
     */
    private void textFieldLAFIDInputChecker() {
        textFieldLAFID.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!textFieldLAFID.getText().matches("[0-9]+")) {
                labelOnlyNumericLAFID.setVisible(true);
                setTextFieldIndicatorBorder(textFieldLAFID, true);
                textFieldLAFIDIncorrectInput = true;
            } else {
                labelOnlyNumericLAFID.setVisible(false);
                setTextFieldIndicatorBorder(textFieldLAFID, false);
                textFieldLAFIDIncorrectInput = false;
            }
        });
    }

    /**
     * Checks if the input in textFieldLabelId is correct and notifies the user
     * if it isn't
     *
     */
    private void textFieldLabelIDInputChecker() {
        textFieldLabelId.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!textFieldLabelId.getText().matches("\\d+")) {
                labelOnlyNumericLuggageID.setVisible(true);
                setTextFieldIndicatorBorder(textFieldLabelId, true);
                textFieldLabelIdIncorrectInput = true;
            } else {
                labelOnlyNumericLuggageID.setVisible(false);
                setTextFieldIndicatorBorder(textFieldLabelId, false);
                textFieldLabelIdIncorrectInput = false;
            }
        });
    }

    @FXML
    private void saveButtonClicked(ActionEvent event) {
        if (datePicker.getValue() == null) {
            this.datePicker.setStyle("-fx-border-color: red");
            UIClass.showPopup("errorRegistrationTitle", "errorIncorrectInput");
        } else {
            this.datePicker.setStyle("-fx-border-color: darkgrey");
            try {
                if (this.edit) {
                    edit(this.luggageID);
                } else {
                    save();
                }

            } catch (SQLException ex) {
                Logger.getLogger(AddLostLuggageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String save() throws SQLException {

        if (this.isFilledCorrectly() && !textFieldTimeIncorrectInput
                && !textFieldLAFIDIncorrectInput && !textFieldLabelIdIncorrectInput) {
            
            LocalDate localDate = datePicker.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);

            String SQL_INSERT_FLIGHT = "INSERT IGNORE INTO `corendon_bagage`.`flight` (`flightID`, `destination`) \n"
                    + "VALUES ('" + this.textFieldFlightId.getText() + "', '" + this.textFieldDestination.getText() + "');";

            String SQL_INSERT_LUGGAGE = "INSERT INTO `corendon_bagage`.`luggage` (`labelID`, `type`, `brand`, `color`, `features`, `flightID`, `lostAndFoundID`) \n"
                    + "VALUES ('" + this.textFieldLabelId.getText() + "', '" + this.textFieldType.getText() + "', '" + this.textFieldBrand.getText() + "', '" + this.textFieldColor.getText() + "',"
                    + " '" + this.textAreaFeatures.getText() + "', '" + this.textFieldFlightId.getText() + "', '" + this.textFieldLAFID.getText() + "');";

            String SQL_INSERT_LUGGAGE_FOUND = "INSERT INTO `corendon_bagage`.`foundluggage` (`luggageID`, `date`, `time`, `airport`, `passagerName`) \n"
                    + "VALUES (LAST_INSERT_ID(), '" + DATE_FORMAT.format(date) + "', '" + this.textFieldTime.getText() + "', '" + this.textFieldAirport.getText() + "', '" + this.textFieldName.getText() + "');";

            Connection conn = DBConnection.connectDb();

            Boolean insertSucces = false;
            Statement statement;
            try {
                statement = conn.createStatement();

                statement.addBatch(SQL_INSERT_FLIGHT);
                statement.addBatch(SQL_INSERT_LUGGAGE);
                statement.addBatch(SQL_INSERT_LUGGAGE_FOUND);

                statement.executeBatch();

                insertSucces = true;

            } catch (SQLException ex) {
                Logger.getLogger(AddLostLuggageController.class.getName()).log(Level.SEVERE, null, ex);
                insertSucces = false;
            }

            if (insertSucces) {
                conn.close();

                Stage stage = (Stage) this.buttonSave.getScene().getWindow();
                stage.close();

            }
            return "saved";
        } else {
            UIClass.showPopup("errorRegistrationTitle", "errorIncorrectInput");

        }
        return "saving failed";
    }

    private void edit(String luggageID) throws SQLException {
        if (this.isFilledCorrectly() && !textFieldDateIncorrectInput
                && !textFieldTimeIncorrectInput && !textFieldLAFIDIncorrectInput
                && !textFieldLabelIdIncorrectInput) {
            
            LocalDate localDate = datePicker.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            
            String SQL_INSERT_FLIGHT = "INSERT IGNORE INTO `corendon_bagage`.`flight` (`flightID`, `destination`) \n"
                    + "VALUES ('" + this.textFieldFlightId.getText() + "', '" + this.textFieldDestination.getText() + "');";

            String SQL_INSERT_LUGGAGE = "UPDATE `corendon_bagage`.`luggage`\n"
                    + "SET labelID='" + this.textFieldLabelId.getText() + "', `type`='" + this.textFieldType.getText() + "', brand='" + this.textFieldBrand.getText() + "', color='" + this.textFieldColor.getText() + "', \n"
                    + "features='" + this.textAreaFeatures.getText() + "', flightID='" + this.textFieldFlightId.getText() + "', lostAndFoundID='" + this.textFieldLAFID.getText() + "'\n"
                    + "WHERE luggageID='" + luggageID + "';";

            String SQL_INSERT_LUGGAGE_FOUND = "UPDATE `corendon_bagage`.`foundluggage` \n"
                    + "SET `date`='" + DATE_FORMAT.format(date) + "', `time`='" + this.textFieldTime.getText() + "', airport='" + this.textFieldAirport.getText() + "', passagerName='" + this.textFieldName.getText() + "'\n"
                    + "WHERE luggageID='" + luggageID + "';";

            Connection conn = DBConnection.connectDb();

            Boolean insertSucces = false;
            Statement statement;
            try {
                statement = conn.createStatement();

                statement.addBatch(SQL_INSERT_FLIGHT);
                statement.addBatch(SQL_INSERT_LUGGAGE);
                statement.addBatch(SQL_INSERT_LUGGAGE_FOUND);

                statement.executeBatch();

                insertSucces = true;

            } catch (SQLException ex) {
                Logger.getLogger(AddLostLuggageController.class.getName()).log(Level.SEVERE, null, ex);
                insertSucces = false;
            }

            if (insertSucces) {
                conn.close();

                Stage stage = (Stage) this.buttonSave.getScene().getWindow();
                stage.close();

            }
        } else {
            UIClass.showPopup("errorRegistrationTitle", "errorIncorrectInput");
        }
    }

    public void fillFields(String luggageID) throws SQLException {

        Connection conn = DBConnection.connectDb();

        String SQL_SELECT_LUGGAGE = "SELECT \n"
                + "fou.date, fou.time, fou.airport, lug.lostAndFoundID, \n"
                + "lug.labelID, fli.flightID, fli.destination, fou.passagerName,\n"
                + "lug.type, lug.brand, lug.color, lug.features\n"
                + "FROM foundluggage fou\n"
                + "	JOIN luggage lug ON fou.luggageID=lug.luggageID \n"
                + "   JOIN flight fli ON lug.flightID=fli.flightID\n"
                + "WHERE fou.luggageID=" + luggageID + ";";

        try {
            ResultSet rs = conn.createStatement().executeQuery(SQL_SELECT_LUGGAGE);

            if (rs.next()) {
                //this.textFieldDate.setText(rs.getString(1));
                DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT_STRING);
                this.datePicker.setValue(LocalDate.parse(rs.getString(1), format));
                this.textFieldTime.setText(rs.getString(2));
                this.textFieldAirport.setText(rs.getString(3));
                this.textFieldLAFID.setText(rs.getString(4));

                this.textFieldLabelId.setText(rs.getString(5));
                this.textFieldFlightId.setText(rs.getString(6));
                this.textFieldDestination.setText(rs.getString(7));
                this.textFieldName.setText(rs.getString(8));

                this.textFieldType.setText(rs.getString(9));
                this.textFieldBrand.setText(rs.getString(10));
                this.textFieldColor.setText(rs.getString(11));
                this.textAreaFeatures.setText(rs.getString(12));

            }

            conn.close();

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

    }

    private boolean isFilledCorrectly() {
        boolean check = true;
        check = this.isEmptyTextField(this.textFieldTime, check);
        //check = this.isEmptyTextField(this.textFieldDate, check);
        check = this.isEmptyTextField(this.textFieldType, check);
        check = this.isEmptyTextField(this.textFieldColor, check);
        check = this.isEmptyTextField(this.textFieldLAFID, check);

        //REGEX
        //check = this.isEmptyTextField(this.textFieldDate, this.textFieldDate.getText().matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$"));
        check = this.isEmptyTextField(this.textFieldTime, this.textFieldTime.getText().matches("^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$"));
        check = this.isValidTextField(this.textFieldAirport, this.textFieldAirport.getText().matches("^.{0," + DBConnection.LENGTH_OF_AIRPORT + "}$"));
        check = this.isEmptyTextField(this.textFieldLAFID, this.textFieldLAFID.getText().matches("^[0-9]{1,}$"));

        check = this.isValidTextField(this.textFieldLabelId, this.textFieldLabelId.getText().matches("^[0-9]{1,}$"));
        check = this.isValidTextField(this.textFieldFlightId, this.textFieldFlightId.getText().matches("^.{0," + DBConnection.LENGTH_OF_FLIGHTID + "}$"));
        check = this.isValidTextField(this.textFieldDestination, this.textFieldDestination.getText().matches("^.{0," + DBConnection.LENGTH_OF_DESTINATION + "}$"));
        check = this.isValidTextField(this.textFieldName, this.textFieldName.getText().matches("^.{0,4}$"));

        check = this.isEmptyTextField(this.textFieldType, this.textFieldType.getText().matches("^.{0," + DBConnection.LENGTH_OF_TYPE + "}$"));
        check = this.isValidTextField(this.textFieldBrand, this.textFieldBrand.getText().matches("^.{0," + DBConnection.LENGTH_OF_BRAND + "}$"));
        check = this.isEmptyTextField(this.textFieldColor, this.textFieldColor.getText().matches("^.{0," + DBConnection.LENGTH_OF_COLOR + "}$"));
        //check = this.isEmptyTextField(this.textAreaFeatures, this.textAreaFeatures.getText().matches("^.{1,4}$"));

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

    private boolean isEmptyTextField(TextField textField, boolean check) {
        if (!check) {
            if (textField.getText().isEmpty()) {
                this.setTextFieldIndicatorBorder(textField, true);
            } else {
                this.setTextFieldIndicatorBorder(textField, !check);
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

    private boolean isValidTextField(TextField textField, boolean check) {
        if (!check) {
            this.setTextFieldIndicatorBorder(textField, true);
        } else {
            this.setTextFieldIndicatorBorder(textField, !check);
        }

        return check;
    }

    private void setTextFieldIndicatorBorder(TextField textField, boolean indicatorNeeded) {
        if (indicatorNeeded) {
            textField.setStyle("-fx-border-color: red");
        } else {
            textField.setStyle("-fx-border-color: darkgrey");
        }
    }
}
