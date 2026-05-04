package com.gestionprojets.backend.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    private String description;
}