package backend;

import java.util.Optional;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

/**Provides extra methods for the User Interface
 * 
 * @author Elwin Slokker
 */
public abstract class UIClass {
    
    /**Set the distance between the AnchorPane borders and the borders of the element.
     * Can only be used when the element is the child of an AnchorPane.
     * @param e The Node or element you want to anchor.
     * @param distance The amount of space between the borders of the node and 
     * the borders of the anchorpane.
     */
    public static void setAnchorDistance(Node e, Double distance){
        AnchorPane.setBottomAnchor(e, distance);
        AnchorPane.setLeftAnchor(e, distance);
        AnchorPane.setRightAnchor(e, distance);
        AnchorPane.setTopAnchor(e, distance);
    }
    /**Display a window asking the user if the subject should be deleted.
     * 
     * @return true if the user clicked Yes, false if the user clicked No.
     */
    public static boolean promptDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(I18N.getTranslation("promptDeleteTitle"));
        alert.setHeaderText(null);
        alert.setContentText(I18N.getTranslation("promptDeleteConfirm"));
        ButtonType buttonYes = new ButtonType(I18N.getTranslation("yes"));
        ButtonType buttonNo = new ButtonType(I18N.getTranslation("no"), ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonYes, buttonNo);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get().equals(buttonYes);
    }
    /**Shows a warning like dialog intended for all notifications and errors.
     * 
     * @param headerKey The key for the translated title of the window.
     * @param promptKey The key for the translated description of the window.
     */
    public static void showPopup(String headerKey, String promptKey) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(I18N.getTranslation(headerKey));
        //alert.setTitle(I18N.get(headerKey));
        alert.setHeaderText(null);
        alert.setContentText(I18N.getTranslation(promptKey));
        alert.showAndWait();
    }
}
