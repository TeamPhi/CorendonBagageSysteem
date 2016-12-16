package ui;

import backend.Account;
import backend.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elwin Slokker
 */
public class AccountManagerEditController implements Initializable {

    private boolean addMode;
    private Account editable;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private TextField textFieldFirstName;
    @FXML
    private TextField textFieldSurname;
    @FXML
    private TextField textFieldEmailAdress;
    @FXML
    private ChoiceBox<String> choiceBoxPrivilege;
    @FXML
    private TextField textFieldNewPassword;
    @FXML
    private TextField textFieldNewPasswordRepeat;
    @FXML
    private Label labelSurname;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelPrivilege;
    @FXML
    private Label labelChangePass;
    @FXML
    private Label labelPassPrompt;
    @FXML
    private Label labelPassRepeat;
    @FXML
    private Label labelResetPass;
    @FXML
    private Button buttonResetPassword;
    @FXML
    private Button buttonSave;

    public AccountManagerEditController() {
        this.editable = null;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        translation here
         */
        //add items to the ChoiceBox
        this.choiceBoxPrivilege.setItems(FXCollections.observableArrayList("Desk clerk", "Manager"));
        //translation!!!
    }

    @FXML
    private void resetPassword(ActionEvent event) {
        if (this.textFieldNewPassword.getText().equals(this.textFieldNewPasswordRepeat.getText())) {
            //selectedAccount.setPassword(this.textFieldNewPassword.getText());
            //database connection
            //Send or propose E-Mail code here
            Stage stage = (Stage) this.buttonResetPassword.getScene().getWindow();
            stage.close();
        } else if (this.textFieldNewPassword.getText().isEmpty() == false
                || this.textFieldNewPasswordRepeat.getText().isEmpty() == false) {
            //Error message if one of the fields is empty.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Password warning");//ripe for translation
            alert.setHeaderText(null);
            alert.setContentText("The password fields may not be empty.");//ripe for translation
            alert.showAndWait();
        } else {
            //Error message that appears when the passwords are not equal.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Password warning");//ripe for translation
            alert.setHeaderText(null);
            alert.setContentText("The passwords must be exactly the same.");//ripe for translation
            alert.showAndWait();
        }
    }

    @FXML
    private void save(ActionEvent event) {
        /*
        
         */
        if (this.textFieldUsername.getText().isEmpty() == false
                || this.textFieldNewPassword.getText().isEmpty() == false
                || this.choiceBoxPrivilege.getSelectionModel().isEmpty() == false
                || this.textFieldFirstName.getText().isEmpty() == false
                || this.textFieldSurname.getText().isEmpty() == false
                || this.textFieldEmailAdress.getText().isEmpty() == false) {
            //create account object from textfields.
            Account temp = new Account(this.textFieldUsername.getText(),
                    this.textFieldNewPassword.getText(),
                    this.choiceBoxPrivilege.getValue(),
                    this.textFieldFirstName.getText(),
                    this.textFieldSurname.getText(),
                    this.textFieldEmailAdress.getText());
            //create DB connection.
            Connection conn = DBConnection.connectDb();

            if (this.addMode) {
                try {
                    String sql = "INSERT INTO account (userid, username, password,"
                            + " privilege, name, surname, email)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, "0");//this should be changed
                    preparedStatement.setString(2, this.textFieldUsername.getText());
                    preparedStatement.setString(3, this.textFieldNewPassword.getText());
                    preparedStatement.setString(4, this.choiceBoxPrivilege.getValue());
                    preparedStatement.setString(5, this.textFieldFirstName.getText());
                    preparedStatement.setString(6, this.textFieldSurname.getText());
                    preparedStatement.setString(7, this.textFieldEmailAdress.getText());
                    preparedStatement.executeUpdate();
                    conn.close();
                    //if the data is put in the database, add it to the tableview.
                    AccountManagerController.accountData.add(temp);
                } catch (SQLException ex) {
                    System.err.println("Error" + ex);
                }

            } else {
                try {
                    String sql = "UPDATE account SET username = ?, password = ?,"
                            + " privilege = ?, name = ?, surname = ?, email = ? "
                            + "WHERE userid = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, this.textFieldUsername.getText());
                    preparedStatement.setString(2, this.textFieldNewPassword.getText());
                    preparedStatement.setString(3, this.choiceBoxPrivilege.getValue());
                    preparedStatement.setString(4, this.textFieldFirstName.getText());
                    preparedStatement.setString(5, this.textFieldSurname.getText());
                    preparedStatement.setString(6, this.textFieldEmailAdress.getText());
                    preparedStatement.setInt(7, 0);//this should be changed
                    preparedStatement.executeUpdate();
                    conn.close();
                    AccountManagerController.accountData.remove(this.editable);
                    AccountManagerController.accountData.add(temp);
                } catch (SQLException ex) {
                    System.err.println("Error" + ex);
                }

            }

            //finally, close the window
            Stage stage = (Stage) this.buttonSave.getScene().getWindow();
            stage.close();
        } else {
            //error message
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Registration failure");//ripe for translation
            alert.setHeaderText(null);
            alert.setContentText("One or more of the fields is empty.");//ripe for translation
            alert.showAndWait();
        }
    }

    public void initData(Account account, boolean addMode) {
        this.addMode = addMode;
        this.editable = account;
        if (addMode == true) {
            this.buttonResetPassword.disableProperty().set(true);
            this.buttonResetPassword.visibleProperty().set(false);
            this.labelPassRepeat.setVisible(false);
            this.textFieldNewPasswordRepeat.disableProperty().set(true);
            this.textFieldNewPasswordRepeat.setVisible(false);
            this.labelResetPass.setVisible(false);
        } else {
            this.textFieldFirstName.setText(account.getName());
            this.textFieldSurname.setText(account.getSurname());
            this.textFieldUsername.setText(account.getUsername());
            this.textFieldNewPassword.setText(account.getPassword());
            this.textFieldEmailAdress.setText(account.getEmail());
            this.choiceBoxPrivilege.setValue(account.getPrivilege());
            //this.textFieldFirstName.setText(account.getName());
        }
    }
}
