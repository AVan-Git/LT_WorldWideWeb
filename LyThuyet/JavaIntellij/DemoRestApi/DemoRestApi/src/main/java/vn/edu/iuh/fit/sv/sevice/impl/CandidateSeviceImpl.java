package vn.edu.iuh.fit.sv.sevice.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.sv.Repository.CandidateRepository;
import vn.edu.iuh.fit.sv.model.Candidate;
import vn.edu.iuh.fit.sv.sevice.CandidateSevice;

import java.util.List;
import java.util.Optional;

public class CandidateSeviceImpl implements CandidateSevice {

    @Inject
    private CandidateRepository repository;

    @Override
    public void insert(Candidate candidate) throws Exception {
        repository.insert(candidate);
    }

    @Override
    public void update(Candidate candidate) throws Exception {
        repository.update(candidate);
    }

    @Override
    public void delete(long id) throws Exception {
        repository.delete(id);
    }

    @Override
    public Optional<Candidate> getById(long id) throws Exception {

        return repository.getByID(id);
    }

    @Override
    public List<Candidate> getAll() throws Exception {
        return repository.getAll();
    }
}
