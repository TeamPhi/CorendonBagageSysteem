package backend;

/**
 * This class establishes a connection to a specified database.
 * @author Jordy Quak
 */
import java.sql.*;

public class DBConnection {

    private static Connection conn;  
    private static String url = "dbc:mysql://localhost:3306/<database>";//Location of database
    private static String user = "root";//Username of database  
    private static String pass = "password";//Password of database 

    public static Connection ConnectDb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection success");
            return conn;

        } catch (Exception e) {
            System.out.println(e);
            return null;

        }

    }

}
