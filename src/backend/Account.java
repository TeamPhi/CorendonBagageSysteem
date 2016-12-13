package backend;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;


/**
 *
 * @author Enes Öztürk
 */
public class Account {
    
    //private SimpleStringProperty userID;    
    private SimpleStringProperty username;    
    private SimpleStringProperty password;    
    private SimpleStringProperty role;    
    private SimpleStringProperty name;
    private SimpleStringProperty email;

    /**This constructor creates an account object.
     * 
     * @param newUserID The ID that is given to the User.
     * @param newUsername The username.
     * @param newPassword The password.
     * @param newRole Which role the user has.
     * @param newName The name of the employee.
     * @param newEmail Email of the account.
     */
    public Account(String newUserID, String newUsername, String newPassword, 
            String newRole, String newName, String newEmail){
     //   this.userID = new SimpleStringProperty(newUserID);
        this.username = new SimpleStringProperty(newUsername);
        this.password = new SimpleStringProperty(newPassword);
        this.role = new SimpleStringProperty(newRole);
        this.name = new SimpleStringProperty(newName);
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
    
    public String getRole() {
        return this.role.get();
    }
    
    public String getName() {
        return this.name.get();
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

    public void setRole(String role) {
        this.role.set(role);
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    
    public void setEmail(String email) {
        this.email.set(email);
    }
    
}   