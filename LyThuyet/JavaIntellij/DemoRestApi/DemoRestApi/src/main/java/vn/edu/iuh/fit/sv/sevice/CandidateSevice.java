package vn.edu.iuh.fit.sv.sevice;

import vn.edu.iuh.fit.sv.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateSevice {

    void insert(Candidate candidate)throws Exception;
    void update(Candidate candidate)throws Exception;
    void delete(long id)throws Exception;
    Optional<Candidate> getById(long id) throws  Exception;
    List<Candidate> getAll() throws Exception;
}
