package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateServices {
    void insert(Candidate candidate)throws Exception;
    void update(Candidate candidate)throws Exception;
    void delete(long id)throws Exception;
    Optional<Candidate> getById(long id)throws Exception;
    List<Candidate> getAllCandidate()throws Exception;
    //.......
    //.....
}
