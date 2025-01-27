package com.xworkz.xworkzapp.repo;

import com.xworkz.xworkzapp.entity.EnrollmentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EnrollmentRepoImpl implements EnrollmentRepo {
    @Override
    public Boolean save(EnrollmentEntity entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("servlet");
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            return false;
        }finally {
            entityManager.close();
        }

    }
}
