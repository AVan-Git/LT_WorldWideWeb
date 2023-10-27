package vn.iuh.edu.fit.se.reponsitories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.iuh.edu.fit.se.connect.ConnectJpa;
import vn.iuh.edu.fit.se.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductReponsitory {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductReponsitory() {
        entityManager = ConnectJpa.getInstance().getEntityManager();

        transaction = entityManager.getTransaction();
    }

    //add
    public boolean insert(Product product) {
        try {
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
            return true;
        }catch (Exception e)
        {
            System.out.println("ProductReponsitory - insert()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    //edit
    public boolean update (Product product) {
        try {
            transaction.begin();
            entityManager.merge(product);
            transaction.commit();
            return true;
        }catch (Exception e) {
            System.out.println("Product Reponsitory - update()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }
    // remove
    public boolean delete(long maXoa) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(Product.class, maXoa));
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("Product Reponsitory - del()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }
    // read Id
    public Optional<Product> getById(long maTim) {
        Product a = null;
//        String sql = "SELECT pro FROM Product pro WHERE pro.id="+ maTim;
        String sql = "SELECT p FROM Product p WHERE p.id =:id";
        try {
            transaction.begin();
//            entityManager.createQuery(sql, Product.class).getSingleResult();
            TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
            query.setParameter("id", maTim);
            a = query.getSingleResult();
            transaction.commit();

        }catch (Exception e)
        {
            System.out.println("Reponsitory - getById()");
            transaction.rollback();
            logger.error(e.getMessage());

        }
        return a==null? Optional.empty() :Optional.of(a) ;
    }

    // read All
    public List<Product> getAll () {
        List<Product> list = new ArrayList<>();
        try {
            transaction.begin();
            String sql = "SELECT p FROM Product p";
            list = entityManager.createQuery(sql, Product.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println("ReponsitoryProduct -- GetAll()");
            transaction.rollback();
            logger.error(e.getMessage());
        }

        return list;
    }
}
