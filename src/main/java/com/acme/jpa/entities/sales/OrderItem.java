package com.acme.jpa.entities.sales;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.acme.jpa.entities.production.Product;


@Entity
@Table(schema = "sales", name = "order_items")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPk pk;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;
    
    @Column(name = "quantity",nullable = false)
    private Integer quantity;
    
    @Column(name = "list_price",nullable = false,precision = 10, scale = 2)
    private BigDecimal listPrice;
    
    @Column(name = "discount",nullable = false,precision = 10, scale = 2)
    private BigDecimal discount;

    public OrderItemPk getPk() {
        return pk;
    }

    public void setPk(OrderItemPk pk) {
        this.pk = pk;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    
    
}
