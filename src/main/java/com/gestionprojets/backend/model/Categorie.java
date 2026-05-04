package com.gestionprojets.backend.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nom;
}