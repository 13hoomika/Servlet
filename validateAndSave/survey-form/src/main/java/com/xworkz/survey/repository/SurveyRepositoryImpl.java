package com.xworkz.survey.repository;

import com.xworkz.survey.entity.SurveyEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SurveyRepositoryImpl implements SurveyRepository{
    @Override
    public Boolean save(SurveyEntity entity) {
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
            return  false;
        }finally {
            em.close();
        }
    }
}
