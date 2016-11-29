package backend;

/*
 * In this file you can find all the commands that are used to gather and 
 * initialise all the information about the traveller.
 */

import java.util.List;
/**
 *
 * @author Enes
 */
public class Passenger {

    private String name;
    private String address;
    private String city;
    private String zipCode;
    private String country;
    private int phoneNumber;
    private String email;
    private String flightNumber;
    private String destination;
    private List<LostLuggage> lostLuggage;
    //The list has a getter, a remover and an adder but no setter.
    
    public Passenger(String newName, String newAddress, String newCity, 
            String newZipCode, String newCountry, int newPhoneNumber, 
            String newEmail, String newFlightNumber, String newDestination) {
        this.name = newName;
        this.address = newAddress;
        this.city = newCity;
        this.zipCode = newZipCode;
        this.country = newCountry;
        this.phoneNumber = newPhoneNumber;
        this.email = newEmail;
        this.flightNumber = newFlightNumber;
        this.destination = newDestination;
        this.lostLuggage = ArrayList(LostLuggage);
    }
    
    public Passenger(String newFlightNumber, String newDestination, List newLostLuggage) {
        this.flightNumber = newFlightNumber;
        this.destination = newDestination;
        this.lostLuggage = newLostLuggage;
    }
    
    public String getName() {
        return this.name;
    }        
    
    public String getAddress() {
        return this.address;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public String getZipCode() {
        return this.zipCode;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public int getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getFlightNumber() {
        return this.flightNumber;
    }
    
    public String getDestination() {
        return this.destination;
    }
    
    public List getLostLuggage() {
        return this.lostLuggage;
    }
    
    //hier komen nog een remover en een adder.
    
    public void setName(String name) {
        this.name = name;
    }
    
     public void setAddress(String address) {
        this.address = address;
    }
    
      public void setCity(String city) {
        this.city = city;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    //dit vervangt voorlopig de adder en de remover.
    public void addLostLuggage(LostLuggage newLostLuggage) {
        this.lostLuggage.add(newLostLuggage);
    }
    
    public void removeLostLuggage(LostLuggage toBeRemovedLostLuggage) {
        this.lostLuggage.remove(toBeRemovedLostLuggage);
    }
}
