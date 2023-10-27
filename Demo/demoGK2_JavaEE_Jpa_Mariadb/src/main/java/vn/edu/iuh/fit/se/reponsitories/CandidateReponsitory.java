package vn.edu.iuh.fit.se.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.se.model.Candidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CandidateReponsitory {

    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CandidateReponsitory() {
        entityManager = Persistence.createEntityManagerFactory("myDatabase")
                .createEntityManager();
        transaction = entityManager.getTransaction();
    }

    // add
    public boolean insert(Candidate candidate) {
        try {
            transaction.begin();
            entityManager.persist(candidate);
            transaction.commit();
            return true;

        } catch (Exception e) {
            System.out.println("Candidate - insert()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    // edit
    public boolean update(Candidate candidate) {
        try {
            transaction.begin();
            entityManager.merge(candidate);
            transaction.commit();
            return true;

        } catch (Exception e) {
            System.out.println("candidate - update()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    // del
    public boolean delete(long id) {
        try {
            transaction.begin();
            entityManager.remove(entityManager.find(Candidate.class, id));
            transaction.commit();
            return true;

        } catch (Exception e) {
            System.out.println("Experience - del()");
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    // read id
    public Optional<Candidate> getById(long id) {
        Candidate item = null;
        String sql = "SELECT c FROM Candidate c WHERE c.id=:id";
        try {
            transaction.begin();
            TypedQuery<Candidate> query = entityManager.createQuery(sql, Candidate.class);
            query.setParameter("id", id);
            item = query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Experience - update()");
            transaction.rollback();
            logger.error(e.getMessage());
        }

        return item == null ? Optional.empty() : Optional.of(item);
    }

    //getALL
    public List<Candidate> getAll() {
        List<Candidate> lst = new ArrayList<>();
        String sql = "";
        try {
            transaction.begin();
            lst = entityManager.createQuery(sql, Candidate.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Experience - update()");
            transaction.rollback();
            logger.error(e.getMessage());
        }

        return lst;
    }

}
