package com.gestionprojets.backend.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;
    @ManyToOne
    @JoinColumn(name = "projet_id", nullable = false)
    private Projet projet;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}