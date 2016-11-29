package backend;

import java.util.Date;

/**
 *
 * @author Elwin Slokker
 */
public abstract class Luggage {
    protected String labelNumber;
    protected String flightnumber;
    protected String destination;
    protected LuggageEnum kind;
    protected String colour;
    protected Date date;
    protected StatusEnum status;
    protected String picture;
    
    public Luggage(){
       
    }
    public String getLabelNumber(){
        return this.labelNumber;
    }
    public String getFlightNumber(){
        return this.flightnumber;
    }
    public String getDestination(){
        return this.destination;
    }
    public LuggageEnum getKind(){
        return this.kind;
    }
    public String getColour(){
        return this.colour;
    }
    public Date getDate(){
        return this.date;
    }
    public StatusEnum getStatus(){
        return this.status;
    }
    public String getPicture(){
        return this.picture;
    }
    public void setLabelNumber(String labelNumber){
        this.labelNumber = labelNumber;
    }
    public void setFlightNumber(String flightNumber){
        this.labelNumber = flightNumber;
    }
    public void setDestination(String destination){
        this.labelNumber = destination;
    }
    public void setKind(LuggageEnum kind){
        this.kind = kind;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void changeStatus(StatusEnum status){
        this.status = status;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }
}
