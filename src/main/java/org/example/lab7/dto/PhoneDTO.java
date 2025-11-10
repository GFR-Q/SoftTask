package org.example.lab7.dto;

public class PhoneDTO {

    private Long id;
    private String brand;
    private String model;
    private int storageGb;
    private double price;

    public PhoneDTO() {
    }

    public PhoneDTO(Long id, String brand, String model, int storageGb, double price) {
        this.id = id;
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