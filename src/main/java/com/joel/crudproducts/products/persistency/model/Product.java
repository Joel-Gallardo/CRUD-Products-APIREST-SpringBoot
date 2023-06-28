package com.joel.crudproducts.products.persistency.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private float price;
    private LocalDate dateCreated;
    @Transient
    private int antiquity;

    public Product() {
    }

    public Product(Long id, String name, float price, LocalDate dateCreated) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateCreated = dateCreated;
    }

    public Product(String name, float price, LocalDate dateCreated) {
        this.name = name;
        this.price = price;
        this.dateCreated = dateCreated;
    }

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getAntiquity() {
        return Period.between(this.dateCreated, LocalDate.now()).getYears();
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }
}
