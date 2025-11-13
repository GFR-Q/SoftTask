package org.example.lab7.controller;

import org.example.lab7.dto.PhoneDTO;
import org.example.lab7.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public ResponseEntity<List<PhoneDTO>> getAllPhones() {
        List<PhoneDTO> phones = phoneService.findAll();
        return ResponseEntity.ok(phones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneDTO> getPhoneById(@PathVariable Long id) {
        PhoneDTO phone = phoneService.findById(id);
        if (phone != null) {
            return ResponseEntity.ok(phone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PhoneDTO> createPhone(@RequestBody PhoneDTO phoneDTO) {
        PhoneDTO createdPhone = phoneService.create(phoneDTO);
        return new ResponseEntity<>(createdPhone, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneDTO> updatePhone(@PathVariable Long id,
                                                @RequestBody PhoneDTO phoneDTO) {
        PhoneDTO updatedPhone = phoneService.update(id, phoneDTO);

        if (updatedPhone != null) {
            return ResponseEntity.ok(updatedPhone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        boolean deleted = phoneService.delete(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}