package controller;


import database.JDBC;
import model.Students;
import model.StudentsType;

import java.sql.*;

/**
 * Created by dewi on 11.10.16.
 */
public class StudentsDataHandler {

    private JDBC jdbc = new JDBC();

    public int insertStudent(Students student) throws SQLException {
        try {
            jdbc.getDBConnection();
            String query = "INSERT INTO STUDENTS(FIRSTNAME, LASTNAME, ACCOUNTNUMBER, STUDENTTYPE) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);

            ps.setString(1, student.getFirstName() );
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getAccountNumber());
            ps.setString(4, student.getStudentsTypes().name());

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


    public int updateStudent(Students student, int id) throws SQLException{
        try {
            jdbc.getDBConnection();
            String query = "UPDATE STUDENTS SET FIRSTNAME = ?, LASTNAME = ?, ACCOUNTNUMBER = ?, STUDENTTYPE = ? WHERE STUDENTID = ?";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getAccountNumber());
            ps.setString(4, student.getStudentsTypes().name());
            ps.setInt(5, id);

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

    public Students getStudent(int id) throws SQLException {

        String query = "SELECT * FROM STUDENTS WHERE STUDENTID = ?";
        PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);
        ResultSet resultSet;
        Students student = null;

        try {
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                String accountnumber = resultSet.getString("ACCOUNTNUMBER");
                StudentsType studentType = StudentsType.valueOf(resultSet.getString("STUDENTTYPE"));

                student = Students.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .accountNumber(accountnumber)
                    .studentsTypes(studentType)
                    .build();

            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {

            if(jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }
        }

        return student;
    }

    public int deleteStudent(int id) throws SQLException {
        try {
            jdbc.getDBConnection();
            String query = "DELETE FROM STUDENTS WHERE STUDENTID = ?";
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
