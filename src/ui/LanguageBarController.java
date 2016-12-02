package ui;

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
    void changeLanguageEnglish(ActionEvent event) {
            I18N.setLocale(new Locale("en","EN"));
            //I18N.setLocale(Locale.ENGLISH);
    }

    @FXML
    void changeLanguageDutch(ActionEvent event) {
        I18N.setLocale(new Locale("nl","NL"));
    }

    @FXML
    void changeLanguageTurkish(ActionEvent event) {
        I18N.setLocale(new Locale("tr","TR"));
    }

}
