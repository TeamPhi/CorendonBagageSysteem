package ui;

import backend.I18N;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
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
    private LineChart<String, Integer> graphRegisteredLuggage;
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
        
        
        graphRegisteredLuggage.getXAxis().setAutoRanging(true);
        graphRegisteredLuggage.getYAxis().setAutoRanging(true);
        
        
        /*
        XYChart.Series series = new XYChart.Series<>();
        series.setName("broodje");
        series.getData().add(new XYChart.Data<String, Integer>("jan", 23));
        series.getData().add(new XYChart.Data<String, Integer>("feb", 28));
        series.getData().add(new XYChart.Data<String, Integer>("mar", 20));
        graphRegisteredLuggage.getData().add(series);
        
        XYChart.Series series2 = new XYChart.Series<>();
        series2.setName("aap");
        series2.getData().add(new XYChart.Data<String, Integer>("jan", 28));
        series2.getData().add(new XYChart.Data<String, Integer>("feb", 210));
        series2.getData().add(new XYChart.Data<String, Integer>("apr", 150));
        graphRegisteredLuggage.getData().add(series2);*/
    }    
    
}
