package backend;

/**
 * 
 * @autoh Oracle
 * @author Elwin Slokker
 */
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import javafx.scene.control.Labeled;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;

/**
 * I18N utility class.
 */
public final class I18N {

    /** the current selected Locale. */
    public static final ObjectProperty<Locale> LOCALE;
    public static final String PROGRAM_NAME_KEY = "programTitle";
    static {
        LOCALE = new SimpleObjectProperty<>(getDefaultLocale());
        LOCALE.addListener((observable, oldValue, newValue) -> Locale.setDefault(newValue));
    }

    /**
     * get the supported Locales.
     *
     * @return List of Locale objects.
     */
    public static List<Locale> getSupportedLocales() {
        return new ArrayList<>(Arrays.asList(Locale.ENGLISH, new Locale("nl","NL"), new Locale("tr","TR")));
    }

    /**
     * get the default locale. This is the systems default if contained in the supported locales, english otherwise.
     *
     * @return
     */
    public static Locale getDefaultLocale() {
        Locale sysDefault = Locale.getDefault();
        return getSupportedLocales().contains(sysDefault) ? sysDefault : Locale.ENGLISH;
    }

    public static Locale getLocale() {
        return LOCALE.get();
    }

    public static void setLocale(Locale locale) {
        localeProperty().set(locale);
        Locale.setDefault(locale);
    }

    public static ObjectProperty<Locale> localeProperty() {
        return LOCALE;
    }

    /**
     * gets the string with the given key from the resource bundle for the current locale and uses it as first argument
     * to MessageFormat.format, passing in the optional args and returning the result.
     *
     * @param key
     *         message key
     * @param args
     *         optional arguments for the message
     * @return localized formatted string
     */
    public static String get(final String key, final Object... args) {
        ResourceBundle bundle = ResourceBundle.getBundle("resource.LanguageBundle", getLocale());
        return MessageFormat.format(bundle.getString(key), args);
    }

    /**
     * creates a String binding to a localized String for the given message bundle key
     *
     * @param key
     *         key
     * @param args
     * @return String binding
     */
    public static StringBinding createStringBinding(final String key, Object... args) {
        return Bindings.createStringBinding(() -> get(key, args), LOCALE);
    }

    /**
     * creates a String Binding to a localized String that is computed by calling the given func
     *
     * @param func
     *         function called on every change
     * @return StringBinding
     */
    public static StringBinding createStringBinding(Callable<String> func) {
        return Bindings.createStringBinding(func, LOCALE);
    }
  
    /** Binds the labeled Node with the given resourcebundle key
     *
     * @param key ResourceBundle key
     * @param e Labeled element/control.
     * @param args optional arguments for the message
     * 
     */
    public static void bindText(final String key, Labeled e, final Object... args) {
        //Button button = new Button();
        e.textProperty().bind(createStringBinding(key, args));
        //return button;
    }

    /** Binds the Column header with the given resourcebundle key.
     *
     * @param key ResourceBundle key
     * @param t
     * @param args
     */
    public static void bindTableText(final String key, TableColumn t, final Object... args) {
        t.textProperty().bind(createStringBinding(key, args));
    }
    /** Binds the Tab header with the given resourcebundle key.
     *
     * @param key ResourceBundle key
     * @param t
     * @param args
     */
    public static void bindTabText(final String key, Tab t, final Object... args) {
        t.textProperty().bind(createStringBinding(key, args));
    }
}
