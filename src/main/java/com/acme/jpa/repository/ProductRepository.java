package com.acme.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.acme.jpa.entities.production.Brand;
import com.acme.jpa.entities.production.Category;
import com.acme.jpa.entities.production.Product;

public class ProductRepository {

    private EntityManagerFactory emf;
    
    public ProductRepository(EntityManagerFactory emf) {
        this.emf = emf; 
    }
    
    public void save(Product product) {        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public Product findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Product product = em.find(Product.class, id);
        em.close();
        
        return product;
        
    }
    
    public Product findByName(String name) {
        EntityManager em = emf.createEntityManager();
        
        Product product = em.createQuery("select c from Product c where c.name = ?1",Product.class)
                              .setParameter(1, name)
                              .getSingleResult();
        em.close();
        
        return product;        
    }
    
    public List<Product> findByBrand(Brand brand) {
        EntityManager em = emf.createEntityManager();
        
        List<Product> productList = em.createQuery("select c from Product c where c.brand.id = ?1",Product.class)
                                      .setParameter(1, brand.getId())
                                      .getResultList();
                                 
        em.close();
        
        return productList;        
    }
    
    public List<Product> findByCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        
        List<Product> productList = em.createQuery("select c from Product c where c.category.id = ?1",Product.class)
                                      .setParameter(1, category.getId())
                                      .getResultList();
                                 
        em.close();
        
        return productList;        
    }
    
    public List<Product> findByBrandAndCategory(Brand brand, Category category) {
        EntityManager em = emf.createEntityManager();
        
        List<Product> productList = em.createQuery("select c from Product c where c.brand.id = ?1 and c.category.id = ?2",Product.class)
                                      .setParameter(1, brand.getId())
                                      .setParameter(2, category.getId())
                                      .getResultList();
                                 
        em.close();
        
        return productList;        
    }
}
