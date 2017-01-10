package ui;

import backend.I18N;
import backend.Account;
import backend.DBConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Atori
 * @author Enes
 * @author Elwin
 */
public class AccountManagerController implements Initializable {

    public static ObservableList<Account> accountData = FXCollections.observableArrayList();

    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonDelete;
    @FXML
    private TableView<Account> tableAccount;
    @FXML
    private TableColumn<Account, String> columnUsername;
    @FXML
    private TableColumn<Account, String> columnPassword;
    @FXML
    private TableColumn<Account, String> columnPriveleges;
    @FXML
    private TableColumn<Account, String> columnName;
    @FXML
    private TableColumn<Account, String> columnSurname;
    @FXML
    private TableColumn<Account, String> columnEmail;

    public AccountManagerController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Bind all text to the translations.
        I18N.bindText(this.buttonEdit.getText(), this.buttonEdit, (Object[]) null);
        I18N.bindText(this.buttonAdd.getText(), this.buttonAdd, (Object[]) null);
        I18N.bindText(this.buttonDelete.getText(), this.buttonDelete, (Object[]) null);
        I18N.bindTableText(this.columnUsername.getText(), this.columnUsername, (Object[]) null);
        I18N.bindTableText(this.columnPassword.getText(), this.columnPassword, (Object[]) null);
        I18N.bindTableText(this.columnPriveleges.getText(), this.columnPriveleges, (Object[]) null);
        I18N.bindTableText(this.columnName.getText(), this.columnName, (Object[]) null);
        I18N.bindTableText(this.columnSurname.getText(), this.columnSurname, (Object[]) null);
        I18N.bindTableText(this.columnEmail.getText(), this.columnEmail, (Object[]) null);

        //init collumns and tell what values are stored in them.
        this.columnUsername.setCellValueFactory(
                new PropertyValueFactory<>("username"));
        this.columnPassword.setCellValueFactory(
                new PropertyValueFactory<>("password"));
        this.columnPriveleges.setCellValueFactory(
                new PropertyValueFactory<>("privilege"));
        this.columnName.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        this.columnSurname.setCellValueFactory(
                new PropertyValueFactory<>("surname"));
        this.columnEmail.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        this.tableAccount.setItems(AccountManagerController.accountData);
        loadAccounts();
    }

    public void loadAccounts() {
        Connection conn = DBConnection.connectDb();
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM account");
            // string from database
            while (rs.next()) {
                //make an account from the data from the database.
                Account temp = new Account(rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                temp.setUserID(rs.getInt(1));
                //Add the temp account to the list.
                AccountManagerController.accountData.add(temp);
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }

    @FXML
    private void editAccount(ActionEvent event) {
        /*Check if the user may edit the selected account.
        The window is only shown if the list contains at least one account and
        at least one is selected.
         */
        if (this.tableAccount.getSelectionModel().getSelectedItem() != null) {
            if (!Account.isEqualAccount(Account.getUser(),
                    this.tableAccount.getSelectionModel().getSelectedItem())) {
                showAccountManagerEdit(this.tableAccount.getSelectionModel().getSelectedItem(), false);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attempt to edit own account");//ripe for translation
                alert.setHeaderText(null);
                alert.setContentText("You cannot edit your own account!");//ripe for translation
                alert.showAndWait();
            }
        } else if (AccountManagerController.accountData.isEmpty()) {
            //error if there is no account yet.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No entries");//ripe for translation
            alert.setHeaderText(null);
            alert.setContentText("You can only edit an account if you have at least one entry.");//ripe for translation
            alert.showAndWait();
        } else {
            //error if here is no selection.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");//ripe for translation
            alert.setHeaderText(null);
            alert.setContentText("You can only edit an account if you select an entry.");//ripe for translation
            alert.showAndWait();
        }

    }

    @FXML
    private void addAccount(ActionEvent event) {
        //simply execute the method with addMode = true.
        showAccountManagerEdit(null, true);
    }

    /**
     * Method/event for removing an account from the table and the database.
     *
     */
    public void deleteAccount() {
        /*
        First check whether the user has selected an editable account.
         */
        Account selectedAccount = this.tableAccount.getSelectionModel().getSelectedItem();
        if (selectedAccount != null) {
            if (!Account.isEqualAccount(Account.getUser(),
                    this.tableAccount.getSelectionModel().getSelectedItem())) {
                if (this.promptDelete()) {

                    try {
                        Connection conn = DBConnection.connectDb();
                        Statement stmt = conn.createStatement();
                        String sql = "DELETE FROM account "
                                + "WHERE userid = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        //preparedStatement.setInt(1, 0);//this should be changed
                        preparedStatement.setInt(1, selectedAccount.getUserID());
                        preparedStatement.executeUpdate();
                        conn.close();
                        AccountManagerController.accountData.remove(selectedAccount);
                    } catch (SQLException ex) {
                        System.err.println("Error" + ex);
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attempt to delete own account");//ripe for translation
                alert.setHeaderText(null);
                alert.setContentText("You cannot delete your own account!");//ripe for translation
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");//ripe for translation
            alert.setHeaderText(null);
            alert.setContentText("You can only delete an account if you select an entry.");//ripe for translation
            alert.showAndWait();
        }
    }

    /**
     * Load and show the account editor screen.
     *
     * @param editAccount The account that needs to be edited. (null if none)
     * @param addMode True if the screen is called from buttonAdd and false if
     * called by buttonEdit.
     */
    private void showAccountManagerEdit(Account editAccount, boolean addMode) {
        /* Load the add/ecit screen.
        First the FXML file is loaded and then a new Stage is made (a window) and shown.
        The initData method passes the arguments to the controller.
         */
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountManagerEdit.fxml"));

        Stage stage = new Stage();
        try {
            stage.setScene(new Scene((Pane) loader.load()));
            loader.<AccountManagerEditController>getController().initData(editAccount, addMode);
            stage.titleProperty().bind(I18N.createStringBinding(I18N.PROGRAM_NAME_KEY, (Object[]) null));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AccountManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    private boolean promptDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm deletion");//ripe for translation
        alert.setHeaderText(null);
        alert.setContentText("Really delete?");//ripe for translation
        ButtonType buttonYes = new ButtonType("Yes");//ripe for translation
        ButtonType buttonNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);//ripe for translation
        alert.getButtonTypes().setAll(buttonYes, buttonNo);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get().equals(buttonYes);
    }

}
