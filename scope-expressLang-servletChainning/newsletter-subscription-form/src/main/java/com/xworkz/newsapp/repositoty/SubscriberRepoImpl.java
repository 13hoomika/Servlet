package com.xworkz.newsapp.repositoty;

import com.xworkz.newsapp.entity.SubscriberEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class SubscriberRepoImpl implements SubscriberRepo{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("servlet");

    @Override
    public Boolean save(SubscriberEntity subscriberEntity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(subscriberEntity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }finally {
            em.close();
        }
    }
}
