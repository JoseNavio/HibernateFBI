package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ConnectionMySQL
 *
 * @author Jose L. Navío Mendoza
 */

public class ConnectionMySQL {

    public static Connection connection;

    public static Connection connect() {

        try {
            FileInputStream envFile = new FileInputStream("src/main/resources/.env");
            Properties properties = new Properties();
            properties.load(envFile);
            Class.forName(properties.getProperty("DRIVERNAME"));

            connection = DriverManager.getConnection(
                    properties.getProperty("URL"),
                    properties.getProperty("USERNAME"),
                    properties.getProperty("PASSWORD"));

            System.out.println("Connected.");

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
