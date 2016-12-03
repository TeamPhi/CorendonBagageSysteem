package ui;

import backend.Luggage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
/**
 * FXML 
 * 
 * @author Elwin Slokker
 */
public class LuggageListController implements Initializable{

    @FXML
    private Tab tabFound;
    @FXML
    private TableView<Luggage> tableFoundLuggage;
    @FXML
    private TableColumn<Luggage, String> columnFoundLabelnumber;
    @FXML
    private TableColumn<Luggage, String> columnFoundAirport;
    @FXML
    private TableColumn<Luggage, String> columnFoundFlightnumber;
    @FXML
    private TableColumn<Luggage, String> columnFoundDestination;
    @FXML
    private TableColumn<Luggage, String> columnFoundType;
    @FXML
    private TableColumn<Luggage, String> columnFoundBrand;
    @FXML
    private TableColumn<Luggage, String> columnFoundColor;
    @FXML
    private TableColumn<Luggage, String> columnFoundDate;
    @FXML
    private TableColumn<Luggage, String> columnFoundStatus;
    @FXML
    private Button buttonFoundSearch;
    @FXML
    private Button buttonFoundMatch;
    @FXML
    private Button buttonFoundExport;
    @FXML
    private Button buttonFoundImport;
    @FXML
    private Button buttonFoundEdit;
    @FXML
    private Button buttonFoundAdd;
    @FXML
    private Tab tabLost;
    @FXML
    private TableView<?> tableLostLuggage;
    @FXML
    private TableColumn<?, ?> columnLostLabelnumber;
    @FXML
    private TableColumn<?, ?> columnLostAirport;
    @FXML
    private TableColumn<?, ?> columnLostFlightnumber;
    @FXML
    private TableColumn<?, ?> columnLostDestination;
    @FXML
    private TableColumn<?, ?> columnLostType;
    @FXML
    private TableColumn<?, ?> columnLostBrand;
    @FXML
    private TableColumn<?, ?> columnLostColor;
    @FXML
    private TableColumn<?, ?> columnLostDate;
    @FXML
    private TableColumn<?, ?> columnLostStatus;
    @FXML
    private Button buttonLostSearch;
    @FXML
    private Button buttonLostMatch;
    @FXML
    private Button buttonLostExport;
    @FXML
    private Button buttonLostImport;
    @FXML
    private Button buttonLostEdit;
    @FXML
    private Button buttonLostAdd;
            
    @FXML
    private Tab tabMatches;
    @FXML
    private Button buttonMatchSearch;
    @FXML
    private Button buttonMatchMatch;
    @FXML
    private Button buttonMatchExport;
    @FXML
    private Button buttonMatchImport;
    @FXML
    private Button buttonMatchForm;
    /**
     *
     */
    public LuggageListController(){
    
    }
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        I18N.bindTabText(this.tabFound.getText(), this.tabFound, (Object[]) null);
        I18N.bindTableText(this.columnFoundLabelnumber.getText(), this.columnFoundLabelnumber, (Object[]) null);
        I18N.bindTableText(this.columnFoundAirport.getText(), this.columnFoundAirport, (Object[]) null);
        I18N.bindTableText(this.columnFoundFlightnumber.getText(), this.columnFoundFlightnumber, (Object[]) null);
        I18N.bindTableText(this.columnFoundDestination.getText(), this.columnFoundDestination, (Object[]) null);
        I18N.bindTableText(this.columnFoundType.getText(), this.columnFoundType, (Object[]) null);
        I18N.bindTableText(this.columnFoundBrand.getText(), this.columnFoundBrand, (Object[]) null);
        I18N.bindTableText(this.columnFoundColor.getText(), this.columnFoundColor, (Object[]) null);
        I18N.bindTableText(this.columnFoundDate.getText(), this.columnFoundDate, (Object[]) null);
        I18N.bindTableText(this.columnFoundStatus.getText(), this.columnFoundStatus, (Object[]) null);
        I18N.bindText(this.buttonFoundSearch.getText(), this.buttonFoundSearch, (Object[]) null);
        I18N.bindText(this.buttonFoundMatch.getText(), this.buttonFoundMatch, (Object[]) null);
        I18N.bindText(this.buttonFoundExport.getText(), this.buttonFoundExport, (Object[]) null);
        I18N.bindText(this.buttonFoundImport.getText(), this.buttonFoundImport, (Object[]) null);
        I18N.bindText(this.buttonFoundEdit.getText(), this.buttonFoundEdit, (Object[]) null);
        I18N.bindText(this.buttonFoundAdd.getText(), this.buttonFoundAdd, (Object[]) null);

        I18N.bindTabText(this.tabLost.getText(), this.tabLost, (Object[]) null);
        I18N.bindTableText(this.columnLostLabelnumber.getText(), this.columnLostLabelnumber, (Object[]) null);
        I18N.bindTableText(this.columnLostAirport.getText(), this.columnLostAirport, (Object[]) null);
        I18N.bindTableText(this.columnLostFlightnumber.getText(), this.columnLostFlightnumber, (Object[]) null);
        I18N.bindTableText(this.columnLostDestination.getText(), this.columnLostDestination, (Object[]) null);
        I18N.bindTableText(this.columnLostType.getText(), this.columnLostType, (Object[]) null);
        I18N.bindTableText(this.columnLostBrand.getText(), this.columnLostBrand, (Object[]) null);
        I18N.bindTableText(this.columnLostColor.getText(), this.columnLostColor, (Object[]) null);
        I18N.bindTableText(this.columnLostDate.getText(), this.columnLostDate, (Object[]) null);
        I18N.bindTableText(this.columnLostStatus.getText(), this.columnLostStatus, (Object[]) null);
        I18N.bindText(this.buttonLostSearch.getText(), this.buttonLostSearch, (Object[]) null);
        I18N.bindText(this.buttonLostMatch.getText(), this.buttonLostMatch, (Object[]) null);
        I18N.bindText(this.buttonLostExport.getText(), this.buttonLostExport, (Object[]) null);
        I18N.bindText(this.buttonLostImport.getText(), this.buttonLostImport, (Object[]) null);
        I18N.bindText(this.buttonLostEdit.getText(), this.buttonLostEdit, (Object[]) null);
        I18N.bindText(this.buttonLostAdd.getText(), this.buttonLostAdd, (Object[]) null);
        
        I18N.bindTabText(this.tabMatches.getText(), this.tabMatches, (Object[]) null);
    }
    @FXML
    private void searchFoundButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void matchFoundButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void exportFoundButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void importFoundButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void ediFoundButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void addFoundButtonClicked(ActionEvent event){
        
    }
    
    
    @FXML
    private void searchLostButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void matchLostButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void exportLostButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void importLostButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void ediLostButtonClicked(ActionEvent event){
        
    }
    @FXML
    private void addLostButtonClicked(ActionEvent event){
        
    }
}
