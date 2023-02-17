package com.acme.jpa.entities.sales;

import java.io.Serializable;

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
@Table(schema = "sales", name = "staffs")
public class Staff implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id",nullable = false)
    private Long id;
    
    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;
    
    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;
    
    @Column(name = "phone",nullable = false,length = 50)
    private String phone;
    
    @Column(name = "active")
    private Short active;
    
    @ManyToOne       
    @JoinColumn(name = "store_id",nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Staff manager;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    
}
