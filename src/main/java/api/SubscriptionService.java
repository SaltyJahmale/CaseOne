package api;

import controller.SubscriptionDataHandler;
import model.Subscription;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by djones on 1/31/17.
 */
@Path("/subscriptions")
public class SubscriptionService {

    SubscriptionDataHandler subscriptionDataHandler = new SubscriptionDataHandler();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllSubscriptions() throws SQLException {

        return Response.status(200).entity(subscriptionDataHandler.getAllSubscriptions()).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createSubscription(Subscription subscription) throws SQLException {

        int result = subscriptionDataHandler.insertSubscription(subscription);

        if (result == 1) {
            return Response.status(201).entity(result).build();
        } else {
            return Response.status(404).build();
        }
    }
}
