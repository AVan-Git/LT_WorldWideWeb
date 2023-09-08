package vn.edu.iuh.fit.sv.demorestapi;

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


    @GET  // phương thức get
    @Path("heart-beat") // heart-beat kiem tra sserver con song hay da chet
    @Produces("application/json") // Produces ep kieu cho data suat ra
    public Response heartBeat() {
        return Response.ok("live").build();
    }

}