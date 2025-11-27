package org.example.lab7.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private Long id;
    private String model;
    private double price;
    private Long brandId;
    private List<Long> categoryIds;



}