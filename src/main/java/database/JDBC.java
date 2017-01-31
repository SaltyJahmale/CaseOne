package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dewi on 10.10.16.
 */
public class JDBC {

    private String jdbcUrl = "jdbc:mariadb://localhost:3306/caseone";
    private String userid = "root";
    private String password = "0000";
    Connection connection;

    public Connection getDBConnection() {

        try {

            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, userid, password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        return connection;

    }

}
