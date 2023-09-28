package vn.edu.iuh.fit.services.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.services.CandidateServices;

import java.util.List;
import java.util.Optional;

public class CandidateServicesImpl implements CandidateServices {
    @Inject
    private CandidateRepository repository;

    @Override
    public void insert(Candidate candidate) throws Exception{
        repository.insert(candidate);
    }

    @Override
    public void update(Candidate candidate) throws Exception{
        repository.update(candidate);
    }

    @Override
    public void delete(long id) throws Exception{
        repository.delete(id);
    }

    @Override
    public Optional<Candidate> getById(long id) throws Exception{
        return repository.getByID(id);
    }

    @Override
    public List<Candidate> getAllCandidate() throws Exception{
        return repository.getAll();
    }
}
