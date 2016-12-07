package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jordy Quak
 */
public class ConfigController implements Initializable {

    @FXML
    private Button buttonSave;
    @FXML
    private TextField textfieldLostMaxLuggage;
    @FXML
    private TextField textfieldFoundMaxLuggage;
    @FXML
    private TextField textfieldStatistics;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
