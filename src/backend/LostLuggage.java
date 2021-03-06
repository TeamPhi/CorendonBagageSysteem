package backend;

/**
 * This class is used to create instances of lost luggage pieces.
 *
 * @author Elwin Slokker
 * @author Jordy Quak
 */
public class LostLuggage extends Luggage {

    /**
     * @param luggageID The ID of this entry in the database.
     * @param labelNumber The label number or ID found that was given to the
     * luggage.
     * @param flightNumber The flightnubmer of the airplane the luggage was on.
     * @param airport
     * @param destination The place where the the luggage should go to.
     * @param type What kind of luggage it is.
     * @param brand The brand of the luggage.
     * @param color Color of the luggage.
     * @param date The date of registration.
     * @param status A field specifying the status.
     */
    public LostLuggage(String luggageID, String labelNumber, String flightNumber, String airport, 
            String destination, String type, String brand, String color, 
            String date, String status) {
        super(luggageID, labelNumber, flightNumber, airport, destination, type, brand, color, date, status);
    }
    /**A string representation of the object.
     * 
     * @return The value of every property separated by spaces.
     */
    @Override
    public String toString(){
        return getLuggageID() + " " + getLabelNumber() + " " + getFlightNumber() +
                getAirport() + " " + getDestination() + " " + getType() + " " +
                getBrand() + " " + getColor() + " " +  getDate() + " " + 
                getStatus();
    }
}
