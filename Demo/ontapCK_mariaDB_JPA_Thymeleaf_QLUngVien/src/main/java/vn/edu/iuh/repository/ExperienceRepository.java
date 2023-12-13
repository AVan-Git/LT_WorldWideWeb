package vn.edu.iuh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.entity.Candidate;
import vn.edu.iuh.entity.Experience;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    public List<Experience> findAllByCandidate(Candidate candidate);
}
