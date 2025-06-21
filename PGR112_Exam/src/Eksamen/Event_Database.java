package Eksamen;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Static block
   public class Event_Database {
     static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }

    // METHOD
    static Connection getconnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/eventdb?allowPublicKeyRetrieval=true&useSSL=false",
                    "ueventdb",
                    "password"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

//Reference: kristiania/PGR112-23V/tree/master/code/lectures/_18