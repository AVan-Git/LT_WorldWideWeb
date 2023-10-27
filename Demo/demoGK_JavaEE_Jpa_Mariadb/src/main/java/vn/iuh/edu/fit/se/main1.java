package vn.iuh.edu.fit.se;

import jakarta.persistence.EntityManager;
import vn.iuh.edu.fit.se.connect.ConnectJpa;

public class main1 {

    public static void main(String[] args) {
         EntityManager entityManager;
        entityManager = ConnectJpa.getInstance().getEntityManager();
    }
}
