
package za.ac.cput.onlinereservationsystem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @Athini Ngquke
 */
public class DBConnection {
    public static Connection derbyConnection()throws SQLException, ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String dURL = "jdbc:derby://localhost:1527/TrainReservation;create=true";
        String username = "athiningquke";
        String password = "passwordAN";
        
        Connection con = DriverManager.getConnection(dURL,username,password);
        return con;
    }
}
