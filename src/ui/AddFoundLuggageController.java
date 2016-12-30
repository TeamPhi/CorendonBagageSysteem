package ui;

import backend.Account;
import backend.DBConnection;
import backend.FoundLuggage;
import backend.Luggage;
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

    private boolean addMode;
    private Luggage editable = null;
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

    private FoundLuggage makeFoundLuggage() {
        return new FoundLuggage(this.textFieldLabelId.getText(), this.textFieldFlightId.getText(), this.textFieldDestination.getText(),
                this.textFieldType.getText(), this.textFieldBrand.getText(), this.textFieldColor.getText(), this.textFieldLostFound.getText(),
                this.textFieldDate.getText(), this.textFieldStatus.getText(), null);
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

    @FXML
    private void save(ActionEvent event) {
        //if all fields are filled in correctly.
        //if (foundmode)
        int count = 0;
        if (this.textFieldTime.getText().isEmpty()) {
            count++;
        } else {

        }
        if (this.textFieldDate.getText().isEmpty()) {
            count++;
        } else {

        }
        if (this.textFieldType.getText().isEmpty()) {
            count++;
        } else {

        }
        if (this.textFieldColor.getText().isEmpty()) {
            count++;
        } else {

        }

        if (this.textFieldLostFound.getText().isEmpty()) {
            count++;
        } else {

        }
        if (this.textFieldStatus.getText().isEmpty()) {
            count++;
        } else {

        }
        //only if the required fields are not empty can a Luggage be registered.
        if (count == 0) {
            //create account object from textfields.
            FoundLuggage newLuggage = new FoundLuggage(
                    this.textFieldLabelId.getText(),
                    this.textFieldFlightId.getText(),
                    this.textFieldAirport.getText(),
                    this.textFieldLostFound.getText(),
                    this.textFieldDestination.getText(),
                    this.textFieldType.getText(),
                    this.textFieldBrand.getText(),
                    this.textFieldColor.getText(),
                    this.textFieldDate.getText(),
                    this.textFieldStatus.getText());
            //create DB connection.
            Connection conn = DBConnection.connectDb();
            try {
                if (this.addMode) {
                    String sql = "INSERT INTO lostluggage (userid, username, password,"
                            + " privilege, name, surname, email)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, this.textFieldLabelId.getText());
                    preparedStatement.setString(2, this.textFieldFlightId.getText());
                    preparedStatement.setString(3, this.textFieldAirport.getText());
                    preparedStatement.setString(4, this.textFieldLostFound.getText());
                    preparedStatement.setString(5, this.textFieldDestination.getText());
                    preparedStatement.setString(6, this.textFieldType.getText());
                    preparedStatement.setString(7, this.textFieldBrand.getText());
                    preparedStatement.setString(8, this.textFieldColor.getText());
                    preparedStatement.setString(9, this.textFieldDate.getText());
                    preparedStatement.setString(10, this.textFieldStatus.getText());
                    preparedStatement.executeUpdate();
                    //if the data is put in the database, add it to the tableview.
                    LuggageListController.foundLuggageData.add(newLuggage);

                }else{
                    String sql = "UPDATE lostLuggage SET username = ?, password = ?,"
                                + " privilege = ?, name = ?, surname = ?, email = ? "
                                + "WHERE userid = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, this.textFieldLabelId.getText());
                        preparedStatement.setString(2, this.textFieldFlightId.getText());
                        preparedStatement.setString(3, this.textFieldAirport.getText());
                        preparedStatement.setString(4, this.textFieldLostFound.getText());
                        preparedStatement.setString(5, this.textFieldDestination.getText());
                        preparedStatement.setString(6, this.textFieldType.getText());
                        preparedStatement.setString(7, this.textFieldBrand.getText());
                        preparedStatement.setString(8, this.textFieldColor.getText());
                        preparedStatement.setString(9, this.textFieldDate.getText());
                        preparedStatement.setString(10, this.textFieldStatus.getText());
                        preparedStatement.executeUpdate();
                        //replace the account in the table as well.
                        int replaceIndex = LuggageListController.foundLuggageData.indexOf(this.editable);
                        LuggageListController.foundLuggageData.remove(replaceIndex);
                        LuggageListController.foundLuggageData.add(replaceIndex, newLuggage);
                }
                //finally, close the window
                Stage stage = (Stage) this.buttonSave.getScene().getWindow();
                stage.close();
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Error" + ex);
            }
        } else {
            //error message
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Registration failure");//ripe for translation
            alert.setHeaderText(null);
            alert.setContentText("One or more of required fields is empty.");//ripe for translation
            alert.showAndWait();
        }
    }

    public void initData(Luggage editLuggage, boolean addMode) {
        this.addMode = addMode;
        this.editable = editLuggage;
    }
}
