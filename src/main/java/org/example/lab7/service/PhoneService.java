package org.example.lab7.service;


import org.example.lab7.dto.PhoneDTO;
import java.util.List;


public interface PhoneService {
    PhoneDTO create(PhoneDTO dto);
    PhoneDTO update(Long id, PhoneDTO dto);
    void delete(Long id);
    PhoneDTO getById(Long id);
    List<PhoneDTO> getAll();
}