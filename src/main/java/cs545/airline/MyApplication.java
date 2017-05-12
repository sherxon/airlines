package cs545.airline;

import javax.ws.rs.core.Application;

/**
 * Created by sherxon on 5/12/17.
 */
//@ApplicationPath("/")
public class MyApplication extends Application{


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
