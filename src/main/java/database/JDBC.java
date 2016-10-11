package database;

import jdk.nashorn.internal.ir.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dewi on 10.10.16.
 */
public class JDBC {

    private String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/XE";
    private String userid = "steve";
    private String password = "0000";
    Connection connection;

    Statement stmt;
    ResultSet rset;
    String query;
    String sqlString;


    public void getDBConnection() throws SQLException {

        connection = DriverManager.getConnection(jdbcUrl, userid, password);
    }

}
