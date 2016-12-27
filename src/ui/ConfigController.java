package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Oscar Hulshof
 */
public class ConfigController implements Initializable {

    @FXML
    private Pane paneBody;
    @FXML
    private Button buttonSave;
    @FXML
    private TextField textfieldLostLuggage;
    @FXML
    private TextField textfieldFoundLuggage;
    @FXML
    private TextField textfieldStatistics;
    @FXML
    private Label labelFoundHeader;
    @FXML
    private Label labelLostHeader;
    @FXML
    private Label labelStatisticsHeader;
    @FXML
    private Label labelTimeFound;
    @FXML
    private Label labelTimeLost;
    @FXML
    private Label labelTimeStatistics;
    @FXML
    private Label labelNoteFound;
    @FXML
    private Label labelNoteLost;
    @FXML
    private Label labelNoteStatistics;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Translatition first
        I18N.bindText(this.buttonSave.getText(), this.buttonSave, (Object[]) null);
        I18N.bindText(this.labelFoundHeader.getText(), this.labelFoundHeader, (Object[]) null);
        I18N.bindText(this.labelLostHeader.getText(), this.labelLostHeader, (Object[]) null);
        I18N.bindText(this.labelStatisticsHeader.getText(), this.labelStatisticsHeader, (Object[]) null);
        I18N.bindText(this.labelTimeFound.getText(), this.labelTimeFound, (Object[]) null);
        I18N.bindText(this.labelTimeLost.getText(), this.labelTimeLost, (Object[]) null);
        I18N.bindText(this.labelTimeStatistics.getText(), this.labelTimeStatistics, (Object[]) null);
        I18N.bindText(this.labelNoteFound.getText(), this.labelNoteFound, (Object[]) null);
        I18N.bindText(this.labelNoteLost.getText(), this.labelNoteLost, (Object[]) null);
        I18N.bindText(this.labelNoteStatistics.getText(), this.labelNoteStatistics, (Object[]) null);
        //Set the textfield to whatever value is in the config file.
        try {
            setTextfieldTexts();
        } catch (IOException ex) {
            Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.textfieldFoundLuggage.set
    }

    @FXML
    private void saveButtonClicked(ActionEvent event) throws IOException {
        writeToConfigFile();
    }

    @FXML
    private void controlKeyPress(KeyEvent event) {
        //this method should stop not numeric from being typed, bu it doesn't.
        if (event.getCode().isDigitKey() || event.getCode().isNavigationKey()
                || event.getCode().isFunctionKey()) {
            //System.out.println("fire");
        } else {
            //if key is not a digit or function key; ignore the keypress.
            event.consume();
            //System.out.println("unfire");
        }

    }

    /**
     * get value from config file and return the value as string
     *
     * @param property The property to be read from the configfile
     * @return returns the value of the property
     * @throws IOException
     * @throws FileNotFoundException
     */
    public String readFromConfigFile(String property) throws IOException, FileNotFoundException {

        File configFile = createConfigFile();

        Properties properties = new Properties();

        FileReader reader = new FileReader(configFile);
        properties.load(reader);

        String propValue = properties.getProperty(property, "0"); //reads the specified property
        return propValue;
    }

    /**
     * retrieves strings from textfields and stores them in the config file
     *
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void writeToConfigFile() throws IOException, FileNotFoundException {

        File configFile = createConfigFile();

        Properties properties = new Properties();

        FileWriter writer = new FileWriter(configFile);

        //set the properties in the config file equal to the values the user entered
        properties.setProperty("maxSaveTimeFoundLuggage", textfieldFoundLuggage.getText());
        properties.setProperty("maxSaveTimeLostLuggage", textfieldLostLuggage.getText());
        properties.setProperty("maxSaveTimeStatistics", textfieldStatistics.getText());

        properties.store(writer, "config settings");
        writer.close();
    }

    /**
     * create a new config file if no config file can be found in the directory
     * and set it's properties to a default '0'.
     *
     * @return returns a pointer to the config file
     * @throws IOException
     */
    public File createConfigFile() throws IOException {

        /*if file 'config.properties' can not be found or does not exist, 
         create new file with that name*/
        File configFile = new File("config.properties");
        if (configFileExists() == false) {
            //if the file exists the method will stop here and return the config file.
            boolean fileCreated = configFile.createNewFile();
            //System.out.println("Config file created: " + fileCreated);

            if (fileCreated == true) {
                Properties properties = new Properties();

                try (FileWriter writer = new FileWriter(configFile)) {
                    //default values
                    properties.setProperty("maxSaveTimeFoundLuggage", "0");
                    properties.setProperty("maxSaveTimeLostLuggage", "0");
                    properties.setProperty("maxSaveTimeStatistics", "0");

                    properties.store(writer, "config settings");
                }
            }
        }
        return configFile;
    }

    /**
     * Checks if file exists
     *
     * @return True if file exists and false if file does not exist
     */
    public boolean configFileExists() {
        File configFile = new File("config.properties"); //file to check
        boolean exists = configFile.exists();
        //System.out.println("Config file exists: " + exists);
        return exists;
    }

    /**
     * Sets the text in textfiels equal to the values in the configfile
     *
     * @throws IOException
     */
    public void setTextfieldTexts() throws IOException {
        textfieldLostLuggage.setText(readFromConfigFile("maxSaveTimeLostLuggage"));
        textfieldFoundLuggage.setText(readFromConfigFile("maxSaveTimeFoundLuggage"));
        textfieldStatistics.setText(readFromConfigFile("maxSaveTimeStatistics"));
    }
}
