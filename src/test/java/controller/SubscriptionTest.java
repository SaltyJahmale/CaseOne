package controller;

import model.Subscription;
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

            Subscription subscription = new Subscription();
            subscription.setStartDate(LocalDate.of(2016, Month.OCTOBER, 25));
            subscription.setCourseId(1);
            subscription.setStudentId(1);

            subscriptionDataHandler.insertSubscription(subscription);

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }


}
