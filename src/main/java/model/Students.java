package model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * Created by dewi on 10.10.16.
 */
@Data
@Builder
public class Students {

    private String firstName;
    private String lastName;
    private String accountNumber;
    List<Courses> coursesList;
    private Set<StudentsType> studentsTypes;

}
