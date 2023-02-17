package com.acme.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.acme.jpa.entities.production.Brand;
import com.acme.jpa.entities.production.Category;

public class BrandRepository {

    private EntityManagerFactory emf;
    
    public BrandRepository(EntityManagerFactory emf) {
        this.emf = emf; 
    }
    
    public void save(Brand brand) {        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(brand);
        em.getTransaction().commit();
        em.close();
    }

    public Brand findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Brand brand = em.find(Brand.class, id);
        em.close();
        
        return brand;
        
    }
    
    public Brand findByName(String name) {
        EntityManager em = emf.createEntityManager();
        
        Brand Brand = em.createQuery("select c from Brand c where c.name = ?1",Brand.class)
                        .setParameter(1, name)
                        .getSingleResult();
        em.close();
        
        return Brand;        
    }
}
