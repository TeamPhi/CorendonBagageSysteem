package ui;

import backend.I18N;
import java.util.Locale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LanguageBarController {

    @FXML
    private Button buttonEnglish;

    @FXML
    private Button buttonDutch;

    @FXML
    private Button buttonTurkish;

    @FXML
    private void changeLanguageEnglish(ActionEvent event) {
            I18N.setLocale(new Locale("en","GB"));
            //I18N.setLocale(Locale.ENGLISH);
    }

    @FXML
    private void changeLanguageDutch(ActionEvent event) {
        I18N.setLocale(new Locale("nl","NL"));
    }

    @FXML
    private void changeLanguageTurkish(ActionEvent event) {
        I18N.setLocale(new Locale("tr","TR"));
    }

}
