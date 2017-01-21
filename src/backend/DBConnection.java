package backend;

/**
 * This class establishes a connection to a specified database.
 *
 * @author Jordy Quak
 */
import java.sql.*;

public class DBConnection {

    private static Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/corendon_bagage";//Location of database
    private static String user = "root";//Username of database  
    private static String pass = "pepe123123";//Password of database 
    public static void setPassword(String password){pass = password;}
    //The length of varchar fields in the database:
    //-Passenger
    public static final int LENGTH_OF_NAME = 45;
    public static final int LENGTH_OF_ADDRESS = 45;
    public static final int LENGTH_OF_CITY = 45;
    public static final int LENGTH_OF_ZIPCODE = 10;
    public static final int LENGTH_OF_COUNTRY = 45;
    public static final int LENGTH_OF_TELEPHONE = 12;
    public static final int LENGTH_OF_EMAIL = 45;
    //-acount
    public static final int LENGTH_OF_REALNAME = 45;
    public static final int LENGTH_OF_SURNAME = 45;
    public static final int LENGTH_OF_PASSWORD = 45;
    public static final int LENGTH_OF_USERNAME = 45;
    public static final int LENGTH_OF_ROLE = 45;//privilege
    public static final int LENGTH_OF_WORKER_EMAIL = 45;
    //-luggage
    public static final int LENGTH_OF_FLIGHTID = 10;
    public static final int LENGTH_OF_AIRPORT = 45;
    public static final int LENGTH_OF_FEATURES = 500;
    public static final int LENGTH_OF_TYPE = 20;
    public static final int LENGTH_OF_BRAND = 45;
    public static final int LENGTH_OF_COLOR = 45;
    public static final int LENGTH_OF_DESTINATION = 45;

    /**
     *
     * @return A connection object which can be used to reach the database.
     */
    public static Connection connectDb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection success");
            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;

        }
    }

    public static void addFoundLuggage(String dbName, Date date,
            Time time, String airport) throws SQLException {
        Statement stmt = null;
        //query moet nog ingevoerd worden
        String addLuggage = ("INSERT INTO foundLuggage (date, time, airport) VALUES ("
                + date + ", \"" + time + "\", " + airport + ");");
        try {
            stmt = DBConnection.conn.createStatement();
            stmt.executeQuery(addLuggage);
        } catch (SQLException e) {

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
