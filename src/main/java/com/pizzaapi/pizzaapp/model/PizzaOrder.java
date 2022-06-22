package com.pizzaapi.pizzaapp.model;

import javax.persistence.*;

@Entity
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crust;
    private String[] toppings;
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public PizzaOrder(Long id, String crust, String[] toppings, Status status, Customer customer) {
        this.id = id;
        this.crust = crust;
        this.toppings = toppings;
        this.status = status;
        this.customer = customer;
    }

    public PizzaOrder(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
