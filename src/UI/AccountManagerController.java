/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Atori
 */
public class AccountManagerController implements Initializable {

    @FXML
    private Button accountManagementEditButton;
    @FXML
    private Button accountManagementAddButton;
    @FXML
    private TableView<?> accountTabel;
    @FXML
    private TableColumn columnUsername;
    @FXML
    private TableColumn columnPassword;
    @FXML
    private TableColumn columnPriveleges;
    @FXML
    private TableColumn columnName;
    @FXML
    private TableColumn columnSurname;
    @FXML
    private TableColumn columnEmail;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println(this.columnUsername.getText());
        /*
        I18N.bindTableText(this.columnUsername.getText(), this.columnUsername, (Object[]) null);
        I18N.bindTableText(this.columnPassword.getText(), this.columnPassword, (Object[]) null);
        I18N.bindTableText(this.columnPriveleges.getText(), this.columnPriveleges, (Object[]) null);
        I18N.bindTableText(this.columnName.getText(), this.columnUsername, (Object[]) null);
        I18N.bindTableText(this.columnSurname.getText(), this.columnUsername, (Object[]) null);
        I18N.bindTableText(this.columnEmail.getText(), this.columnEmail, (Object[]) null);
        */
        //I18N.bindText(this.accountManagementEditButton.getText(), this.accountManagementEditButton, (Object[]) null);
    }    

    @FXML
    private void accountManagementEditAccount(ActionEvent event) {
    }

    @FXML
    private void accountManagementAddButtonAction(MouseEvent event) {
    }

    @FXML
    private void accountManagementAddAccount(ActionEvent event) {
    }
    
}
