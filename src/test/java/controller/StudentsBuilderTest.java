package controller;

import model.Students;
import model.StudentsType;

import java.util.HashSet;

/**
 * Created by dewi on 10.10.16.
 */
public class StudentsBuilderTest {
    public static Students.StudentsBuilder studentsBuilder() {
        return Students.builder()
                .firstName("Yusuf")
                .lastName("Yusuf")
                .accountNumber("0123456789")
                .studentsTypes(StudentsType.INDIVIDUAL);
    }
}
