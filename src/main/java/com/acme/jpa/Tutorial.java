package com.acme.jpa;

import com.acme.jpa.entities.production.Brand;
import com.acme.jpa.entities.production.Category;
import com.acme.jpa.entities.production.Product;
import com.acme.jpa.repository.BrandRepository;
import com.acme.jpa.repository.CategoryRepository;
import com.acme.jpa.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class Tutorial {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    
    public Tutorial() {
        logger.info("Inicio Tutorial..");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        
        categoryRepository = new CategoryRepository(emf);
        brandRepository = new BrandRepository(emf);
        productRepository = new ProductRepository(emf);
        
        createCategories();
        createBrands();
        createProducts();
        
        findProducts();
        
        emf.close();
        logger.warn("Fin Tutorial.");
    }

    private void findProducts() {
        logger.info("findProducts()...");
        
        Category category = categoryRepository.findByName("AUTOMOCION");
        Brand       brand = brandRepository.findByName("BMW");
      
        List<Product> productList = productRepository.findByBrandAndCategory(brand, category);
//        productList.forEach(System.out::println);
        productList.forEach(p -> logger.info(p.toString()));
    }

    private void createProducts() {
        logger.info("createProducts()...");
        
        Product product = new Product();
        product.setCategory(categoryRepository.findByName("AUTOMOCION"));
        product.setBrand(brandRepository.findByName("BMW"));
        product.setName("330d");
        product.setModelYear((short) 2023);
        product.setListPrice(new BigDecimal("55000.0"));
        productRepository.save(product);
        
        
        Product product1 = new Product();
        product1.setCategory(categoryRepository.findByName("AUTOMOCION"));
        product1.setBrand(brandRepository.findByName("BMW"));
        product1.setName("530I");
        product1.setModelYear((short) 2021);
        product1.setListPrice(new BigDecimal("67599.0"));
        productRepository.save(product1);
        
        
        Product product2 = new Product();
        product2.setCategory(categoryRepository.findByName("AUTOMOCION"));
        product2.setBrand(brandRepository.findByName("MERCEDES"));
        product2.setName("A180d");
        product2.setModelYear((short) 2023);
        product2.setListPrice(new BigDecimal("39000.0"));
        productRepository.save(product2);
        
        
        Product product3 = new Product();
        product3.setCategory(categoryRepository.findByName("AUTOMOCION"));
        product3.setBrand(brandRepository.findByName("MERCEDES"));
        product3.setName("C220");
        product3.setModelYear((short) 2021);
        product3.setListPrice(new BigDecimal("69999.0"));
        productRepository.save(product3);
    }

    private void createBrands() {
        logger.info("createBrands()...");
        
        Brand brand = new Brand();
        brand.setName("BMW");
        brandRepository.save(brand);
        
        Brand brand1 = new Brand();
        brand1.setName("MERCEDES");
        brandRepository.save(brand1);
        
        Brand brand2 = new Brand();
        brand2.setName("AUDI");
        brandRepository.save(brand2);
        
        
        Brand brand3 = new Brand();
        brand3.setName("DON SIMON");
        brandRepository.save(brand3);
        
        Brand brand4 = new Brand();
        brand4.setName("DANONE");
        brandRepository.save(brand4);
    }

    private void createCategories() {
        logger.info("createCategories()...");
        
        Category category = new Category();
        category.setName("AUTOMOCION");
        categoryRepository.save(category);
        
        Category category1 = new Category();
        category1.setName("ALIMENTACION");
        categoryRepository.save(category1);
    }

    public static void main(String[] args) {
        new Tutorial();
    }

}
