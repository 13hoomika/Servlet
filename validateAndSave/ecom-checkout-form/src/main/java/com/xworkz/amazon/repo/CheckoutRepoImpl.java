package com.xworkz.amazon.repo;

import com.xworkz.amazon.entity.CheckoutEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CheckoutRepoImpl implements CheckoutRepo{
    @Override
    public Boolean persistData(CheckoutEntity entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("servlet");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            return false;
        }finally {
            em.close();
        }
    }
}
