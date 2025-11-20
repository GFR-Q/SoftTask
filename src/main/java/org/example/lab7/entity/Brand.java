package org.example.lab7.entity;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public List<Phone> getPhones() { return phones; }
    public void setPhones(List<Phone> phones) { this.phones = phones; }
}