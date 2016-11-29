package backend;

import java.util.Date;

/**
 *
 * @author Elwin Slokker
 */
public class LostLuggage extends Luggage{
    
    public LostLuggage(String newLabelNumber, String newFlightnumber, String newDestination, LuggageEnum kind, String newColour, String newLostFoundID,Date foundDate, StatusEnum status, String newPicture){
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
