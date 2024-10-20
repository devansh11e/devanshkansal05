package com.hexaware.carrental.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	// Static variable to hold the database connection
    private static Connection connection = null;

    // Static method to get the database connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Get the connection string from PropertyUtil
                String connectionString = PropertyUtil.getPropertyString("db.properties");

                if (connectionString != null) {
                    // Establish the connection
                    connection = DriverManager.getConnection(connectionString);
                    System.out.println("Connection established successfully.");
                } else {
                    System.out.println("Failed to retrieve connection string.");
                }

            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Failed to establish a connection to the database.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        // Test the connection
        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println("Connected to the database.");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}


