package com.gestionprojets.backend.service;

import com.gestionprojets.backend.model.Projet;
import com.gestionprojets.backend.repository.ProjetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetService {
    private final ProjetRepository repository;
    public List<Projet> findAll() { return repository.findAll(); }
    public Projet findById(Long id) { return repository.findById(id).orElseThrow(); }
    public Projet save(Projet p) { return repository.save(p); }
    public Projet update(Long id, Projet updated) {
        Projet p = findById(id);
        p.setNom(updated.getNom());
        p.setDescription(updated.getDescription());
        return repository.save(p);
    }
    public void delete(Long id) { repository.deleteById(id); }
}