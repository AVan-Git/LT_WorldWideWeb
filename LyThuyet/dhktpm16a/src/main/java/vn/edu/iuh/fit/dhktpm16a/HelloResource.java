package vn.edu.iuh.fit.dhktpm16a;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/heart-beat")
    @Produces("application/json")
    public Response hearbeat(){
        return Response.ok("live").build();
    }
}