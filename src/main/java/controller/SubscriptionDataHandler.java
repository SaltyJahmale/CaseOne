package controller;

import database.JDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


/**
 * Created by dewi on 12.10.16.
 */


public class SubscriptionDataHandler {

    private JDBC jdbc = new JDBC();

    public int insertSubscription(LocalDate startDate, int courseId, int studentId) throws SQLException {

        try {
            jdbc.getDBConnection();

            String query = "INSERT INTO STEVE.SUBSCRIPTION(STARTDATE, COURID, STUID) VALUES(?, ?, ?)";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);

            ps.setDate(1, Date.valueOf(startDate));
            ps.setInt(2, courseId);
            ps.setInt(3, studentId);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if(jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }
        }

        return 0;
    }


}
