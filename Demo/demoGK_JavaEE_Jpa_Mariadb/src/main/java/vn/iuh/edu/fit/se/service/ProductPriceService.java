package vn.iuh.edu.fit.se.service;

import vn.iuh.edu.fit.se.model.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductPriceService {
    boolean insert(ProductPrice product);
    boolean update(ProductPrice product);
    boolean delete(LocalDateTime time);
    Optional<ProductPrice> getById(LocalDateTime time);
    List<ProductPrice> getAll();


}
