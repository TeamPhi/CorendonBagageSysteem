package backend;

import java.util.Date;

/**
 *
 * @author Elwin Slokker
 */
public abstract class Luggage {
    protected String labelNumber;
    protected String flightnumber;
    protected String registeredAirport;//The airport where the luggage was found, or reported missing.
    protected String destination;
    protected LuggageEnum kind;
    protected String colour;
    protected Date date;
    protected StatusEnum status;
    protected String picture;
    protected char[] features = new char[500];//500 is the maximum amount of characters that fit in the database field.
    Luggage(){
       //empty constructor; this class should not be made.
    }
    /**
     * 
     * @return 
     */
    public String getLabelNumber(){
        return this.labelNumber;
    }
    /**
     * 
     * @return 
     */
    public String getFlightNumber(){
        return this.flightnumber;
    }
    /**
     * 
     * @return The destination as String.
     */
    public String getDestination(){
        return this.destination;
    }
    /**
     * 
     * @return What kind of luggage (see LuggageEnum.java).
     */
    public LuggageEnum getKind(){
        return this.kind;
    }/**
     * 
     * @return A written colour.
     */
    public String getColour(){
        return this.colour;
    }
    /**
     *
     * @return 
     */
    public Date getDate(){
        return this.date;
    }
    /**
     * 
     * @return The status of the Luggage (see StatusEnum.java).
     */
    public StatusEnum getStatus(){
        return this.status;
    }
    /**
     * 
     * @return The path of the picture.
     */
    public String getPicture(){
        return this.picture;
    }
    /**
     * 
     * @param labelNumber A valid string representing a label number.
     */
    public void setLabelNumber(String labelNumber){
        this.labelNumber = labelNumber;
    }
    /**
     * 
     * @param flightNumber A valid string representing a flightnumber.
     */
    public void setFlightNumber(String flightNumber){
        this.labelNumber = flightNumber;
    }
    /**
     * 
     * @param destination A valid string representing an airport.
     */
    public void setDestination(String destination){
        this.labelNumber = destination;
    }
    /**
     * 
     * @param kind 
     */
    public void setKind(LuggageEnum kind){
        this.kind = kind;
    }
    /**
     * 
     * @param colour Colour of the luggage.
     */
    public void setColour(String colour){
        this.colour = colour;
    }
    /**
     * 
     * @param date Date at which the luggage was found/lost.
     */
    public void setDate(Date date){
        this.date = date;
    }
    /**
     * 
     * @param status The new status.
     */
    public void changeStatus(StatusEnum status){
        this.status = status;
    }
    /**
     * 
     * @param picture The path to the picture.
     */
    public void setPicture(String picture){
        this.picture = picture;
    }
}
