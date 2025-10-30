package com.example.gestion_rh.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;

    private String typeContrat;
    private Date dateDebut;
    private Date dateFin;
    private String statut;

    @ManyToOne
    private Employe employe;

    // Getters, Setters
}
