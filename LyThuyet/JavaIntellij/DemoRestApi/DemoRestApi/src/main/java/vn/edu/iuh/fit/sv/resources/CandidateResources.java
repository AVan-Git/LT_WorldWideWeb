package vn.edu.iuh.fit.sv.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.sv.model.Candidate;
import vn.edu.iuh.fit.sv.sevice.CandidateSevice;

import java.util.List;

@Path("/candidates")
public class CandidateResources {

    @Inject
    private CandidateSevice service;

    @GET
    @Produces("application/json")
        public List<Candidate> getAllacn() throws Exception {

        return service.getAll();
    }
    @POST
    @Consumes("application/json")
    public Response insertNewCandidate(Candidate candidate) throws Exception{
        service.insert(candidate);
        return Response.ok("Success").build();
    }



}
