package com.gestionprojets.backend.repository;
import com.gestionprojets.backend.model.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AffectationRepository extends JpaRepository<Affectation, Long> {
    List<Affectation> findByEmployeId(Long employeId);
    List<Affectation> findByProjetId(Long projetId);
}