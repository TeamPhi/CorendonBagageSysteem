package backend;

import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class provides the basic attributes and mutators for a piece of luggage.
 *
 * @author Elwin Slokker
 * @author Jordy Quak
 */
public abstract class Luggage {
    /*
    These maybe removed, but I kept them just in case.
    public static final String LUGGAGEID_PROPERTY_NAME = "luggageID";
    public static final String LABEL_NUMBER_PROPERTY_NAME = "labelNumber";
    public static final String FLIGHT_NUMBER_PROPERTY_NAME = "flightNumber";
    public static final String AIRPORT_PROPERTY_NAME = "airport";
    public static final String DESTINATION_PROPERTY_NAME = "destination";
    public static final String TYPE_PROPERTY_NAME = "type";
    public static final String BRAND_PROPERTY_NAME = "brand";
    public static final String COLOR_PROPERTY_NAME = "color";
    public static final String DATE_PROPERTY_NAME = "date";
    public static final String STATUS_PROPERTY_NAME = "status";
    public static final String LAFID_PROPERTY_NAME = "lostFoundID";
    */ 
    
    /*
    Properties are a sort of java wrappers.
    They are mostly used to bind a 'property' to a element/control.
     */
    private final SimpleStringProperty luggageID;
    private final SimpleStringProperty labelNumber;
    private final SimpleStringProperty flightNumber;
    private final SimpleStringProperty airport;
    private final SimpleStringProperty destination;
    private final SimpleStringProperty type;
    private final SimpleStringProperty brand;
    private final SimpleStringProperty color;
    private final SimpleStringProperty date;
    private final SimpleStringProperty status;

    /**
     * This constructor creates a luggage object.
     *
     * @param labelNumber The label number or ID found that was given to the
     * luggage.
     * @param flightNumber The flightnubmer of the airplane the luggage was on.
     * @param airport
     * @param destination The place where the the luggage should go to.
     * @param type What kind of luggage it is.
     * @param brand The brand of the luggage.
     * @param color Color of the luggage.
     * @param date The date of registration or found date.
     * @param status A field specifying the status.
     */
    public Luggage(String luggageID, String labelNumber, String flightNumber, String airport,
            String destination, String type, String brand, String color,
            String date, String status) {
        this.luggageID = new SimpleStringProperty(luggageID);
        this.labelNumber = new SimpleStringProperty(labelNumber);
        this.flightNumber = new SimpleStringProperty(flightNumber);
        this.airport = new SimpleStringProperty(airport);
        this.destination = new SimpleStringProperty(destination);
        this.type = new SimpleStringProperty(type);
        this.brand = new SimpleStringProperty(brand);
        this.color = new SimpleStringProperty(color);
        this.date = new SimpleStringProperty(date);
        this.status = new SimpleStringProperty(status);
    }
    
    public String getLuggageID() {
        return luggageID.get();
    }
    
    public String getLabelNumber() {
        return labelNumber.get();
    }

    public String getFlightNumber() {
        return flightNumber.get();
    }

    public String getAirport() {
        return airport.get();
    }

    public String getDestination() {
        return destination.get();
    }

    public String getType() {
        return type.get();
    }

    public String getBrand() {
        return brand.get();
    }

    public String getColor() {
        return color.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getStatus() {
        return status.get();
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber.set(labelNumber);
    }

    public void setFlightNumber(String flightNumber) {
        this.labelNumber.set(flightNumber);
    }

    public void setAirport(String airport) {
        this.airport.set(airport);
    }

    public void setDestination(String destination) {
        this.labelNumber.set(destination);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public StringProperty labelNumberProperty() {
        return labelNumber;
    }

    public StringProperty flightNumberProperty() {
        return flightNumber;
    }

    public StringProperty airportProperty() {
        return airport;
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    public StringProperty typeProperty() {
        return type;
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public StringProperty colorProperty() {
        return color;
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty statusProperty() {
        return status;
    }
    /**The toString() method is declared abstract here, so both luggage types can
     * have toString() called without problems.
     * @return 
     */
    @Override
    public abstract String toString();
}
