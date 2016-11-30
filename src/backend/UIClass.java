package backend;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**Provides extra methods for the User Interface
 * 
 * @author Elwin Slokker
 */
public class UIClass {
    /**
     * 
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
}
