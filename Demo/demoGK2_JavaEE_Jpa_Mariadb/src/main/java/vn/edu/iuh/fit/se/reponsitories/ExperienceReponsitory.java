package vn.edu.iuh.fit.se.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.se.model.Experience;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExperienceReponsitory {

    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ExperienceReponsitory() {
        entityManager = Persistence.createEntityManagerFactory("myDatabase")
                .createEntityManager();
        transaction = entityManager.getTransaction();
    }

    // add
    public boolean insert(Experience experience) {
        try {
            transaction.begin();
            entityManager.persist(experience);
            transaction.commit();
            return true;

        }catch (Exception e){
            System.out.println("Experience - insert()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }
    // edit
    public boolean update(Experience experience) {
        try {
            transaction.begin();
            entityManager.merge(experience);
            transaction.commit();
            return true;

        }catch (Exception e){
            System.out.println("Experience - update()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }
    // del
    public boolean delete(long id) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(Experience.class, id));
            transaction.commit();
            return true;

        }catch (Exception e){
            System.out.println("Experience - update()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    // read id
    public Optional<Experience> getById(long id) {
        Experience item = null ;
        String sql = "SELECT e FROM Experience e WHERE e.id=:id";
        try {
            transaction.begin();
            TypedQuery<Experience> query = entityManager.createQuery(sql, Experience.class);
            query.setParameter("id", id);
            item = query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            System.out.println("Experience - update()");
            transaction.rollback();
            logger.error(e.getMessage());
        }

        return item==null? Optional.empty():Optional.of(item);
    }

    //getALL
    public List<Experience> getAll() {
        List<Experience> lst = new ArrayList<>();
        String sql = "SELECT e FROM Experience e";
        try {
            transaction.begin();
            lst = entityManager.createQuery(sql, Experience.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println("Experience - update()");
            transaction.rollback();
            logger.error(e.getMessage());
        }

        return lst;
    }

}
