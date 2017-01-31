package model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Created by dewi on 10.10.16.
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courses {

    private int courseId;
    private String courseTitle;
    private String courseCode;
    private long duration;
    List<Students> studentsList;

}
