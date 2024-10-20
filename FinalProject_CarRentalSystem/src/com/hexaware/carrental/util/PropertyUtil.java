package com.hexaware.carrental.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertyUtil {
	// Static method to read properties from a file and generate a connection string
    public static String getPropertyString(String propertiesFilePath) {
        Properties properties = new Properties();
        
        try (FileInputStream input = new FileInputStream(propertiesFilePath)) {
            // Load the properties file
            properties.load(input);
            
            // Get the individual properties
            String hostname = properties.getProperty("hostname");
            String dbname = properties.getProperty("dbname");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String port = properties.getProperty("port");

            // Construct the connection string
            return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s", 
                                  hostname, port, dbname, username, password);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


