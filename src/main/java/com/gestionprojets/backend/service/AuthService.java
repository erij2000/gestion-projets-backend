package com.gestionprojets.backend.service;

import com.gestionprojets.backend.dto.JwtResponse;
import com.gestionprojets.backend.dto.LoginRequest;
import com.gestionprojets.backend.dto.RegisterRequest;
import com.gestionprojets.backend.model.Employe;
import com.gestionprojets.backend.repository.CategorieRepository;
import com.gestionprojets.backend.repository.EmployeRepository;
import com.gestionprojets.backend.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final EmployeRepository employeRepository;
    private final CategorieRepository categorieRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public JwtResponse login(LoginRequest req) {
        Employe employe = employeRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Email introuvable"));
        if (!passwordEncoder.matches(req.getPassword(), employe.getPassword()))
            throw new RuntimeException("Mot de passe incorrect");
        String token = jwtUtils.generateToken(employe.getEmail(), employe.getRole().name());
        return new JwtResponse(token, employe.getEmail(), employe.getRole().name());
    }

    public Employe register(RegisterRequest req) {
        if (employeRepository.existsByEmail(req.getEmail()))
            throw new RuntimeException("Email déjà utilisé");
        Employe e = new Employe();
        e.setNom(req.getNom());
        e.setPrenom(req.getPrenom());
        e.setEmail(req.getEmail());
        e.setPassword(passwordEncoder.encode(req.getPassword()));
        e.setRole(Employe.Role.EMPLOYE);
        if (req.getCategorieId() != null)
            categorieRepository.findById(req.getCategorieId()).ifPresent(e::setCategorie);
        return employeRepository.save(e);
    }
}