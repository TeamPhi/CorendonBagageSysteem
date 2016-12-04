package backend;

import java.util.Date;

/**
 *
 * @author Elwin Slokker
 */
public class LostLuggage extends Luggage {

    /**
     * Create a new missing piece of luggage.
     *
     * @param newLabelNumber
     * @param newFlightnumber
     * @param newDestination
     * @param kind
     * @param newColour
     * @param registerDate
     * @param status
     * @param newPicture
     */
    public LostLuggage(String newLabelNumber, String newFlightnumber,
            String newDestination, LuggageEnum kind, String newColour,
            Date registerDate, StatusEnum status,
            String newPicture) {
        super(newLabelNumber, newFlightnumber, newDestination, kind, newColour, registerDate, status, newPicture);
    }

}
