package com.xworkz.foodapp.repository;

import com.xworkz.foodapp.entity.UserProfileEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserProfileRepoImpl implements UserProfileRepo {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("servlet");

    @Override
    public Boolean save(UserProfileEntity userProfileEntity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(userProfileEntity);
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

    @Override
    public List<UserProfileEntity> getAllProfiles() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT getProfiles FROM UserProfileEntity getProfiles", UserProfileEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }

        //static
//        List<UserProfileEntity> userProfileEntities = new ArrayList<>();
//        userProfileEntities.add(new UserProfileEntity(11,"Tharun","Ramesh","tharun@gmail.com",9876543234L));
//        userProfileEntities.add(new UserProfileEntity(12,"Raghav","Kumar","raghav@gmail.com",5678443234L));
//        userProfileEntities.add(new UserProfileEntity(13,"Praveen","S","praveen@gmail.com",9876593242L));
//        return userProfileEntities;
    }


    @Override
    public void deleteUserById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }

}
