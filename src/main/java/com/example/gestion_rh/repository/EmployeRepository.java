package com.example.gestion_rh.repository;

import com.example.gestion_rh.entities.Employe;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    List<Employe> findByNomContainingIgnoreCase(String nom);
}