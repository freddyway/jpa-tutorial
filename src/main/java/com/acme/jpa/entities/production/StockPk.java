package com.acme.jpa.entities.production;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.acme.jpa.entities.sales.Store;

@Embeddable
public class StockPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "store_id",nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)    
    private Product product;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
