package com.example.gestion_rh.entities;

import jakarta.persistence.*;

@Entity
public class Paie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaie;

    private String mois;
    private String motDePasse; // si c’est pour sécuriser les bulletins
    private double primes;
    private double retenues;
    private double salaireNet;

    @ManyToOne
    private Employe employe;

    // Getters, Setters
}
