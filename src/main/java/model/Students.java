package model;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by dewi on 10.10.16.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Students implements Serializable {

    private int studentId;
    private String firstName;
    private String lastName;
    private String accountNumber;
    List<Courses> coursesList;
    private StudentsType studentsTypes;

}
