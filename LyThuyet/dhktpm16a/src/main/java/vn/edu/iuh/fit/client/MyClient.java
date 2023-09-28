package vn.edu.iuh.fit.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import vn.edu.iuh.fit.models.Candidate;

//chu y: Nen tao 1 project moi, ad dependencies
//....
public class MyClient {
    public static void main(String[] args) {
        String uri = "http://localhost:8080/dhktpm16a-1.0-SNAPSHOT/api/candidates/2";
        Client client = ClientBuilder.newClient();

        WebTarget wt = client
                .target(uri);

        Candidate can = wt.request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Candidate.class);
        System.out.println(can);
    }
}
