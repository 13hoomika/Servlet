package com.xworkz.thonosevents.repo;

import com.xworkz.thonosevents.entity.EventEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EventRepositoryImpl implements EventRepository{
    @Override
    public Boolean save(EventEntity entity) {
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
            em.close();
            return false;
        }finally {
            em.close();
        }
    }
}
