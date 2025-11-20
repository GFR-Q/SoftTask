package org.example.lab7.controller;

import org.example.lab7.dto.BrandDTO;
import org.example.lab7.service.BrandService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/brands")
public class BrandController {
    private final BrandService service;
    public BrandController(BrandService service) {
        this.service = service;
    }
    @PostMapping
    public BrandDTO create(@RequestBody BrandDTO dto) {
        return service.create(dto);
    }
    @GetMapping
    public List<BrandDTO> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public BrandDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @PutMapping("/{id}")
    public BrandDTO update(@PathVariable Long id, @RequestBody BrandDTO dto)
    {
        return service.update(id, dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}