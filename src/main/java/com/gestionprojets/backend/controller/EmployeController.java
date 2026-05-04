package com.gestionprojets.backend.controller;

import com.gestionprojets.backend.model.Employe;
import com.gestionprojets.backend.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/employes")
@RequiredArgsConstructor
public class EmployeController {
    private final EmployeService service;

    @GetMapping
    public List<Employe> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Employe findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Employe> save(@RequestBody Employe e) {
        return ResponseEntity.ok(service.save(e));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe e) {
        return ResponseEntity.ok(service.update(id, e));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}