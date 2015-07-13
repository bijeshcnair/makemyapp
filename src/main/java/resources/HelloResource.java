package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by biju on 7/14/2015.
 */
@Path("/greetings/{name}")
public class HelloResource {
    @GET
    public String getGreetings(@PathParam("name") String name){
        return "hello "+name
                ;
    }
}
