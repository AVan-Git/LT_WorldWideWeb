package vn.iuh.edu.fit.se.service.impl;

import jakarta.inject.Inject;
import vn.iuh.edu.fit.se.model.ProductPrice;
import vn.iuh.edu.fit.se.reponsitories.ProductPriceReponsitory;
import vn.iuh.edu.fit.se.service.ProductPriceService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceServiceImpl implements ProductPriceService {

    @Inject
    private ProductPriceReponsitory reponsitory;
    @Override
    public boolean insert(ProductPrice product) {
        return reponsitory.insert(product);
    }

    @Override
    public boolean update(ProductPrice product) {
        return reponsitory.update(product);
    }

    @Override
    public boolean delete(LocalDateTime time) {
        return reponsitory.delete(time);
    }

    @Override
    public Optional<ProductPrice> getById(LocalDateTime time) {
        return reponsitory.getById(time);
    }

    @Override
    public List<ProductPrice> getAll() {
        return reponsitory.getAll();
    }
}
