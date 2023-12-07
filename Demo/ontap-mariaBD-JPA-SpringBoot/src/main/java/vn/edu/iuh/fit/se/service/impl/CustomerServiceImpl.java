package vn.edu.iuh.fit.se.service.impl;

import org.hibernate.internal.TransactionManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Customer;
import vn.edu.iuh.fit.se.repositories.CustomerRepository;
import vn.edu.iuh.fit.se.service.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private TransactionManagement transactionManagement;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public boolean insert(Customer item) {
        return false;
    }

    @Override
    public boolean update(Customer item) {
        return false;
    }

    @Override
    public boolean delete(UUID uuid) {
        return false;
    }

    @Override
    public Optional<Customer> getById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
