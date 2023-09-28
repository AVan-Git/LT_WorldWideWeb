package vn.edu.iuh.fit.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import vn.edu.iuh.fit.models.Candidate;

import java.util.List;

public class DriverClass {
    public static void main(String[] args) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget wt = client.target("http://localhost:8080/dhktpm16a-1.0-SNAPSHOT/api/candidates");
            String jsonListString = wt.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
            System.out.println(jsonListString);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Candidate> lst = objectMapper.readValue(jsonListString, new TypeReference<List<Candidate>>() {
            });
            lst.forEach(System.out::println);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

