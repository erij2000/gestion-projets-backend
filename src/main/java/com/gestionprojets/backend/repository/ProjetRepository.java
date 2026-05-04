package com.gestionprojets.backend.repository;
import com.gestionprojets.backend.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProjetRepository extends JpaRepository<Projet, Long> {}