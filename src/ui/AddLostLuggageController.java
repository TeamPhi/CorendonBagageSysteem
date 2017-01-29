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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
public class AddLostLuggageController implements Initializable {

    private static boolean textFieldDateIncorrectInput = false;
    private static boolean textFieldTimeIncorrectInput = false;
    private static boolean textFieldLabelIdIncorrectInput = false;
    private static boolean textFieldPhoneNumIncorrectInput = false;
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
    private Label labelOnlyNumericLuggageID;
    @FXML
    private Label labelOnlyNumericPhoneNum;
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
        I18N.bindText(this.buttonSave.getText(), this.buttonSave, (Object[]) null);
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
            //if (!textFieldTime.getText().matches("^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$")) {
            if (!textFieldTime.getText().matches("^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
                labelRequiredTimeFormat.setVisible(true);
                setTextFieldIndicatorBorder(textFieldTime, true);//odd
                textFieldTimeIncorrectInput = true;
            } else {
                labelRequiredTimeFormat.setVisible(false);
                setTextFieldIndicatorBorder(textFieldTime, false);
                textFieldTimeIncorrectInput = false;
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

    /**
     * Checks if the input in textFieldLabelId is correct and notifies the user
     * if it isn't
     *
     */
    private void textFieldPhoneNumInputChecker() {
        textFieldPhoneNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!textFieldPhoneNumber.getText().matches("\\d+")) {
                labelOnlyNumericPhoneNum.setVisible(true);
                setTextFieldIndicatorBorder(textFieldPhoneNumber, true);
                textFieldPhoneNumIncorrectInput = true;
            } else {
                labelOnlyNumericPhoneNum.setVisible(false);
                setTextFieldIndicatorBorder(textFieldPhoneNumber, false);
                textFieldPhoneNumIncorrectInput = false;
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
        if (this.isFilledCorrectly() && !textFieldDateIncorrectInput
                && !textFieldTimeIncorrectInput && !textFieldLabelIdIncorrectInput
                && !textFieldPhoneNumIncorrectInput) {
            
            LocalDate localDate = datePicker.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            
            Connection conn = DBConnection.connectDb();

            String SQL_INSERT_PASSAGER = "INSERT INTO `corendon_bagage`.`passager` (`naam`, `adres`, `woonplaats`, `postalcode`, `country`, `telephone`, `email`) \n"
                    + "VALUES ('" + this.textFieldName.getText() + "', '" + this.textFieldAddress.getText() + "', '" + this.textFieldCity.getText() + "', '" + this.textFieldZipcode.getText() + "',"
                    + " '" + this.textFieldCountry.getText() + "', '" + this.textFieldPhoneNumber.getText() + "', '" + this.textFieldEmail.getText() + "');";

            String SQL_INSERT_FLIGHT = "INSERT IGNORE INTO `corendon_bagage`.`flight` (`flightID`, `destination`) \n"
                    + "VALUES ('" + this.textFieldFlightId.getText() + "', '" + this.textFieldDestination.getText() + "');";

            String SQL_INSERT_LUGGAGE = "INSERT INTO `corendon_bagage`.`luggage` (`labelID`, `type`, `brand`, `color`, `features`, `passagerID`, `flightID`) \n"
                    + "VALUES ('" + this.textFieldLabelId.getText() + "', '" + this.textFieldType.getText() + "', '" + this.textFieldBrand.getText() + "', '" + this.textFieldColor.getText() + "',"
                    + " '" + this.textAreaFeatures.getText() + "', LAST_INSERT_ID(), '" + this.textFieldFlightId.getText() + "');";

            String SQL_INSERT_LUGGAGE_LOST = "INSERT INTO `corendon_bagage`.`lostluggage` (`luggageID`, `date`, `time`, `airport`) \n"
                    + "VALUES (LAST_INSERT_ID(), '" + DATE_FORMAT.format(date) + "', '" + this.textFieldTime.getText() + "', '" + this.textFieldAirport.getText() + "');";

            Boolean insertSucces = false;
            Statement statement;
            try {
                statement = conn.createStatement();

                statement.addBatch(SQL_INSERT_FLIGHT);
                statement.addBatch(SQL_INSERT_PASSAGER);
                statement.addBatch(SQL_INSERT_LUGGAGE);
                statement.addBatch(SQL_INSERT_LUGGAGE_LOST);

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
                && !textFieldTimeIncorrectInput && !textFieldLabelIdIncorrectInput
                && !textFieldPhoneNumIncorrectInput) {

            LocalDate localDate = datePicker.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            
            String SQL_INSERT_FLIGHT = "INSERT IGNORE INTO `corendon_bagage`.`flight` (`flightID`, `destination`) \n"
                    + "VALUES ('" + this.textFieldFlightId.getText() + "', '" + this.textFieldDestination.getText() + "');";

            String SQL_INSERT_PASSAGER = "UPDATE luggage lug\n"
                    + "JOIN passager pas ON lug.passagerID=pas.passagerID\n"
                    + "SET pas.naam='" + this.textFieldName.getText() + "', pas.adres='" + this.textFieldAddress.getText() + "', pas.woonplaats='" + this.textFieldCity.getText() + "', \n"
                    + "pas.postalcode='" + this.textFieldZipcode.getText() + "', pas.country='" + this.textFieldCountry.getText() + "', pas.telephone='" + this.textFieldPhoneNumber.getText() + "', pas.email='" + this.textFieldEmail.getText() + "' \n"
                    + "WHERE lug.luggageID='" + luggageID + "';";

            String SQL_INSERT_LUGGAGE = "UPDATE `corendon_bagage`.`luggage`\n"
                    + "SET labelID='" + this.textFieldLabelId.getText() + "', `type`='" + this.textFieldType.getText() + "', brand='" + this.textFieldBrand.getText() + "', color='" + this.textFieldColor.getText() + "', \n"
                    + "features='" + this.textAreaFeatures.getText() + "', flightID='" + this.textFieldFlightId.getText() + "'\n"
                    + "WHERE luggageID='" + luggageID + "';";
            //confusing name?
            String SQL_INSERT_LUGGAGE_FOUND = "UPDATE `corendon_bagage`.`lostluggage` \n"
                    + "SET `date`='" + DATE_FORMAT.format(date) + "', `time`='" + this.textFieldTime.getText() + "', airport='" + this.textFieldAirport.getText() + "'\n"
                    + "WHERE luggageID='" + luggageID + "';";

            Connection conn = DBConnection.connectDb();

            Boolean insertSucces = false;
            Statement statement;
            try {
                statement = conn.createStatement();

                statement.addBatch(SQL_INSERT_FLIGHT);
                statement.addBatch(SQL_INSERT_PASSAGER);
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
                + "los.date, los.time, los.airport, \n"
                + "lug.labelID, fli.flightID, fli.destination,\n"
                + "lug.type, lug.brand, lug.color, lug.features,\n"
                + "pas.naam, pas.adres, pas.woonplaats, pas.postalcode, pas.country,\n"
                + "pas.telephone, pas.email \n"
                + "FROM lostluggage los\n"
                + "	JOIN luggage lug ON los.luggageID=lug.luggageID \n"
                + "    JOIN passager pas ON lug.passagerID=pas.passagerID \n"
                + "    JOIN flight fli ON lug.flightID=fli.flightID\n"
                + "WHERE los.luggageID=" + luggageID + ";";

        try {
            ResultSet rs = conn.createStatement().executeQuery(SQL_SELECT_LUGGAGE);

            if (rs.next()) {
                //this.textFieldDate.setText(rs.getString(1));
                DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT_STRING);
                this.datePicker.setValue(LocalDate.parse(rs.getString(1), format));
                this.textFieldTime.setText(rs.getString(2));
                this.textFieldAirport.setText(rs.getString(3));

                this.textFieldLabelId.setText(rs.getString(4));
                this.textFieldFlightId.setText(rs.getString(5));
                this.textFieldDestination.setText(rs.getString(6));

                this.textFieldType.setText(rs.getString(7));
                this.textFieldBrand.setText(rs.getString(8));
                this.textFieldColor.setText(rs.getString(9));
                this.textAreaFeatures.setText(rs.getString(10));

                this.textFieldName.setText(rs.getString(11));
                this.textFieldAddress.setText(rs.getString(12));
                this.textFieldCity.setText(rs.getString(13));
                this.textFieldZipcode.setText(rs.getString(14));
                this.textFieldCountry.setText(rs.getString(15));
                this.textFieldPhoneNumber.setText(rs.getString(16));
                this.textFieldEmail.setText(rs.getString(17));
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
        check = this.isEmptyTextField(this.textFieldName, check);
        check = this.isEmptyTextField(this.textFieldAddress, check);
        check = this.isEmptyTextField(this.textFieldZipcode, check);
        check = this.isEmptyTextField(this.textFieldCity, check);
        check = this.isEmptyTextField(this.textFieldCountry, check);
        check = this.isEmptyTextField(this.textFieldPhoneNumber, check);
        check = this.isEmptyTextField(this.textFieldEmail, check);

        //REGEX
        //check = this.isEmptyTextField(this.textFieldDate, this.textFieldDate.getText().matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$"));
        check = this.isEmptyTextField(this.textFieldTime, this.textFieldTime.getText().matches("^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$"));
        check = this.isValidTextField(this.textFieldAirport, this.textFieldAirport.getText().matches("^.{0," + DBConnection.LENGTH_OF_AIRPORT + "}$"));

        check = this.isValidTextField(this.textFieldLabelId, this.textFieldLabelId.getText().matches("^[0-9]{1,}$"));
        check = this.isValidTextField(this.textFieldFlightId, this.textFieldFlightId.getText().matches("^.{0," + DBConnection.LENGTH_OF_FLIGHTID + "}$"));
        check = this.isValidTextField(this.textFieldDestination, this.textFieldDestination.getText().matches("^.{0," + DBConnection.LENGTH_OF_DESTINATION + "}$"));

        check = this.isEmptyTextField(this.textFieldType, this.textFieldType.getText().matches("^.{0," + DBConnection.LENGTH_OF_TYPE + "}$"));
        check = this.isValidTextField(this.textFieldBrand, this.textFieldBrand.getText().matches("^.{0," + DBConnection.LENGTH_OF_BRAND + "}$"));
        check = this.isEmptyTextField(this.textFieldColor, this.textFieldColor.getText().matches("^.{0," + DBConnection.LENGTH_OF_COLOR + "}$"));

        check = this.isEmptyTextField(this.textFieldName, this.textFieldName.getText().matches("^.{0," + DBConnection.LENGTH_OF_NAME + "}$"));
        check = this.isEmptyTextField(this.textFieldAddress, this.textFieldAddress.getText().matches("^.{0," + DBConnection.LENGTH_OF_ADDRESS + "}$"));
        check = this.isEmptyTextField(this.textFieldZipcode, this.textFieldZipcode.getText().matches("^.{0," + DBConnection.LENGTH_OF_ZIPCODE + "}$"));
        check = this.isEmptyTextField(this.textFieldCity, this.textFieldCity.getText().matches("^.{0," + DBConnection.LENGTH_OF_CITY + "}$"));
        check = this.isEmptyTextField(this.textFieldCountry, this.textFieldCountry.getText().matches("^.{0," + DBConnection.LENGTH_OF_COUNTRY + "}$"));
        check = this.isEmptyTextField(this.textFieldPhoneNumber, this.textFieldPhoneNumber.getText().matches("^.{0," + DBConnection.LENGTH_OF_TELEPHONE + "}$"));
        check = this.isEmptyTextField(this.textFieldEmail, this.textFieldEmail.getText().matches("^.{0," + DBConnection.LENGTH_OF_EMAIL + "}$"));

        if (!check) {
            //error message
            UIClass.showPopup("errorRegistrationTitle", "errorEmptyFieldsDesc");
            return check;
        } else {
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

    public void setEdit(boolean edit) {
        this.edit = edit;
        //textFieldDateInputChecker();
        textFieldTimeInputChecker();
        textFieldLabelIDInputChecker();
        textFieldPhoneNumInputChecker();
    }

    public void setLuggageID(String luggageID) {
        this.luggageID = luggageID;
        //textFieldDateInputChecker();
        //textFieldTimeInputChecker();
        //textFieldLabelIDInputChecker();
        //textFieldPhoneNumInputChecker();
    }

}
