package resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

/**
 * Created by biju on 7/14/2015.
 */
@Path("/coffeeshop")
public class CoffeeShopResource {
    private final DB mongoDatabase;

    public CoffeeShopResource(DB mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    @GET
    public String getGreetings(@PathParam("name") String name){
        return "hello "+name
                ;
    }
    @Path("{id}/ order/")
    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveOrder(@PathParam("id") long coffeeShopId,Order order){
        order.setCoffeeShopId(coffeeShopId);
        DBCollection ordersCollection = mongoDatabase.getCollection("orders");
        //JacksonDBCollection<String, Object> collection =  JacksonDBCollection.wrap(ordersCollection, String.class);
        JacksonDBCollection<Order,String> collection2 =  JacksonDBCollection.wrap(ordersCollection,Order.class,String.class);
        WriteResult<Order,String> writeResult = collection2.insert(order  );
        if(writeResult ==  null){

            return Response.serverError().build();
        }
        order.setId(writeResult.getSavedId());
         return Response.created(URI.create(order.getOrderId())).entity(order).build();
    }
}
