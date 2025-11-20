package org.example.lab7.service.serviceimpl;

import org.example.lab7.dto.PhoneDTO;
import org.example.lab7.entity.Brand;
import org.example.lab7.entity.Category;
import org.example.lab7.entity.Phone;
import org.example.lab7.mapper.PhoneMapper;
import org.example.lab7.repository.BrandRepository;
import org.example.lab7.repository.CategoryRepository;
import org.example.lab7.repository.PhoneRepository;
import org.example.lab7.service.PhoneService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepo;
    private final BrandRepository brandRepo;
    private final CategoryRepository categoryRepo;
    private final PhoneMapper mapper;
    public PhoneServiceImpl(PhoneRepository phoneRepo, BrandRepository
                                    brandRepo,
                            CategoryRepository categoryRepo, PhoneMapper
                                    mapper) {
        this.phoneRepo = phoneRepo;
        this.brandRepo = brandRepo;
        this.categoryRepo = categoryRepo;
        this.mapper = mapper;
    }
    @Override
    public PhoneDTO create(PhoneDTO dto) {
        Phone phone = new Phone();
        phone.setModel(dto.getModel());
        phone.setPrice(dto.getPrice());
        Brand brand = brandRepo.findById(dto.getBrandId()).orElseThrow();

        phone.setBrand(brand);
        List<Category> categories =
                categoryRepo.findAllById(dto.getCategoryIds());
        phone.setCategories(categories);
        phoneRepo.save(phone);
        return mapper.toDTO(phone);
    }
    @Override
    public PhoneDTO update(Long id, PhoneDTO dto) {
        Phone phone = phoneRepo.findById(id).orElseThrow();
        phone.setModel(dto.getModel());
        phone.setPrice(dto.getPrice());
        Brand brand = brandRepo.findById(dto.getBrandId()).orElseThrow();
        phone.setBrand(brand);
        List<Category> categories =
                categoryRepo.findAllById(dto.getCategoryIds());
        phone.setCategories(categories);
        phoneRepo.save(phone);
        return mapper.toDTO(phone);
    }
    @Override
    public void delete(Long id) {
        phoneRepo.deleteById(id);
    }
    @Override
    public PhoneDTO getById(Long id) {
        return mapper.toDTO(phoneRepo.findById(id).orElseThrow());
    }
    @Override
    public List<PhoneDTO> getAll() {
        return phoneRepo.findAll().stream().map(mapper::toDTO).toList();
    }
}