package com.acme.jpa.entities.sales;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(schema = "sales", name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",nullable = false)
    private Long id;

    @ManyToOne       
    @JoinColumn(name = "customer_id",nullable = false)  
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;
    
    @Column(name = "order_status",nullable = false)
    private Short status;
    
    @Column(name = "order_date",nullable = false)
    private LocalDate orderDate;

    @Column(name = "required_date",nullable = false)
    private LocalDate requiredDate;
    
    @Column(name = "shipped_date")
    private LocalDate shippedDate;

    @ManyToOne       
    @JoinColumn(name = "store_id",nullable = false)  
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;

    @ManyToOne       
    @JoinColumn(name = "staff_id",nullable = false)      
    private Staff staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    
}
