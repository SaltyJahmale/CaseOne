package controller;

import model.Courses;
import model.Students;
import model.StudentsType;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by dewi on 10.10.16.
 */
public class CoursesTest {

    EnumSet<StudentsType> studentsTypesIndividual = EnumSet.of(StudentsType.INDIVIDUAL);

    @Test
    public void compareTheTitleName() {
        Courses courses = CoursesBuilderTest.coursesBuilder().build();
        courses.setCourseTitle("Java Development");

        assertThat(courses.getCourseTitle(), is("Java Development"));
    }

    @Test
    public void noEmptyList() {
        Students students = StudentsBuilderTest.studentsBuilder().build();
        List<Students> studentsList = new ArrayList<Students>();
        studentsList.add(students);

        Courses courses = CoursesBuilderTest.coursesBuilder().build();
        courses.setStudentsList(studentsList);

        assertThat(courses.getStudentsList(), notNullValue());
    }

    @Test
    public void insertCourseQuery() throws SQLException {
        CoursesDataHandler coursesDataHandler = new CoursesDataHandler();
        Courses courses = CoursesBuilderTest.coursesBuilder().build();
        int result = coursesDataHandler.insertCourse(courses);

        assertThat(result, is(1));

    }

    @Test
    public void updateCourseQuery() throws SQLException {
        CoursesDataHandler coursesDataHandler = new CoursesDataHandler();
        Courses courses = CoursesBuilderTest.coursesBuilder().courseTitle("Python").courseCode("ABCD").build();
        int result = coursesDataHandler.updateCourse(courses, 1);

        assertThat(result, is(1));

    }

    @Test
    public void getCourseQuery() throws SQLException {
        CoursesDataHandler coursesDataHandler = new CoursesDataHandler();
        Courses result = coursesDataHandler.getCourse(1);

        assertThat(result.getCourseTitle(), is("Python"));

    }

    @Test
    public void deleteCourseQuery() throws SQLException {
        CoursesDataHandler coursesDataHandler = new CoursesDataHandler();
        int result = coursesDataHandler.deleteCourse(1);

        assertThat(result, is(1));

    }


}
