package backend;

import java.util.Date;
/**
 *
 * @author Elwin Slokker
 */
public class FoundLuggage extends Luggage{
    /*
    * Only found luggage has a new field in in comparison to it's parent.
    * It is a number given to a piece of Luggage by the stockroom.
    */
    String lostFoundID;
    /**Create a new piece of luggage that has been found on an airport.
     * 
     * @param newLabelNumber 
     * @param newFlightnumber
     * @param newDestination
     * @param kind
     * @param newColour
     * @param newLostFoundID
     * @param foundDate
     * @param status
     * @param newPicture 
     */
    public FoundLuggage(String newLabelNumber, String newFlightnumber, 
            String newDestination, LuggageEnum kind, String newColour, 
            String newLostFoundID,Date foundDate, StatusEnum status, 
            String newPicture){
    this.labelNumber = newLabelNumber;
    this.flightnumber = newFlightnumber;
    this.destination = newDestination;
    this.kind = kind;
    this.colour = newColour;
    this.date = foundDate;
    this.status = status;
    this.picture = newPicture;
    this.lostFoundID = newLostFoundID;
    }
    public String getLostFoundID(){
        return this.lostFoundID;
    }
    public void setLostFoundID(String lostFoundID){
        this.lostFoundID = lostFoundID;
    }
}
