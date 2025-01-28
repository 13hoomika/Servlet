package com.xworkz.paymentapp.repository;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.entity.PaymentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PaymentRepositoryImpl implements PaymentRepository {
    @Override
    public Boolean save(PaymentEntity entity) {
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
