package org.example.lab7.dto;


import java.util.List;


public class PhoneDTO {
    private Long id;
    private String model;
    private double price;
    private Long brandId;
    private List<Long> categoryIds;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }


    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    public Long getBrandId() { return brandId; }
    public void setBrandId(Long brandId) { this.brandId = brandId; }


    public List<Long> getCategoryIds() { return categoryIds; }
    public void setCategoryIds(List<Long> categoryIds) { this.categoryIds = categoryIds; }
}