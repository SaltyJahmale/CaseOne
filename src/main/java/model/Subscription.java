package model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by dewi on 12.10.16.
 */

@Data
@Builder
public class Subscription {

    private int id;
    private Date startDate;
    private int courseId;
    private int studentId;


}
