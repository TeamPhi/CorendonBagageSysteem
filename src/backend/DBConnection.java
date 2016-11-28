package backend;

/**
 *
 * @author Jordy Quak
 */
import java.sql.*;

public class DBConnection {

    Connection conn = null;

    public static Connection ConnecrDb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("dbc:mysql://localhost:3306/<database>", "root", "PASSWORD");
            System.out.println("Connection success!");
            return conn;

        } catch (Exception e) {
            System.out.println(e);
            return null;

        }

    }

}
