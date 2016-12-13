package ui;

import backend.Account;
import backend.FoundLuggage;
import backend.LuggageEnum;
import backend.StatusEnum;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static ui.LuggageListController.foundLuggageData;

/**
 * FXML Controller class
 *
 * @author Atori
 * @author Enes
 * @author Elwin
 */
public class AccountManagerController implements Initializable {

    public static ObservableList<Account> accountData;
    
    @FXML
    private Button buttonAccountManagerEdit;
    @FXML
    private Button buttonAccountManagerAdd;
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
    
    public AccountManagerController(){
        //The list is filled with test data.
        AccountManagerController.accountData = FXCollections.observableArrayList(
                new Account("Karello", "****", 
                "Baliemedewerker", "Karel", "Lout", "Karello@gmail.com"));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Bind all text to the translations.
        I18N.bindText(this.buttonAccountManagerEdit.getText(), this.buttonAccountManagerEdit, (Object[]) null);
        I18N.bindText(this.buttonAccountManagerAdd.getText(), this.buttonAccountManagerAdd, (Object[]) null);
        I18N.bindTableText(this.columnUsername.getText(), this.columnUsername, (Object[]) null);
        I18N.bindTableText(this.columnPassword.getText(), this.columnPassword, (Object[]) null);
        I18N.bindTableText(this.columnPriveleges.getText(), this.columnPriveleges, (Object[]) null);
        I18N.bindTableText(this.columnName.getText(), this.columnName, (Object[]) null);
        I18N.bindTableText(this.columnSurname.getText(), this.columnSurname, (Object[]) null);
        I18N.bindTableText(this.columnEmail.getText(), this.columnEmail, (Object[]) null);
        this.tableAccount.setItems(accountData);
        
        //init collumns and decide what values are stored in them.
        this.columnUsername.setCellValueFactory(
                new PropertyValueFactory<Account, String>("username"));
        this.columnPassword.setCellValueFactory(
                new PropertyValueFactory<Account, String>("password"));
        this.columnPriveleges.setCellValueFactory(
                new PropertyValueFactory<Account, String>("privilege"));
        this.columnName.setCellValueFactory(
                new PropertyValueFactory<Account, String>("name"));
        this.columnSurname.setCellValueFactory(
                new PropertyValueFactory<Account, String>("surname"));
        this.columnEmail.setCellValueFactory(
                new PropertyValueFactory<Account, String>("email"));
        
        this.tableAccount.setItems(accountData);
    }    

    @FXML
    private void editAccount(ActionEvent event) {
        
    }

    @FXML
    private void addAccount(ActionEvent event) {
        /* Load the add screen.
        First the FXML file is loaded and then a new Stage is made (a window) and shown.
        */
        try {
            //this.tableFoundLuggage.setItems(foundLuggageData); ONLY FOR TESTING
            Parent addScreen = FXMLLoader.load(getClass().getResource("AccountManagerEdit.fxml"));
            
            Stage add = new Stage();
            Scene scene = new Scene(addScreen);
            add.setTitle("Corendon Bagage Systeem");
            add.setScene(scene);
            add.show();
        } catch (IOException ex) {
            Logger.getLogger(LuggageListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
