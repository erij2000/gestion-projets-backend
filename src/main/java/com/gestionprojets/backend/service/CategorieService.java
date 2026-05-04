package com.gestionprojets.backend.service;

import com.gestionprojets.backend.model.Categorie;
import com.gestionprojets.backend.repository.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategorieService {
    private final CategorieRepository repository;
    public List<Categorie> findAll() { return repository.findAll(); }
    public Categorie findById(Long id) { return repository.findById(id).orElseThrow(); }
    public Categorie save(Categorie c) { return repository.save(c); }
    public void delete(Long id) { repository.deleteById(id); }
}