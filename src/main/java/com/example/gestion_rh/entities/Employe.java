package com.example.gestion_rh.entities;

import jakarta.persistence.*;
import java.util.*;
import lombok.Data;

@Data
@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmp;

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
    private String telephone;
    private String poste;
    private Date dateEmbauche;
    private double salaireBase;
    private String statut;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Contrat> contrats;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Paie> paies;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Presence> presences;

    // Getters, Setters
}
