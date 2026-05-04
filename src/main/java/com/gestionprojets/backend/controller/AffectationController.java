package com.gestionprojets.backend.controller;

import com.gestionprojets.backend.model.Affectation;
import com.gestionprojets.backend.service.AffectationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/affectations")
@RequiredArgsConstructor
public class AffectationController {
    private final AffectationService service;

    @GetMapping
    public List<Affectation> findAll() { return service.findAll(); }

    @GetMapping("/employe/{id}")
    public List<Affectation> byEmploye(@PathVariable Long id) { return service.findByEmploye(id); }

    @GetMapping("/projet/{id}")
    public List<Affectation> byProjet(@PathVariable Long id) { return service.findByProjet(id); }

    @PostMapping
    public ResponseEntity<Affectation> save(@RequestBody Affectation a) {
        return ResponseEntity.ok(service.save(a));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}