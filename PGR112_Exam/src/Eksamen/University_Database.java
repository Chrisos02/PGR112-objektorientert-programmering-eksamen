package Eksamen;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Static block
public class University_Database {
    static {
        try {
            DriverManager.registerDriver(new Driver()); //This register the jdbc driver
        } catch (SQLException e) { // a runtime exceptions will run if there is an error while registering
            throw new RuntimeException(e);
        }
    }

    // Method
    static Connection getconnection() {
        try { // By using this method, it attempts to make a connection with database using URL
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/universitydb?allowPublicKeyRetrieval=true&useSSL=false",
                    "universitydb",
                    "password"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e); // If any sql-error appears, the program stops and shows an error
        }
    }


}
 //# This class provides a simple connection to mySQL database

//#Refrence: kristiania/PGR112-23V/tree/master/code/lectures/_18