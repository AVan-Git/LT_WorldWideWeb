package vn.edu.iuh.fit.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.se.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
