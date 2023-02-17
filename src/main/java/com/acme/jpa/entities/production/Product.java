package com.acme.jpa.entities.production;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(schema = "production", name = "products",indexes = @Index(columnList = "product_name",unique = true) )
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id",nullable = false)
    private Long id;
    
    @Column(name = "product_name",nullable = false)
    private String name;
    
    @ManyToOne
    //@OnDelete(action = OnDeleteAction.CASCADE)    
    @JoinColumn(name = "brand_id",nullable = false)
    private Brand brand;
    
    @ManyToOne
    //@OnDelete(action = OnDeleteAction.CASCADE)    
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    
    @Column(name = "model_year",nullable = false)
    private Short modelYear;
    
    @Column(name = "list_price",precision = 10, scale = 2,nullable = false)
    private BigDecimal listPrice;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Short getModelYear() {
        return modelYear;
    }
    public void setModelYear(Short modelYear) {
        this.modelYear = modelYear;
    }
    public BigDecimal getListPrice() {
        return listPrice;
    }
    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        if (id != null) {
            builder.append("id=");
            builder.append(id);
            builder.append(", ");
        }
        if (name != null) {
            builder.append("name=");
            builder.append(name);
            builder.append(", ");
        }
        if (brand != null) {
            builder.append("brand=");
            builder.append(brand);
            builder.append(", ");
        }
        if (category != null) {
            builder.append("category=");
            builder.append(category);
            builder.append(", ");
        }
        if (modelYear != null) {
            builder.append("modelYear=");
            builder.append(modelYear);
            builder.append(", ");
        }
        if (listPrice != null) {
            builder.append("listPrice=");
            builder.append(listPrice);
        }
        builder.append("}");
        return builder.toString();
    }
    
    
}
