package com.acme.jpa.entities.sales;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderItemPk implements Serializable {
   
    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
    
    @Column(name = "item_id",nullable = false)
    private Long item;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

   
    
}
