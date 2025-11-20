package org.example.lab7.entity;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String model;
    private double price;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ManyToMany
    @JoinTable(
            name = "phone_category",
            joinColumns = @JoinColumn(name = "phone_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }


    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }


    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }
}