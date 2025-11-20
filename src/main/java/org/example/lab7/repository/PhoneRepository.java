package org.example.lab7.repository;


import org.example.lab7.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhoneRepository extends JpaRepository<Phone, Long> { }