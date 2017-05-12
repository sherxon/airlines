package cs545.airline;

import cs545.airline.service.FlightService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by sherxon on 5/12/17.
 */
@Path("/flights")
public class FlightController {

    FlightService flightService;

    @Inject
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getMsg() {
        return Response.status(200).entity(flightService.findAll()).build();

    }
}
