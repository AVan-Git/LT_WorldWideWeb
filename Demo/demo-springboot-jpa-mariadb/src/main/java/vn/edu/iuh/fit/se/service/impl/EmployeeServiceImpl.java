package vn.edu.iuh.fit.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Employee;
import vn.edu.iuh.fit.se.repositories.EmployeeRepository;
import vn.edu.iuh.fit.se.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Override
    public void insert(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void delete(long maXoa) {
        repository.deleteById(maXoa);
    }

    @Override
    public Optional<Employee> findById(long maTim) {
        return repository.findById(maTim);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
