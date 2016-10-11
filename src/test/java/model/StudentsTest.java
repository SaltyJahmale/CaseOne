package model;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import java.util.EnumSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by dewi on 10.10.16.
 */
public class StudentsTest {

    EnumSet<StudentsType> studentsTypesBusiness = EnumSet.of(StudentsType.BUSINESS);
    EnumSet<StudentsType> studentsTypesIndividual = EnumSet.of(StudentsType.INDIVIDUAL);


    @Test
    public void compareTheFirstNameOfTheStudent() {
        Students students = StudentsBuilderTest.studentsBuilder().studentsTypes(studentsTypesBusiness).build();
        students.setFirstName("Martin");

        assertThat(students.getFirstName(), is("Martin"));

    }

    @Test
    public void compareTheEnumTypeIndividual() {
        Students students = StudentsBuilderTest.studentsBuilder().studentsTypes(studentsTypesIndividual).build();
        students.setStudentsTypes(studentsTypesIndividual);

        assertThat(students.getStudentsTypes(), CoreMatchers.<Set<StudentsType>>is(studentsTypesIndividual));
    }



}
