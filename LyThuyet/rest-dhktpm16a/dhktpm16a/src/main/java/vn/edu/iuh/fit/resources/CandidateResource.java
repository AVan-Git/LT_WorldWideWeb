package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.services.CandidateServices;

import java.util.List;
import java.util.Optional;

@Path("/candidates")
public class CandidateResource {
    @Inject
    private CandidateServices services;

    @GET
    @Produces("application/json")
    public List<Candidate>getaLLcAN()throws Exception{
        return services.getAllCandidate();
    }

    @POST
    @Consumes("application/json")
    public Response insertNewCandidate(Candidate candidate) throws Exception{
        services.insert(candidate);
        return Response.ok("Success").build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response timbangId(@PathParam("id") long ms)throws Exception{
        Optional<Candidate> op = services.getById(ms);
        if(op.isPresent())
            return Response.ok(op.get()).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
