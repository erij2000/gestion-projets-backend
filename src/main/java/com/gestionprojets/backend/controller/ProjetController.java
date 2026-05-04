package com.gestionprojets.backend.controller;

import com.gestionprojets.backend.model.Projet;
import com.gestionprojets.backend.service.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projets")
@RequiredArgsConstructor
public class ProjetController {
    private final ProjetService service;

    @GetMapping
    public List<Projet> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Projet findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Projet> save(@RequestBody Projet p) {
        return ResponseEntity.ok(service.save(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projet> update(@PathVariable Long id, @RequestBody Projet p) {
        return ResponseEntity.ok(service.update(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}