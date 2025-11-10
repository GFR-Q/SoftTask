package org.example.lab7.controller;

import com.example.lab7.dto.PhoneDTO;
import com.example.lab7.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping
    public ResponseEntity<PhoneDTO> createPhone(@RequestBody PhoneDTO phoneDTO) {
        PhoneDTO createdPhone = phoneService.create(phoneDTO);
        return new ResponseEntity<>(createdPhone, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PhoneDTO>> getAllPhones() {
        List<PhoneDTO> phones = phoneService.findAll();
        return ResponseEntity.ok(phones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneDTO> getPhoneById(@PathVariable Long id) {
        Optional<PhoneDTO> phone = phoneService.findById(id);

        return phone.map(ResponseEntity::ok) // Если телефон найден, возвращаем 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Иначе 404 Not Found
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneDTO> updatePhone(@PathVariable Long id,
                                                @RequestBody PhoneDTO phoneDTO) {
        Optional<PhoneDTO> updatedPhone = phoneService.update(id, phoneDTO);

        return updatedPhone.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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