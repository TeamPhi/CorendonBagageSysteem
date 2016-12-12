package backend;

import java.util.Date;

/**This class is used to create instances of lost luggage pieces.
 *
 * @author Elwin Slokker
 */
public class LostLuggage extends Luggage {

    /**
     * Create a new missing piece of luggage.
     *
     * @param newLabelNumber The label number or ID found that was given to the luggage.
     * @param newFlightnumber The flightnubmer of the airplane the luggage was on.
     * @param newDestination The place where the the luggage should go to.
     * @param type What kind of luggage it is.
     * @param brand The brand of the luggage.
     * @param newColor Color of the luggage.
     * @param registerDate The date of registration.
     * @param status A field specifying the status.
     * @param newPicture Path to a local picture.
     */
    public LostLuggage(String newLabelNumber, String newFlightnumber,
            String newDestination, LuggageEnum type, String brand, String newColor,
            Date registerDate, StatusEnum status,
            String newPicture) {
        super(newLabelNumber, newFlightnumber, newDestination, type, brand, newColor, registerDate, status, newPicture);
    }

}
