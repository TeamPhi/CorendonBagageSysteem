package backend;

import java.util.Date;

/**
 *
 * @author Elwin Slokker
 */
public class LostLuggage extends Luggage{
    
    /** Create a new missing piece of luggage.
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
    public LostLuggage(String newLabelNumber, String newFlightnumber, 
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
    }
    
}
