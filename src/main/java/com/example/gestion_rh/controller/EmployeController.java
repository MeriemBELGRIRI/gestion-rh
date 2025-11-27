package com.example.gestion_rh.controller;

import com.example.gestion_rh.entities.Employe;
import com.example.gestion_rh.service.EmployeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@CrossOrigin(origins = "http://localhost:3000") // autoriser React
public class EmployeController {

    private final EmployeService service;

    public EmployeController(EmployeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employe> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<Employe> search(@RequestParam String nom) {
        return service.searchByNom(nom);
    }

    @PostMapping
    public Employe add(@RequestBody Employe e) {
        return service.save(e);
    }

    @PutMapping("/{id}")
    public Employe update(@PathVariable int id, @RequestBody Employe e) {
        Employe existing = service.findById(id)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));

        existing.setNom(e.getNom());
        existing.setPrenom(e.getPrenom());
        existing.setEmail(e.getEmail());
        existing.setTelephone(e.getTelephone());
        existing.setPoste(e.getPoste());
        existing.setSalaireBase(e.getSalaireBase());
        existing.setStatut(e.getStatut());
        existing.setDateEmbauche(e.getDateEmbauche());
        existing.setDateNaissance(e.getDateNaissance());

        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
