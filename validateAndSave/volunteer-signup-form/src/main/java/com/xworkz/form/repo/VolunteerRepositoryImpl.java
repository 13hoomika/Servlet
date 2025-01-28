package com.xworkz.form.repo;

import com.xworkz.form.entity.VolunteerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VolunteerRepositoryImpl implements VolunteerRepository{
    @Override
    public Boolean save(VolunteerEntity entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("servlet");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            return false;
        }finally {
            em.close();
        }
    }
}
