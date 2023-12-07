package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CustomerService {
    boolean insert(Customer item);

    boolean update(Customer item);

    boolean delete(UUID uuid);

    Optional<Customer> getById(UUID uuid);

    List<Customer> getAll();
}
