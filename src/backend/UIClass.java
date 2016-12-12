package backend;

import javafx.scene.Node;
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
}
