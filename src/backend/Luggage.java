package backend;

import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Elwin Slokker
 */
public abstract class Luggage {
    private final SimpleStringProperty labelNumber;
    private final SimpleStringProperty flightnumber;
    //The airport where the luggage was found, or reported missing.
    private final SimpleStringProperty registeredAirport;
    private final SimpleStringProperty destination;
    private final SimpleObjectProperty<LuggageEnum> kind;
    private final SimpleStringProperty color;
    private final SimpleObjectProperty<Date> date;
    private final SimpleObjectProperty<StatusEnum> status;
    private final SimpleStringProperty picture;
    private char[] features;
    
    /**
     * 
     * @param date 
     */
    public Luggage(String newLabelNumber, String newFlightnumber, 
            String newDestination, LuggageEnum kind, String newColour, 
            Date date, StatusEnum status, 
            String newPicture){
        this.labelNumber = new SimpleStringProperty(newLabelNumber);
        this.flightnumber = new SimpleStringProperty(newFlightnumber);
        this.registeredAirport = new SimpleStringProperty(newDestination);
        this.destination = new SimpleStringProperty(newDestination);
        this.kind = new SimpleObjectProperty(kind);
        this.color  = new SimpleStringProperty(newColour);
        this.picture = new SimpleStringProperty(newPicture);
        this.date = new SimpleObjectProperty(date);
        this.status = new SimpleObjectProperty(status);
        this.features = new char[500];//500 is the maximum amount of characters that fit in the database field.
    }
    /**
     * 
     * @return 
     */
    public String getLabelNumber(){
        return this.labelNumber.get();
    }
    /**
     * 
     * @return 
     */
    public String getFlightNumber(){
        return this.flightnumber.get();
    }
    /**
     * 
     * @return 
     */
    public String getRegisteredAirport(){
        return this.registeredAirport.get();
    }
    /**
     * 
     * @return The destination as String.
     */
    public String getDestination(){
        return this.destination.get();
    }
    /**
     * 
     * @return What kind of luggage (see LuggageEnum.java).
     */
    public LuggageEnum getKind(){
        return this.kind.get();
    }/**
     * 
     * @return A written colour.
     */
    public String getColor(){
        return this.color.get();
    }
    /**
     *
     * @return 
     */
    public Date getDate(){
        return this.date.get();
    }
    /**
     * 
     * @return The status of the Luggage (see StatusEnum.java).
     */
    public StatusEnum getStatus(){
        return this.status.get();
    }
    /**
     * 
     * @return The path of the picture.
     */
    public String getPicture(){
        return this.picture.get();
    }
    /**
     * 
     * @return 
     */
    public char[] getFeatures(){
        return this.features;
    }
    /**
     * 
     * @param labelNumber A valid string representing a label number.
     */
    public void setLabelNumber(String labelNumber){
        this.labelNumber.set(labelNumber);
    }
    /**
     * 
     * @param flightNumber A valid string representing a flightnumber.
     */
    public void setFlightNumber(String flightNumber){
        this.labelNumber.set(flightNumber);
    }
    /**
     * 
     * @param airport 
     */
    public void setRegisteredAirport(String airport){
        this.registeredAirport.set(airport);
    }
    /**
     * 
     * @param destination A valid string representing address or airport.
     */
    public void setDestination(String destination){
        this.labelNumber.set(destination);
    }
    /**
     * 
     * @param kind 
     */
    public void setKind(LuggageEnum kind){
        this.kind.set(kind);
    }
    /**
     * 
     * @param color Colour of the luggage.
     */
    public void setColor(String color){
        this.color.set(color);
    }
    /**
     * 
     * @param date Date at which the luggage was found/lost.
     */
    public void setDate(Date date){
        this.date.set(date);
    }
    /**
     * 
     * @param status The new status.
     */
    public void changeStatus(StatusEnum status){
        this.status.set(status);
    }
    /**
     * 
     * @param picture The path to the picture.
     */
    public void setPicture(String picture){
        this.picture.set(picture);
    }
    /**
     * 
     */
    public void setFeatures(char[] features){
        this.features = features;
    }
        public void setFeatures(String features){
        this.features = features.toCharArray();
    }
}
