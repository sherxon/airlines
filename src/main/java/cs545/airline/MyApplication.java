package cs545.airline;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by sherxon on 5/12/17.
 */
//@ApplicationPath("/")
@Path("/hello")
public class MyApplication {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }

    public MyApplication() {
        // Register resources and providers using package-scanning.
        //packages("my.package");

        // Register my custom provider - not needed if it's in my.package.
        //register(SecurityRequestFilter.class);
        // Register an instance of LoggingFilter.
        //register(new LoggingFilter(LOGGER, true));

        // Enable Tracing support.
        //property(ServerProperties.TRACING, "ALL");
    }
}
