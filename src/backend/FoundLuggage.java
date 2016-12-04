package backend;

import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Elwin Slokker
 */
public class FoundLuggage extends Luggage{
    /*
    * Only found luggage has a new field in in comparison to it's parent.
    * It is a number given to a piece of Luggage by the stockroom.
    */
    private final SimpleStringProperty lostFoundID;
    /**Create a new piece of luggage that has been found on an airport.
     * 
     * @param newLabelNumber 
     * @param newFlightnumber
     * @param newDestination
     * @param kind
     * @param newColour
     * @param newLostFoundID
     * @param registerDate
     * @param status
     * @param newPicture 
     */
    public FoundLuggage(String newLabelNumber, String newFlightnumber, 
            String newDestination, LuggageEnum kind, String newColour, 
            String newLostFoundID,Date registerDate, StatusEnum status, 
            String newPicture){
        super(newLabelNumber, newFlightnumber, newDestination, kind, newColour, registerDate, status, newPicture);
        this.lostFoundID = new SimpleStringProperty(newLostFoundID);
    }
    /**
     * 
     * @return 
     */
    public String getLostFoundID(){
        return this.lostFoundID.get();
    }
    /**
     * 
     * @param lostFoundID 
     */
    public void setLostFoundID(String lostFoundID){
        this.lostFoundID.set(lostFoundID);
    }
}
