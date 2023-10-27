package vn.iuh.edu.fit.se.connect;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ConnectJpa {
    private static ConnectJpa instance = null;

    private EntityManager entityManager;

    public ConnectJpa() {
        entityManager = Persistence.createEntityManagerFactory("labOnTap")
                .createEntityManager();
    }

    public synchronized static ConnectJpa getInstance() {
        if (instance == null) {
            instance = new ConnectJpa();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void close() {
        entityManager.close();
    }
}
