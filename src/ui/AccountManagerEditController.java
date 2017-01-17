package ui;

import backend.I18N;
import backend.Account;
import backend.DBConnection;
import backend.UIClass;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Account editable = null;
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
    private Label labelACInfo;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelWorkerName;
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
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        translations
         */
        I18N.bindText(this.labelACInfo.getText(), this.labelACInfo, (Object[]) null);
        I18N.bindText(this.labelUsername.getText(), this.labelUsername, (Object[]) null);
        I18N.bindText(this.labelWorkerName.getText(), this.labelWorkerName, (Object[]) null);
        I18N.bindText(this.labelSurname.getText(), this.labelSurname, (Object[]) null);
        I18N.bindText(this.labelEmail.getText(), this.labelEmail, (Object[]) null);
        I18N.bindText(this.labelPrivilege.getText(), this.labelPrivilege, (Object[]) null);
        I18N.bindText(this.labelChangePass.getText(), this.labelChangePass, (Object[]) null);
        I18N.bindText(this.labelPassPrompt.getText(), this.labelPassPrompt, (Object[]) null);
        I18N.bindText(this.labelPassRepeat.getText(), this.labelPassRepeat, (Object[]) null);
        I18N.bindText(this.labelResetPass.getText(), this.labelResetPass, (Object[]) null);
        I18N.bindText(this.buttonResetPassword.getText(), this.buttonResetPassword, (Object[]) null);
        //add items to the ChoiceBox
        this.choiceBoxPrivilege.setItems(FXCollections.observableArrayList(Account.SIMPLE_PRIVILEGE, Account.ADVANCED_PRIVILEGE));
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
            UIClass.showPopup("notePasswordsTitle", "notePasswordsEDesc");
        } else {
            //Error message that appears when the passwords are not equal.
            UIClass.showPopup("notePasswordsTitle", "notePasswordsDDesc");
        }
    }

    @FXML
    private void save(ActionEvent event) {
        //if all fields are filled in correctly.
        if (this.textFieldUsername.getText().isEmpty() == false
                || this.textFieldNewPassword.getText().isEmpty() == false
                || this.choiceBoxPrivilege.getSelectionModel().isEmpty() == false
                || this.textFieldFirstName.getText().isEmpty() == false
                || this.textFieldSurname.getText().isEmpty() == false
                || this.textFieldEmailAdress.getText().isEmpty() == false) {
            boolean isTooLong = false;
            if (this.textFieldUsername.getText().length() <= DBConnection.LENGTH_OF_USERNAME) {
                //System.out.println(this.textFieldUsername.getStyle());
                this.textFieldUsername.setStyle("-fx-border-color: darkgrey");
            } else {
                this.textFieldUsername.setStyle("-fx-border-color: red");
                isTooLong = true;
            }
            if (this.textFieldNewPassword.getText().length() <= DBConnection.LENGTH_OF_PASSWORD) {
                this.textFieldNewPassword.setStyle("-fx-border-color: darkgray");
            } else {
                this.textFieldNewPassword.setStyle("-fx-border-color: red");
                isTooLong = true;
            }
            if (this.textFieldFirstName.getText().length() <= DBConnection.LENGTH_OF_REALNAME) {
                this.textFieldFirstName.setStyle("-fx-border-color: darkgrey");
            } else {
                this.textFieldFirstName.setStyle("-fx-border-color: red");
                isTooLong = true;
            }
            if (this.textFieldSurname.getText().length() <= DBConnection.LENGTH_OF_SURNAME) {
                this.textFieldSurname.setStyle("-fx-border-color: darkgrey");
            } else {
                this.textFieldSurname.setStyle("-fx-border-color: red");
                isTooLong = true;
            }
            if (this.textFieldEmailAdress.getText().length() <= DBConnection.LENGTH_OF_WORKER_EMAIL) {
                this.textFieldEmailAdress.setStyle("-fx-border-color: darkgrey");
            } else {
                this.textFieldEmailAdress.setStyle("-fx-border-color: red");
                isTooLong = true;
            }

            if (isTooLong == false) {
                //create account object from textfields.
                Account temp = new Account(this.textFieldUsername.getText(),
                        this.textFieldNewPassword.getText(),
                        this.choiceBoxPrivilege.getValue(),
                        this.textFieldFirstName.getText(),
                        this.textFieldSurname.getText(),
                        this.textFieldEmailAdress.getText());
                //create DB connection.
                Connection conn = DBConnection.connectDb();
                try {
                    /*
                    Depending whether the user is editing an account or adding one,
                    add or replace the temp account in the database.
                    */
                    if (this.addMode) {
                        /*
                        First check if the user made an original username.
                         */
                        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM account WHERE username = \'"
                                + temp.getUsername() + "\';");
                        int counter = 0;
                        while (rs.next()) {
                            counter++;
                        }
                        if (counter < 1) {
                            String sql = "INSERT INTO account (username, password,"
                                    + " role, name, surname, email)"
                                    + "VALUES (?, ?, ?, ?, ?, ?)";
                            PreparedStatement preparedStatement = conn.prepareStatement(sql);
                            //preparedStatement.setInt(1, 1);//this should be changed
                            preparedStatement.setString(1, this.textFieldUsername.getText());
                            preparedStatement.setString(2, this.textFieldNewPassword.getText());
                            preparedStatement.setString(3, this.choiceBoxPrivilege.getValue());
                            preparedStatement.setString(4, this.textFieldFirstName.getText());
                            preparedStatement.setString(5, this.textFieldSurname.getText());
                            preparedStatement.setString(6, this.textFieldEmailAdress.getText());
                            preparedStatement.executeUpdate();
                            //if the data is put in the database, add it to the tableview.
                            AccountManagerController.accountData.add(temp);
                        } else {
                            //error message
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("Registration failure");//ripe for translation
                            alert.setHeaderText(null);
                            alert.setContentText("The username already exists.");//ripe for translation
                            alert.showAndWait();
                        }
                    } else {
                        //temp.setUserID(AccountManagerController.accountData.);
                        String sql = "UPDATE account SET username = ?, password = ?,"
                                + " role = ?, name = ?, surname = ?, email = ? "
                                + "WHERE userid = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, this.textFieldUsername.getText());
                        preparedStatement.setString(2, this.textFieldNewPassword.getText());
                        preparedStatement.setString(3, this.choiceBoxPrivilege.getValue());
                        preparedStatement.setString(4, this.textFieldFirstName.getText());
                        preparedStatement.setString(5, this.textFieldSurname.getText());
                        preparedStatement.setString(6, this.textFieldEmailAdress.getText());
                        preparedStatement.setInt(7, this.editable.getUserID());
                        preparedStatement.executeUpdate();
                        //replace the account in the table as well.
                        int replaceIndex = AccountManagerController.accountData.indexOf(this.editable);
                        AccountManagerController.accountData.remove(replaceIndex);
                        AccountManagerController.accountData.add(replaceIndex, temp);
                        //AccountManagerController.accountData.add(temp);
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
                UIClass.showPopup("errorRegistrationTitle","errorTooManyCharsDesc");
            }
        } else {
            //error message
            UIClass.showPopup("errorRegistrationTitle","errorEmptyFieldsDesc");
        }
    }
    /**Futher prepares the window by putting passed data in the correct fields.
     * 
     * @param account The Account to edit, if any.
     * @param addMode Whether the screen should start in add mode or edit mode.
     */
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
            I18N.bindText(this.buttonSave.getText(), this.buttonSave, (Object[]) null);
        } else {
            this.textFieldUsername.disableProperty().set(true);
            this.textFieldFirstName.setText(account.getName());
            this.textFieldSurname.setText(account.getSurname());
            this.textFieldUsername.setText(account.getUsername());
            this.textFieldNewPassword.setText(account.getPassword());
            this.textFieldEmailAdress.setText(account.getEmail());
            this.choiceBoxPrivilege.setValue(account.getPrivilege());
            I18N.bindText("buttonSaveChanges", this.buttonSave, (Object[]) null);
            //this.textFieldFirstName.setText(account.getName());
        }
    }
}
