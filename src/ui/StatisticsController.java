package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Enes
 */
public class StatisticsController implements Initializable {
    @FXML
    private Label labelStartDate;
    @FXML
    private Label labelRegisteredLuggage;
    @FXML
    private LineChart graphRegisteredLuggage;
    @FXML
    private DatePicker datumpicker;
    @FXML
    private ComboBox comboBoxAlleLuchthavens;
    @FXML
    private ComboBox comboBoxSelectedTime;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        I18N.bindText(this.labelStartDate.getText(), this.labelStartDate, (Object[]) null);
        I18N.bindText(this.labelRegisteredLuggage.getText(), this.labelRegisteredLuggage, (Object[]) null);
    }    
    
}
