package vn.edu.iuh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.entity.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
