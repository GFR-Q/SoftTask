package org.example.lab7.service;

import org.example.lab7.dto.PhoneDTO;

import java.util.List;

public interface PhonServices {

    PhoneDTO create(PhoneDTO phoneDTO);

    List<PhoneDTO> findAll();

    PhoneDTO findById(Long id);

    PhoneDTO update(Long id, PhoneDTO phoneDTO);

    boolean delete(Long id);
}