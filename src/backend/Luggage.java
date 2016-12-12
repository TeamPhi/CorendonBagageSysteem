package backend;

import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**This class provides the basic attributes and mutators for a piece of luggage.
 *
 * @author Elwin Slokker
 */
public abstract class Luggage {
    /*
    Properties are a sort of java wrappers.
    They are mostly used to bind a 'property' to a element/control.
    */
    private final SimpleStringProperty labelNumber;
    private final SimpleStringProperty flightnumber;
    //The airport where the luggage was found, or reported missing.
    private final SimpleStringProperty registeredAirport;
    private final SimpleStringProperty destination;
    private final SimpleObjectProperty<LuggageEnum> type;
    private final SimpleStringProperty brand;
    private final SimpleStringProperty color;
    private final SimpleObjectProperty<Date> date;
    private final SimpleObjectProperty<StatusEnum> status;
    private final SimpleStringProperty picture;
    private char[] features;
    
    /**This constructor creates a luggage object.
     * 
     * @param newLabelNumber The label number or ID found that was given to the luggage.
     * @param newFlightnumber The flightnubmer of the airplane the luggage was on.
     * @param newDestination The place where the the luggage should go to.
     * @param type What kind of luggage it is.
     * @param brand The brand of the luggage.
     * @param newColor Color of the luggage.
     * @param date The date of registration or found date.
     * @param status A field specifying the status.
     * @param newPicture Path to a local picture.
     */
    public Luggage(String newLabelNumber, String newFlightnumber, 
            String newDestination, LuggageEnum type, String brand, String newColor, 
            Date date, StatusEnum status, 
            String newPicture){
        this.labelNumber = new SimpleStringProperty(newLabelNumber);
        this.flightnumber = new SimpleStringProperty(newFlightnumber);
        this.registeredAirport = new SimpleStringProperty(newDestination);
        this.destination = new SimpleStringProperty(newDestination);
        this.type = new SimpleObjectProperty(type);
        this.brand = new SimpleStringProperty(brand);
        this.color  = new SimpleStringProperty(newColor);
        this.picture = new SimpleStringProperty(newPicture);
        this.date = new SimpleObjectProperty(date);
        this.status = new SimpleObjectProperty(status);
        this.features = new char[500];//500 is the maximum amount of characters that fit in the database field.
    }

    public String getLabelNumber(){
        return this.labelNumber.get();
    }

    public String getFlightNumber(){
        return this.flightnumber.get();
    }

    public String getRegisteredAirport(){
        return this.registeredAirport.get();
    }

    public String getDestination(){
        return this.destination.get();
    }

    public LuggageEnum getType(){
        return this.type.get();
    }

    public String getBrand(){
        return this.brand.get();
    }

    public String getColor(){
        return this.color.get();
    }

    public Date getDate(){
        return this.date.get();
    }

    public StatusEnum getStatus(){
        return this.status.get();
    }

    public String getPicture(){
        return this.picture.get();
    }

    public char[] getFeatures(){
        return this.features;
    }

    public void setLabelNumber(String labelNumber){
        this.labelNumber.set(labelNumber);
    }

    public void setFlightNumber(String flightNumber){
        this.labelNumber.set(flightNumber);
    }

    public void setRegisteredAirport(String airport){
        this.registeredAirport.set(airport);
    }

    public void setDestination(String destination){
        this.labelNumber.set(destination);
    }

    public void setType(LuggageEnum type){
        this.type.set(type);
    }

    public void setColor(String color){
        this.color.set(color);
    }

    public void setDate(Date date){
        this.date.set(date);
    }

    public void changeStatus(StatusEnum status){
        this.status.set(status);
    }

    public void setPicture(String picture){
        this.picture.set(picture);
    }

    public void setFeatures(char[] features){
        this.features = features;
    }
        public void setFeatures(String features){
        this.features = features.toCharArray();
    }
}
