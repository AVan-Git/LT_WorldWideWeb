package vn.edu.iuh.fit.se.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Department;
import vn.edu.iuh.fit.se.repositories.DepartmentRepository;
import vn.edu.iuh.fit.se.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    @Override
    public void insert(Department department) {
        repository.save(department);
    }

    @Override
    public void update(Department department) {
        repository.save(department);
    }

    @Override
    public void delete(long maXoa) {
        repository.deleteById(maXoa);
    }

    @Override
    public Optional<Department> findById(long maTim) {
        return repository.findById(maTim) ;
    }

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }
}
