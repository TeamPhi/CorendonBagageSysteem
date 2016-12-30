package ui;

import backend.Account;
import backend.DBConnection;
import backend.FoundLuggage;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    
//    @FXML
//    private void save(ActionEvent event) {
//        //if all fields are filled in correctly.
//        if (this.textFieldTime.getText().isEmpty() == false
//                || this.textFieldLostFound.getText().isEmpty() == false
//                || this.textFieldAirport.getText().isEmpty() == false
//                || this.textFieldBrand.getText().isEmpty() == false
//                || this.textFieldColor.getText().isEmpty() == false
//                || this.textFieldDate.getText().isEmpty() == false) {
//                //create account object from textfields.
//                FoundLuggage temp = new FoundLuggage(
//                        this.textFieldLabelId.getText(),
//                        this.textFieldFlightId.getText(),
//                        this.textFieldAirport.getText(),
//                        this.textFieldLostFound.getText(),
//                        this.textFieldDestination.getText(),
//                        this.textFieldType.getText(),
//                        this.textFieldBrand.getText(),
//                        this.textFieldColor.getText(),
//                        this.textFieldDate.getText(),
//                        this.textFieldStatus.getText());
//                //create DB connection.
//                Connection conn = DBConnection.connectDb();
//                try {
//                    ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM account WHERE username = \'"
//                            + temp.getUsername() + "\';");
//                    /*
//                First check if the user made an original username.
//                     */
//                    int counter = 0;
//                    while (rs.next()) {
//                        counter++;
//                    }
//                    if (counter < 1) {
//                        /*
//                    Depending whether the user is editing an account or adding one,
//                    add or replace the temp account in the database.
//                         */
//                        if (this.addMode) {
//
//                            String sql = "INSERT INTO lostluggage (userid, username, password,"
//                                    + " privilege, name, surname, email)"
//                                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
//                            PreparedStatement pst = conn.prepareStatement(sql);
//                            
//                            pst.setString(1, this.textFieldLabelId.getText());
//                            pst.setString(2, this.textFieldFlightId.getText());
//                            pst.setString(3, this.textFieldAirport.getText());
//                            pst.setString(4, this.textFieldLostFound.getText());
//                            pst.setString(5, this.textFieldDestination.getText());
//                            pst.setString(6, this.textFieldType.getText());
//                            pst.setString(7, this.textFieldBrand.getText());
//                            pst.setString(8, this.textFieldColor.getText());
//                            pst.setString(9, this.textFieldDate.getText());
//                            pst.setString(10, this.textFieldStatus.getText());
//                            pst.executeUpdate();
//
//                            //if the data is put in the database, add it to the tableview.
//                            //AccountManagerController.accountData.add(temp);
//
//                        } else {
//
//                            String sql = "UPDATE account SET username = ?, password = ?,"
//                                    + " privilege = ?, name = ?, surname = ?, email = ? "
//                                    + "WHERE userid = ?";
//                            PreparedStatement pst = conn.prepareStatement(sql);
//                            pst.setString(1, this.textFieldLabelId.getText());
//                            pst.setString(2, this.textFieldFlightId.getText());
//                            pst.setString(3, this.textFieldAirport.getText());
//                            pst.setString(4, this.textFieldLostFound.getText());
//                            pst.setString(5, this.textFieldDestination.getText());
//                            pst.setString(6, this.textFieldType.getText());
//                            pst.setString(7, this.textFieldBrand.getText());
//                            pst.setString(8, this.textFieldColor.getText());
//                            pst.setString(9, this.textFieldDate.getText());
//                            pst.setString(10, this.textFieldStatus.getText());
//                            //preparedStatement.setInt(7, temp.getUserID);
//                            pst.executeUpdate();
//                            
//                            //replace the account in the table as well.
//                            //int replaceIndex = AccountManagerController.accountData.indexOf(this.editable);
//                            //AccountManagerController.accountData.remove(replaceIndex);
//                            //AccountManagerController.accountData.add(replaceIndex, temp);
//                            //AccountManagerController.accountData.add(temp);
//
//                        }
//                        //finally, close the window
//                        Stage stage = (Stage) this.buttonSave.getScene().getWindow();
//                        stage.close();
//                    } else {
//                        //error message
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setTitle("Registration failure");//ripe for translation
//                        alert.setHeaderText(null);
//                        alert.setContentText("The username already exists.");//ripe for translation
//                        alert.showAndWait();
//                    }
//                    conn.close();
//                } catch (SQLException ex) {
//                    System.err.println("Error" + ex);
//                }
//            } else {
//            //error message
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Registration failure");//ripe for translation
//            alert.setHeaderText(null);
//            alert.setContentText("One or more of the fields is empty.");//ripe for translation
//            alert.showAndWait();
//        }
    }
