package org.example.lab7.service.serviceimpl;

import org.example.lab7.dto.CategoryDTO;
import org.example.lab7.entity.Category;
import org.example.lab7.mapper.CategoryMapper;
import org.example.lab7.repository.CategoryRepository;
import org.example.lab7.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;
    private final CategoryMapper mapper;

    public CategoryServiceImpl(CategoryRepository repo, CategoryMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        Category category = mapper.toEntity(dto);
        repo.save(category);
        return mapper.toDTO(category);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        Category category = repo.findById(id).orElseThrow();
        category.setName(dto.getName());
        repo.save(category);
        return mapper.toDTO(category);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public CategoryDTO getById(Long id) {
        return mapper.toDTO(repo.findById(id).orElseThrow());
    }

    @Override
    public List<CategoryDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }
}