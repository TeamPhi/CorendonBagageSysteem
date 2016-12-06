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
     * @param type
     * @param brand
     * @param newColour
     * @param registerDate
     * @param status
     * @param newPicture
     */
    public LostLuggage(String newLabelNumber, String newFlightnumber,
            String newDestination, LuggageEnum type, String brand, String newColour,
            Date registerDate, StatusEnum status,
            String newPicture) {
        super(newLabelNumber, newFlightnumber, newDestination, type, brand, newColour, registerDate, status, newPicture);
    }

}
