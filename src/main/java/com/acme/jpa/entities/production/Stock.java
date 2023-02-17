package com.acme.jpa.entities.production;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "production", name = "stocks")
public class Stock implements Serializable {
    
    @EmbeddedId
    private StockPk pk;

    @Column(name = "quantity")
    private Integer quantity;

    public StockPk getPk() {
        return pk;
    }

    public void setPk(StockPk pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
}
