package org.example.lab7.service.serviceimpl;

import org.example.lab7.dto.PhoneDTO;
import org.example.lab7.entity.Phone;
import org.example.lab7.mapper.PhoneMapper;
import org.example.lab7.repository.PhoneRepository;
import org.example.lab7.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepo;
    private final PhoneMapper mapper;

    public PhoneServiceImpl(PhoneRepository phoneRepo, PhoneMapper mapper) {
        this.phoneRepo = phoneRepo;
        this.mapper = mapper;
    }

    @Override
    public PhoneDTO create(PhoneDTO dto) {
        Phone phone = mapper.toEntity(dto);
        phoneRepo.save(phone);
        return mapper.toDTO(phone);
    }

    @Override
    public PhoneDTO update(Long id, PhoneDTO dto) {
        Phone existing = phoneRepo.findById(id).orElseThrow();

        existing.setModel(dto.getModel());
        existing.setPrice(dto.getPrice());

        Phone updated = mapper.toEntity(dto);
        existing.setBrand(updated.getBrand());
        existing.setCategories(updated.getCategories());

        phoneRepo.save(existing);
        return mapper.toDTO(existing);
    }

    @Override
    public void delete(Long id) {
        phoneRepo.deleteById(id);
    }

    @Override
    public PhoneDTO getById(Long id) {
        Phone phone = phoneRepo.findById(id).orElseThrow();
        return mapper.toDTO(phone);
    }

    @Override
    public List<PhoneDTO> getAll() {
        List<Phone> phones = phoneRepo.findAll();
        List<PhoneDTO> result = new ArrayList<>();

        for (Phone phone : phones) {
            result.add(mapper.toDTO(phone));
        }

        return result;
    }
}