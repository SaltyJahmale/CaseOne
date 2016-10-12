package controller;

import org.junit.Test;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by dewi on 12.10.16.
 */
public class SubscriptionTest {

    @Test
    public void subscribeAStudentToCourseWithDate() {

        try {

            SubscriptionDataHandler subscriptionDataHandler = new SubscriptionDataHandler();
            subscriptionDataHandler.insertSubscription(LocalDate.of(2016, Month.OCTOBER, 25), 22, 23);

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }


}
