package com.gestionprojets.backend.service;

import com.gestionprojets.backend.model.Affectation;
import com.gestionprojets.backend.repository.AffectationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AffectationService {
    private final AffectationRepository repository;
    public List<Affectation> findAll() { return repository.findAll(); }
    public List<Affectation> findByEmploye(Long id) { return repository.findByEmployeId(id); }
    public List<Affectation> findByProjet(Long id) { return repository.findByProjetId(id); }
    public Affectation save(Affectation a) { return repository.save(a); }
    public void delete(Long id) { repository.deleteById(id); }
}