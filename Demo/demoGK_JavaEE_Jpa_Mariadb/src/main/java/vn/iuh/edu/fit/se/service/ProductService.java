package vn.iuh.edu.fit.se.service;

import vn.iuh.edu.fit.se.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    boolean insert(Product product);
    boolean update(Product product);
    boolean delete(long id);
    Optional<Product> getById(long id);
    List<Product> getAll();


}
