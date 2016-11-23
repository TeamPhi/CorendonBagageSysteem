package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
/**
 *
 * @author Elwin Slokker
 */
public class MainUIController implements Initializable{
    @FXML
    private AnchorPane paneHeader;
    private Button thaTest;
    //private ImageView btnLangTurkish;
    @FXML
    private void testThis(ActionEvent event) {
        //System.out.println("Turkish");
        //paneHeader.getChildren().setAll(FXMLLoader.load(getClass().getResource("LanguageBox.fxml")));
        /*
        try {
            paneHeader.getChildren().add(FXMLLoader.load(getClass().getResource("LanguageBox.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        System.out.println("dit is een test dat meerdere controllers werken");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }   
}
