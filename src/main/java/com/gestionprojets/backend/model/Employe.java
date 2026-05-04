package com.gestionprojets.backend.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = Role.EMPLOYE;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    public enum Role { ADMIN, EMPLOYE }
}