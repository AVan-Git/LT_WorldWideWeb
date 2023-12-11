package vn.edu.iuh.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
