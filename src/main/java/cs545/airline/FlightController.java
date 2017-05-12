package cs545.airline;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
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

    @GET
    @Produces("application/json")
    @Path("/create")
    public Flight createMsg() {
        Airport mco = new Airport("MCO", "Orlando", "Florida", "USA");
        Airport mia = new Airport("MIA", "Miami", "Florida", "USA");

        Airplane airplane1 = new Airplane("56789", "A380", 519);

        Airline airline1 = new Airline("Delta");

        Flight flight1 = new Flight("DE 36", "08/06/2009", "7:10 pm",
                "06/25/2015", "9:00 am", airline1, mia, mco, airplane1);

        flightService.create(flight1);

        return flight1;
    }
}
