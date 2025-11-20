package org.example.lab7.controller;
import org.example.lab7.dto.CategoryDTO;
import org.example.lab7.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;
    public CategoryController(CategoryService service) {
        this.service = service;
    }
    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return service.create(dto);
    }
    @GetMapping
    public List<CategoryDTO> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody
    CategoryDTO dto) {
        return service.update(id, dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}