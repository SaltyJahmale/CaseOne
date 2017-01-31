package controller;

import model.Students;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by dewi on 10.10.16.
 */
public class StudentsTest {

    @Test
    public void compareTheFirstNameOfTheStudent() {
        Students students = StudentsBuilderTest.studentsBuilder().build();
        students.setFirstName("Martin");

        assertThat(students.getFirstName(), is("Martin"));

    }

    @Test
    public void compareTheEnumTypeIndividual() {
        Students students = StudentsBuilderTest.studentsBuilder().build();

        assertThat(students.getStudentsTypes(), is(students.getStudentsTypes()));
    }

    @Test
    public void insertStudentQuery() throws SQLException {
        StudentsDataHandler studentsDataHandler = new StudentsDataHandler();
        Students students = StudentsBuilderTest.studentsBuilder().build();
        int result = studentsDataHandler.insertStudent(students);

        assertThat(result, is(1));
    }

    @Test
    public void updateStudentQuery() throws SQLException {
        StudentsDataHandler studentsDataHandler = new StudentsDataHandler();
        Students students = StudentsBuilderTest.studentsBuilder().firstName("Yusuf").lastName("Yusuf").build();
        int result = studentsDataHandler.updateStudent(students, 21);

        assertThat(result, greaterThan(0));

    }

    @Test
    public void getStudentQuery() throws SQLException {
        StudentsDataHandler studentsDataHandler = new StudentsDataHandler();
        Students student = studentsDataHandler.getStudent(21);
        System.out.println(student);
        assertThat(student.getFirstName(), is("Martin"));
    }

    @Test
    public void deleteStudentQuery() throws SQLException {
        StudentsDataHandler studentsDataHandler = new StudentsDataHandler();
        int result = studentsDataHandler.deleteStudent(3);

        assertThat(result, is(1));
    }


}
