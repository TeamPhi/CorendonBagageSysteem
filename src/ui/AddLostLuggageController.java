/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import backend.DBConnection;
import backend.I18N;
import backend.UIClass;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
        
        this.buttonSend.disableProperty().set(true);
        this.buttonSend.visibleProperty().set(false);
        
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
        I18N.bindText(this.buttonMatchSave.getText(), this.buttonMatchSave, (Object[]) null);
        I18N.bindText(this.buttonSave.getText(), this.buttonSave, (Object[]) null);
        I18N.bindText(this.buttonAddMore.getText(), this.buttonAddMore, (Object[]) null);
        
    }
    
    public void AddLostLuggageController(LuggageListController luggageListController){
        
    }

    @FXML
    private void saveRegular(ActionEvent event) {
        try {
            save();
        } catch (SQLException ex) {
            Logger.getLogger(AddLostLuggageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void saveAndMatch(ActionEvent event) { 
        //FOR TESTING PURPOSES//
        System.out.println(this.textFieldDate.getText());
    }

    @FXML
    private void saveAndContinue(ActionEvent event) {
        
    }
    
    private void save() throws SQLException{
        
        if (this.isFilledCorrectly()) {
        
            Connection conn = DBConnection.connectDb();

            String SQL_INSERT_PASSAGER = "INSERT INTO `corendon_bagage`.`passager` (`naam`, `adres`, `woonplaats`, `postalcode`, `country`, `telephone`, `email`) \n" +
    "VALUES ('" + this.textFieldName.getText() + "', '" + this.textFieldAddress.getText() + "', '" + this.textFieldCity.getText() + "', '" + this.textFieldZipcode.getText() + "',"
                    + " '" + this.textFieldCountry.getText() + "', '" + this.textFieldPhoneNumber.getText() + "', '" + this.textFieldEmail.getText() + "');";

            String SQL_INSERT_FLIGHT = "INSERT IGNORE INTO `corendon_bagage`.`flight` (`flightID`, `destination`) \n" +
    "VALUES ('" + this.textFieldFlightId.getText() + "', '" + this.textFieldDestination.getText() + "');";

            String SQL_INSERT_LUGGAGE = "INSERT INTO `corendon_bagage`.`luggage` (`labelID`, `type`, `brand`, `color`, `features`, `passagerID`, `flightID`) \n" +
    "VALUES ('" + this.textFieldLabelId.getText() + "', '" + this.textFieldType.getText() + "', '" + this.textFieldBrand.getText() + "', '" + this.textFieldColor.getText() + "',"
                    + " '" + this.textAreaFeatures.getText() + "', LAST_INSERT_ID(), '" + this.textFieldFlightId.getText() + "');";

            String SQL_INSERT_LUGGAGE_LOST = "INSERT INTO `corendon_bagage`.`lostluggage` (`luggageID`, `date`, `time`, `airport`) \n" +
    "VALUES (LAST_INSERT_ID(), '" + this.textFieldDate.getText() + "', '" + this.textFieldTime.getText() + "', '" + this.textFieldAirport.getText() + "');";

            Statement statement = conn.createStatement();

            statement.addBatch(SQL_INSERT_FLIGHT);
            statement.addBatch(SQL_INSERT_PASSAGER);
            statement.addBatch(SQL_INSERT_LUGGAGE);
            statement.addBatch(SQL_INSERT_LUGGAGE_LOST);

            statement.executeBatch();

            conn.close();
        
        }
        
    }
    
    public void fillFields(int luggageID) throws SQLException{
        
        Connection conn = DBConnection.connectDb();
        
        String SQL_SELECT_LUGGAGE = "SELECT \n" +
            "los.date, los.time, los.airport, \n" +
            "lug.labelID, fli.flightID, fli.destination,\n" +
            "lug.type, lug.brand, lug.color, lug.features,\n" +
            "pas.naam, pas.adres, pas.woonplaats, pas.postalcode, pas.country,\n" +
            "pas.telephone, pas.email \n" +
            "FROM lostluggage los\n" +
            "	JOIN luggage lug ON los.luggageID=lug.luggageID \n" +
            "    JOIN passager pas ON lug.passagerID=pas.passagerID \n" +
            "    JOIN flight fli ON lug.flightID=fli.flightID\n" +
        "WHERE los.luggageID=" + luggageID + ";";
        
         try {
            ResultSet rs = conn.createStatement().executeQuery(SQL_SELECT_LUGGAGE);
            
            if(rs.next()){
                this.textFieldDate.setText(rs.getString(1));
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
       
        
        Statement statement = conn.createStatement();
        
        statement.addBatch(SQL_SELECT_LUGGAGE);
        
        statement.executeBatch();
        
        conn.close();
        
    }
    
    
    private boolean isFilledCorrectly() {
        boolean check = true;
        check = this.isEmptyTextField(this.textFieldTime, check);
        check = this.isEmptyTextField(this.textFieldDate, check);
        check = this.isEmptyTextField(this.textFieldType, check);
        check = this.isEmptyTextField(this.textFieldColor, check);
        check = this.isEmptyTextField(this.textFieldName, check);
        check = this.isEmptyTextField(this.textFieldAddress, check);
        check = this.isEmptyTextField(this.textFieldZipcode, check);
        check = this.isEmptyTextField(this.textFieldCity, check);
        check = this.isEmptyTextField(this.textFieldCountry, check);
        
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
    
    private void setTextFieldIndicatorBorder(TextField textField, boolean indicatorNeeded) {
        if (indicatorNeeded) {
            textField.setStyle("-fx-border-color: red");
        } else {
            textField.setStyle("-fx-border-color: darkgrey");
        }
    }


}
