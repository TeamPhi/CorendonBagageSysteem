/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author Enes
 */
public class StatisticsController implements Initializable {
    
    @FXML
    private LineChart graphRegisteredLuggage;
    private DatePicker datumpicker;
    private ComboBox comboBoxAlleLuchthavens;
    private ComboBox comboBoxSelectedTime;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
