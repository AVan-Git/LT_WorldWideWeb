package vn.edu.iuh.fit.se.service.impl;

import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Customer;
import vn.edu.iuh.fit.se.repositories.CustomerRepository;
import vn.edu.iuh.fit.se.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void insert(Customer item) {
        repository.save(item);
    }

    @Override
    public void update(Customer item) {
        repository.save(item);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Optional<Customer> getById(UUID uuid) {
        Optional<Customer> optional = null;
        optional = repository.findById(uuid);
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> lst = new ArrayList<>();
        lst = repository.findAll();
        return lst;
    }
}
