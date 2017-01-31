package controller;

import database.JDBC;
import model.Courses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by dewi on 11.10.16.
 */
public class CoursesDataHandler {

    private JDBC jdbc = new JDBC();

    public int insertCourse(Courses course) throws SQLException {

        try {
            jdbc.getDBConnection();

            String query = "INSERT INTO Courses(COURSETITLE, COURSECODE, DURATION) VALUES(?, ?, ?)";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);

            ps.setString(1, course.getCourseTitle());
            ps.setString(2, course.getCourseCode());
            ps.setLong(3, course.getDuration());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if (jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }
        }

        return 0;
    }


    public int updateCourse(Courses course, int id) throws SQLException {

        try {
            jdbc.getDBConnection();
            String query = "UPDATE Courses SET COURSETITLE = ?, COURSECODE = ?, DURATION = ? WHERE COURSEID = ?";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);
            ps.setString(1, course.getCourseTitle());
            ps.setString(2, course.getCourseCode());
            ps.setLong(3, course.getDuration());
            ps.setInt(4, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if (jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }

        }
        return 0;
    }

    public Courses getCourse(int id) throws SQLException {
        String query = "SELECT * FROM Courses WHERE COURSEID = ?";
        PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);
        ResultSet resultSet;
        Courses course = null;

        try {
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int courseId = resultSet.getInt("COURSEID");
                String courseTitle = resultSet.getString("COURSETITLE");
                String courseCode = resultSet.getString("COURSECODE");
                long duration = resultSet.getLong("DURATION");

                course = Courses.builder()
                        .courseId(courseId)
                        .courseTitle(courseTitle)
                        .courseCode(courseCode)
                        .duration(duration)
                        .build();

            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {

            if (jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }
        }

        return course;
    }

    public List<Courses> getAllCourses() throws SQLException {
        List<Courses> coursesList = new ArrayList();
        String query = "SELECT * FROM Courses";
        PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);
        ResultSet resultSet;

        try {
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int courseId = resultSet.getInt("COURSEID");
                String courseTitle = resultSet.getString("COURSETITLE");
                String courseCode = resultSet.getString("COURSECODE");
                long duration = resultSet.getLong("DURATION");

                Courses course = Courses.builder()
                        .courseId(courseId)
                        .courseTitle(courseTitle)
                        .courseCode(courseCode)
                        .duration(duration)
                        .build();

                coursesList.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if (jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }
        }

        return coursesList;
    }

    public int deleteCourse(int id) throws SQLException {
        try {
            jdbc.getDBConnection();
            String query = "DELETE FROM Courses WHERE COURSEID = ?";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {

            if (jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }
        }

        return 0;
    }


}
