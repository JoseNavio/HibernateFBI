import connection.ConnectionMySQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Main
 *
 * @author Jose L. Navío Mendoza
 */

public class Main {

    private static Connection connection;

    public static void main(String[] args) {

        //Generate a connection to the database
        connection = ConnectionMySQL.connect();
    }
}