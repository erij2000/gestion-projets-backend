package com.gestionprojets.backend.service;

import com.gestionprojets.backend.model.Employe;
import com.gestionprojets.backend.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeService {
    private final EmployeRepository repository;
    private final PasswordEncoder passwordEncoder;
    public List<Employe> findAll() { return repository.findAll(); }
    public Employe findById(Long id) { return repository.findById(id).orElseThrow(); }
    public Employe save(Employe e) {
        e.setPassword(passwordEncoder.encode(e.getPassword()));
        return repository.save(e);
    }
    public Employe update(Long id, Employe updated) {
        Employe e = findById(id);
        e.setNom(updated.getNom());
        e.setPrenom(updated.getPrenom());
        e.setEmail(updated.getEmail());
        e.setCategorie(updated.getCategorie());
        e.setRole(updated.getRole());
        return repository.save(e);
    }
    public void delete(Long id) { repository.deleteById(id); }
}