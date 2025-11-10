package org.example.lab7.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "storage_gb")
    private int storageGb;

    @Column(name = "price", nullable = false)
    private double price;

    public Phone() {
    }
    public Phone(String brand, String model, int storageGb, double price) {
        this.brand = brand;
        this.model = model;
        this.storageGb = storageGb;
        this.price = price;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getStorageGb() {
        return storageGb;
    }
    public void setStorageGb(int storageGb) {
        this.storageGb = storageGb;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}