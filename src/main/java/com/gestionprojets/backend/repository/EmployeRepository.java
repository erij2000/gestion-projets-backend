package com.gestionprojets.backend.repository;
import com.gestionprojets.backend.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    Optional<Employe> findByEmail(String email);
    boolean existsByEmail(String email);
}