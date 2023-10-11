package vn.edu.iuh.fit.se.service;

import vn.edu.iuh.fit.se.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    void insert(Employee employee);
    void delete(long maXoa);
    Optional<Employee> findById(long maTim);
    List<Employee> findAll();
}
