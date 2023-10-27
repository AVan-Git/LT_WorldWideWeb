package vn.iuh.edu.fit.se.reponsitories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.iuh.edu.fit.se.connect.ConnectJpa;
import vn.iuh.edu.fit.se.model.Product;
import vn.iuh.edu.fit.se.model.ProductPrice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductPriceReponsitory {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceReponsitory() {
        entityManager = ConnectJpa.getInstance().getEntityManager();

        transaction = entityManager.getTransaction();
    }

    //add
    public boolean insert(ProductPrice product) {
        try {
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
            return true;
        }catch (Exception e)
        {
            System.out.println("ProductPriceReponsitory - insert()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    //edit
    public boolean update (ProductPrice product) {
        try {
            transaction.begin();
            entityManager.merge(product);
            transaction.commit();
            return true;
        }catch (Exception e) {
            System.out.println("ProductPriceReponsitory - update()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }
    // remove
    public boolean delete(LocalDateTime maXoa) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(ProductPrice.class, maXoa));
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("ProductPriceReponsitory - del()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }
    // read Id
    public Optional<ProductPrice> getById(LocalDateTime maTim) {
        ProductPrice a = null;
        String sql = "SELECT p FROM ProductPrice p WHERE p.priceDateTime =:priceDateTime";
        try {
            transaction.begin();
            TypedQuery<ProductPrice> query = entityManager.createQuery(sql, ProductPrice.class);
            query.setParameter("priceDateTime", maTim);
            a = query.getSingleResult();
            transaction.commit();

        }catch (Exception e)
        {
            System.out.println("ProductPriceReponsitory - getById()");
            transaction.rollback();
            logger.error(e.getMessage());

        }
        return a==null? Optional.empty() :Optional.of(a) ;
    }

    // read All
    public List<ProductPrice> getAll () {
        List<ProductPrice> list = new ArrayList<>();
        try {
            transaction.begin();
            String sql = "SELECT p FROM ProductPrice p";
            list = entityManager.createQuery(sql, ProductPrice.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println("ProductPriceReponsitory -- GetAll()");
            transaction.rollback();
            logger.error(e.getMessage());
        }

        return list;
    }
}
