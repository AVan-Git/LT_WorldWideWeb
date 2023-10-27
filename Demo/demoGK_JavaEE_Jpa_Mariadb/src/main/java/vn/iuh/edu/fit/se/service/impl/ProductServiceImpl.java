package vn.iuh.edu.fit.se.service.impl;

import jakarta.inject.Inject;
import vn.iuh.edu.fit.se.model.Product;
import vn.iuh.edu.fit.se.reponsitories.ProductReponsitory;
import vn.iuh.edu.fit.se.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductReponsitory reponsitory = new ProductReponsitory();
//    @Inject
//    private ProductReponsitory reponsitory;
    @Override
    public boolean insert(Product product) {
        return reponsitory.insert(product);
    }

    @Override
    public boolean update(Product product) {
        return reponsitory.update(product);
    }

    @Override
    public boolean delete(long id) {
        return reponsitory.delete(id);
    }

    @Override
    public Optional<Product> getById(long id) {
        return reponsitory.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return reponsitory.getAll();
    }
}
