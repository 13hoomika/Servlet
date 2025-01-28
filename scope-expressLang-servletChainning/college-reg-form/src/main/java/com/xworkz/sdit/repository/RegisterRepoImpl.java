package com.xworkz.sdit.repository;

import com.xworkz.sdit.entity.RegisterEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegisterRepoImpl implements RegisterRepo {
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("servlet");

    @Override
    public Boolean save(RegisterEntity registerEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(registerEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
                return false;
            }else {
                return false;
            }
        } finally {
            entityManager.close();
        }
    }
}

