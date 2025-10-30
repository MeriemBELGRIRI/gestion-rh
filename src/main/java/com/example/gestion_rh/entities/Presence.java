package com.example.gestion_rh.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPresence;

    private Date date;
    private String statut;

    @ManyToOne
    private Employe employe;

    // Getters, Setters
}
