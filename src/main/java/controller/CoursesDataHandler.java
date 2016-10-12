package controller;

import database.JDBC;
import model.Courses;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by dewi on 11.10.16.
 */
public class CoursesDataHandler {

    private JDBC jdbc = new JDBC();


    public int insertCours(Courses cours) throws SQLException {

        try {
            jdbc.getDBConnection();

            String query = "INSERT INTO STEVE.COURSES(COURSETITLE, COURSECODE, DURATION) VALUES(?, ?, ?)";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);

            ps.setString(1, cours.getCourseTitle());
            ps.setString(2, cours.getCourseCode());
            ps.setLong(3, cours.getDuration());

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


    public int updateCours(Courses cours, int id) throws SQLException{

        try {
            jdbc.getDBConnection();
            String query = "UPDATE STEVE.COURSES SET COURSETITLE = ?, COURSECODE = ?, DURATION = ? WHERE COURSEID = ?";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);
            ps.setString(1, cours.getCourseTitle());
            ps.setString(2, cours.getCourseCode());
            ps.setLong(3, cours.getDuration());
            ps.setInt(4, id);
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

    public Courses getCours(int id) throws SQLException {
        String query = "SELECT * FROM STEVE.COURSES WHERE COURSEID = ?";
        PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);
        ResultSet resultSet;
        Courses course = null;

        try {
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                String courseTitle = resultSet.getString("COURSETITLE");
                String courseCode = resultSet.getString("COURSECODE");
                long duration = resultSet.getLong("DURATION");

                course = Courses.builder()
                        .courseTitle(courseTitle)
                        .courseCode(courseCode)
                        .duration(duration)
                        .build();

            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {

            if(jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }
        }

        return course;
    }

    public int deleteCours(int id) throws SQLException {
        try {
            jdbc.getDBConnection();
            String query = "DELETE FROM STEVE.COURSES WHERE COURSEID = ?";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);
            ps.setInt(1, id);
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
