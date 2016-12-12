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
     * The arguments are optional.
     * 
     * @param newLabelNumber The label number or ID found that was given to the luggage.
     * @param newFlightnumber The flightnubmer of the airplane the luggage was on.
     * @param newDestination The place where the the luggage should go to.
     * @param type What kind of luggage it is.
     * @param brand The brand of the luggage.
     * @param newColor Color of the luggage.
     * @param newLostFoundID The ID given by the founder.
     * @param registerDate The date of the day the luggage was found.
     * @param status A field specifying the status.
     * @param newPicture Path to a local picture.
     */
    public FoundLuggage(String newLabelNumber, String newFlightnumber, 
            String newDestination, LuggageEnum type, String brand, String newColor, 
            String newLostFoundID,Date registerDate, StatusEnum status, 
            String newPicture){
        super(newLabelNumber, newFlightnumber, newDestination, type, brand, newColor, registerDate, status, newPicture);
        this.lostFoundID = new SimpleStringProperty(newLostFoundID);
    }
 
    public String getLostFoundID(){
        return this.lostFoundID.get();
    }

    public void setLostFoundID(String lostFoundID){
        this.lostFoundID.set(lostFoundID);
    }
}
