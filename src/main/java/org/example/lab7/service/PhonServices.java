package org.example.lab7.service;

import org.example.lab7.dto.PhoneDTO;

import java.util.List;

public interface PhonServices {

    PhoneDTO create(PhoneDTO phoneDTO);

    List<PhoneDTO> findAll();

    // Изменено: PhoneDTO вместо Optional<PhoneDTO>
    PhoneDTO findById(Long id);

    // Изменено: PhoneDTO вместо Optional<PhoneDTO>
    PhoneDTO update(Long id, PhoneDTO phoneDTO);

    boolean delete(Long id);
}