package com.acme.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.acme.jpa.entities.production.Brand;
import com.acme.jpa.entities.production.Category;


public class CategoryRepository {

    private EntityManagerFactory emf;
        
    public CategoryRepository() {
 
    }
    
    public CategoryRepository(EntityManagerFactory emf) {
        this.emf = emf; 
    }
    
    public void save(Category category) {        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        em.close();
    }

    public Category findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Category category = em.find(Category.class, id);
        em.close();
        
        return category;
        
    }
    
    public Category findByName(String name) {
        EntityManager em = emf.createEntityManager();
        
        Category category = em.createQuery("select c from Category c where c.name = ?1",Category.class)
                              .setParameter(1, name)
                              .getSingleResult();
        em.close();
        
        return category;        
    }
}
