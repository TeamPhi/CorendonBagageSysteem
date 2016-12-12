package backend;

/**
 * This class establishes a connection to a specified database.
 *
 * @author Jordy Quak
 */
import java.sql.*;

public class DBConnection {

    private static Connection conn;
    private static String url = "dbc:mysql://localhost:3306/<database>";//Location of database
    private static String user = "root";//Username of database  
    private static String pass = "password";//Password of database 
    public static final int LENGTH_OF_NAME = 45;
    public static final int LENGTH_OF_ADDRESS = 45;
    public static final int LENGTH_OF_CITY = 45;
    public static final int LENGTH_OF_ZIPCODE = 10;
    public static final int LENGTH_OF_COUNTRY = 45;
    public static final int LENGTH_OF_TELEPHONE = 12;
    public static final int LENGTH_OF_EMAIL = 45;

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
        String addLuggage = ("INSERT INTO foundLuggage (date, time, airport) VALUES (" +
                date + ", \"" + time + "\", " + airport + ");");
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
