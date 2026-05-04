package com.gestionprojets.backend.controller;

import com.gestionprojets.backend.model.Categorie;
import com.gestionprojets.backend.service.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/categories")
@RequiredArgsConstructor
public class CategorieController {
    private final CategorieService service;

    @GetMapping
    public List<Categorie> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Categorie findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Categorie> save(@RequestBody Categorie c) {
        return ResponseEntity.ok(service.save(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorie> update(@PathVariable Long id, @RequestBody Categorie c) {
        c.setId(id);
        return ResponseEntity.ok(service.save(c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}