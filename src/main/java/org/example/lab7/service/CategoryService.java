package org.example.lab7.service;


import org.example.lab7.dto.CategoryDTO;
import java.util.List;


public interface CategoryService {
    CategoryDTO create(CategoryDTO dto);
    CategoryDTO update(Long id, CategoryDTO dto);
    void delete(Long id);
    CategoryDTO getById(Long id);
    List<CategoryDTO> getAll();
}