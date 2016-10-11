package database;

import jdk.nashorn.internal.ir.Statement;
import jdk.nashorn.internal.scripts.JD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dewi on 11.10.16.
 */
public class DataHandler {

    PreparedStatement stmt;
    ResultSet rset;
    String query;
    String sqlString;

    JDBC jdbc = new JDBC();

    public void insertStudent() throws SQLException {
        jdbc.getDBConnection();
        stmt = jdbc.connection.prepareStatement("INSERT");


    }

}
