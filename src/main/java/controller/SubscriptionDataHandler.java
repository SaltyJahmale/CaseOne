package controller;

import database.JDBC;
import model.Subscription;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by dewi on 12.10.16.
 */


public class SubscriptionDataHandler {

    private JDBC jdbc = new JDBC();

    public List<Subscription> getAllSubscriptions() throws SQLException {
        List<Subscription> subscriptionList = new ArrayList();
        String query = "SELECT * FROM Subscription";
        PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);
        ResultSet resultSet;

        try {
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                Date date = resultSet.getDate("STARTDATE");
                int courseId = resultSet.getInt("COURSEID");
                int stundentId = resultSet.getInt("STUDENTID");


                Subscription students = Subscription.builder()
                        .id(id)
                        .startDate(date.toLocalDate())
                        .courseId(courseId)
                        .studentId(stundentId)
                        .build();

                subscriptionList.add(students);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if(jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }
        }

        return subscriptionList;
    }

    public int insertSubscription(Subscription subscription) throws SQLException {

        try {
            jdbc.getDBConnection();

            String query = "INSERT INTO Subscription(STARTDATE, COURSEID, STUDENTID) VALUES(?, ?, ?)";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);

            ps.setDate(1, Date.valueOf(subscription.getStartDate()));
            ps.setInt(2, subscription.getCourseId());
            ps.setInt(3, subscription.getStudentId());

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
