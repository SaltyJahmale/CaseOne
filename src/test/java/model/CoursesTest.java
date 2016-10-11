package model;

import org.junit.Ignore;
import org.junit.Test;
import java.time.LocalDate;
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

    @Ignore
    @Test
    public void oneTimeDate() {
        Courses courses = CoursesBuilderTest.coursesBuilder().build();
        courses.setStartDate(LocalDate.parse("2016-10-10"));

        assertThat(courses.getStartDate(), is(LocalDate.now()));
    }

    @Test
    public void noEmptyList() {
        Students students = StudentsBuilderTest.studentsBuilder().studentsTypes(studentsTypesIndividual).build();
        List<Students>  studentsList = new ArrayList<Students>();
        studentsList.add(students);

        Courses courses = CoursesBuilderTest.coursesBuilder().build();
        courses.setStudentsList(studentsList);

        assertThat(courses.getStudentsList(), notNullValue());
    }


}
