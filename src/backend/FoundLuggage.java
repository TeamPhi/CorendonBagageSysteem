package backend;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author Elwin Slokker 
 * @author Jordy Quak
 */
public class FoundLuggage extends Luggage{
    /*
    * Only found luggage has a new field in in comparison to it's parent.
    * It is a number given to a piece of Luggage by the stockroom.
    */
    private final SimpleStringProperty lostFoundID;

    /**
     * Create a new piece of luggage that has been found on an airport.
     * The arguments are optional.
     * 
     * @param labelNumber The label number or ID found that was given to the luggage.
     * @param flightNumber The flightnubmer of the airplane the luggage was on.
     * @param airport The name of the airport where the Luggage was found.
     * @param lostFoundID The ID given by the founder.
     * @param destination The place where the the luggage should go to.
     * @param type What kind of luggage it is.
     * @param brand The brand of the luggage.
     * @param color Color of the luggage.
     * @param date The date of the day the luggage was found.
     * @param status A field specifying the status.
     */
    public FoundLuggage(String luggageID, String labelNumber, String flightNumber, String airport, String lostFoundID, String destination, String type, String brand, String color, String date, String status) {
        super(luggageID, labelNumber, flightNumber, airport, destination, type, brand, color, date, status);
        this.lostFoundID = new SimpleStringProperty(lostFoundID);
    }

    public String getLostFoundID(){
        return this.lostFoundID.get();
    }

    public void setLostFoundID(String lostFoundID){
        this.lostFoundID.set(lostFoundID);
    }
    
    public StringProperty lostFoundIDProperty() {
        return lostFoundID;
    }
}
