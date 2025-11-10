package org.example.lab7.service;

import com.example.lab7.dto.PhoneDTO;
import com.example.lab7.entity.Phone;
import com.example.lab7.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public PhoneDTO toDto(Phone entity) {
        if (entity == null) {
            return null;
        }
        PhoneDTO dto = new PhoneDTO();
        dto.setId(entity.getId());
        dto.setBrand(entity.getBrand());
        dto.setModel(entity.getModel());
        dto.setStorageGb(entity.getStorageGb());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public Phone toEntity(PhoneDTO dto) {
        if (dto == null) {
            return null;
        }
        Phone entity = new Phone();
        entity.setId(dto.getId());
        entity.setBrand(dto.getBrand());
        entity.setModel(dto.getModel());
        entity.setStorageGb(dto.getStorageGb());
        entity.setPrice(dto.getPrice());
        return entity;
    }

    public PhoneDTO create(PhoneDTO phoneDTO) {
        Phone phoneToSave = toEntity(phoneDTO);
        Phone savedPhone = phoneRepository.save(phoneToSave);
        return toDto(savedPhone);
    }

    public List<PhoneDTO> findAll() {
        List<Phone> phones = phoneRepository.findAll();
        return phones.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Optional<PhoneDTO> findById(Long id) {
        Optional<Phone> phoneOptional = phoneRepository.findById(id);
        return phoneOptional.map(this::toDto);
    }

    public Optional<PhoneDTO> update(Long id, PhoneDTO phoneDTO) {
        if (phoneRepository.existsById(id)) {
            phoneDTO.setId(id);

            Phone phoneToUpdate = toEntity(phoneDTO);
            Phone updatedPhone = phoneRepository.save(phoneToUpdate);

            return Optional.of(toDto(updatedPhone));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (phoneRepository.existsById(id)) {
            phoneRepository.deleteById(id);
            return true;
        }
        return false;
    }
}