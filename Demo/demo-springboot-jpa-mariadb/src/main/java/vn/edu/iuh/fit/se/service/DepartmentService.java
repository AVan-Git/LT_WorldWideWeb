package vn.edu.iuh.fit.se.service;

import vn.edu.iuh.fit.se.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    void insert(Department department);
    void update(Department department);
    void delete(long maXoa);
    Optional<Department> findById(long maTim);
    List<Department> findAll();
}
