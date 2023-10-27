package vn.iuh.edu.fit.se;

import jakarta.persistence.EntityManager;
import vn.iuh.edu.fit.se.connect.ConnectJpa;
import vn.iuh.edu.fit.se.enums.ProductStatus;
import vn.iuh.edu.fit.se.model.Product;
import vn.iuh.edu.fit.se.model.ProductPrice;
import vn.iuh.edu.fit.se.reponsitories.ProductPriceReponsitory;
import vn.iuh.edu.fit.se.reponsitories.ProductReponsitory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

public class main1 {


    public static void main(String[] args) {
        ProductReponsitory productReponsitory = new ProductReponsitory();
        ProductPriceReponsitory priceReponsitory = new ProductPriceReponsitory();
        LocalDateTime date = LocalDateTime.now();

        Product pro1 = new Product();
        pro1.setName("name 103");
        pro1.setStatus(ProductStatus.ACTIVE);
        pro1.setDescription("103 abc");
        productReponsitory.insert(pro1);

        ProductPrice price1 = new ProductPrice();
        price1.setPriceDateTime(date);
        price1.setPrice(200);
        price1.setProduct(pro1);

        priceReponsitory.insert(price1);
//        Optional<ProductPrice> optional = priceReponsitory.getById(LocalDateTime.of());

//        if (optional.isEmpty())
//            System.out.println("a1 - " + optional.get().toString());

        priceReponsitory.getAll().forEach(System.out::println);


//        Product pro1 = new Product();
//        pro1.setName("name 102");
//        pro1.setStatus(ProductStatus.ACTIVE);
//        pro1.setDescription("102 abc");
//        productReponsitory.insert(pro1);

        productReponsitory.getAll().forEach(System.out::println);
    }
}
