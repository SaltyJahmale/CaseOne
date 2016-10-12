package controller;

import model.Subscription;

import java.util.Date;

/**
 * Created by dewi on 12.10.16.
 */
public class SubscriptionBuilderTest {

    public static Subscription.SubscriptionBuilder subscriptionBuilder() {
        return Subscription.builder();
    }
}
