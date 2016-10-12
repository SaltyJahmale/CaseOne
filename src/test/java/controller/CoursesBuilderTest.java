package controller;

import model.Courses;
import model.Students;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by dewi on 10.10.16.
 */
public class CoursesBuilderTest {
    public static Courses.CoursesBuilder coursesBuilder () {
        return Courses.builder()
                .courseTitle("Java")
                .courseCode("CNETIN")
                .duration(1)
                .studentsList(new ArrayList<Students>());
    }
}
