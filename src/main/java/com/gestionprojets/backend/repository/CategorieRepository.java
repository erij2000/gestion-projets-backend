package com.gestionprojets.backend.repository;
import com.gestionprojets.backend.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategorieRepository extends JpaRepository<Categorie, Long> {}