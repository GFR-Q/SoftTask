package org.example.lab7.service.impl;


import org.example.lab7.dto.BrandDTO;
import org.example.lab7.entity.Brand;
import org.example.lab7.mapper.BrandMapper;
import org.example.lab7.repository.BrandRepository;
import org.example.lab7.service.BrandService;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class BrandServiceImpl implements BrandService {


    private final BrandRepository repo;
    private final BrandMapper mapper;


    public BrandServiceImpl(BrandRepository repo, BrandMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }


    @Override
    public BrandDTO create(BrandDTO dto) {
        Brand entity = mapper.toEntity(dto);
        repo.save(entity);
        return mapper.toDTO(entity);
    }


    @Override
    public BrandDTO update(Long id, BrandDTO dto) {
        Brand brand = repo.findById(id).orElseThrow();
        brand.setName(dto.getName());
        repo.save(brand);
        return mapper.toDTO(brand);
    }


    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }


    @Override
    public BrandDTO getById(Long id) {
        return mapper.toDTO(repo.findById(id).orElseThrow());
    }


    @Override
    public List<BrandDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }
}