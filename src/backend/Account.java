package backend;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Enes Öztürk
 * @author Elwin Slokker
 */
public class Account {
    
    //private SimpleStringProperty userID; 
    //the userID can be uncommented to use it.
    private SimpleStringProperty username;    
    private SimpleStringProperty password;    
    private SimpleStringProperty privilege;    
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty email;

    /**This constructor creates an account object.
     * 
     
     * @param newUsername The username.
     * @param newPassword The password.
     * @param newPrivilege Which role the user has.
     * @param name The name of the employee.
     * @param surname
     * @param newEmail Email of the account.
     */
    public Account( String newUsername, String newPassword, 
            String newPrivilege, String name, String surname, String newEmail){
     //   this.userID = new SimpleStringProperty(newUserID);
        this.username = new SimpleStringProperty(newUsername);
        this.password = new SimpleStringProperty(newPassword);
        this.privilege = new SimpleStringProperty(newPrivilege);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.email = new SimpleStringProperty(newEmail);
    }

    
//    public String getUserID() {
//        return this.userID.get();
//    }
    
    public String getUsername() {
        return this.username.get();
    }

    public String getPassword() {
        return this.password.get();
    }   
    
    public String getPrivilege() {
        return this.privilege.get();
    }
    
    public String getName() {
        return this.name.get();
    }
    public String getSurname() {
        return this.surname.get();
    }
    
    public String getEmail() {
        return this.email.get();
    }
    
    
//    public void setUserID(String userID) {
//        this.userID.set(userID);
//    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public void setPrivilege(String privilege) {
        this.privilege.set(privilege);
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    
    public void setSurname(String surname) {
        this.surname.set(surname);
    }
    
    public void setEmail(String email) {
        this.email.set(email);
    }
    
}   