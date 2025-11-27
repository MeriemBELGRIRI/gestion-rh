package com.example.gestion_rh.service;

import com.example.gestion_rh.entities.Employe;
import com.example.gestion_rh.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    private final EmployeRepository repo;

    public EmployeService(EmployeRepository repo) {
        this.repo = repo;
    }

    // Ajouter ou modifier un employé
    public Employe save(Employe e) {
        return repo.save(e);
    }

    // Lister tous les employés
    public List<Employe> getAll() {
        return repo.findAll();
    }

    // Rechercher par nom
    public List<Employe> searchByNom(String nom) {
        return repo.findByNomContainingIgnoreCase(nom);
    }

    // Récupérer un employé par ID
    public Optional<Employe> findById(int id) {
        return repo.findById(id);
    }

    // Supprimer un employé
    public void delete(int id) {
        repo.deleteById(id);
    }
}
