package org.example.lab7.service;


import org.example.lab7.dto.BrandDTO;
import java.util.List;


public interface BrandService {
    BrandDTO create(BrandDTO dto);
    BrandDTO update(Long id, BrandDTO dto);
    void delete(Long id);
    BrandDTO getById(Long id);
    List<BrandDTO> getAll();
}