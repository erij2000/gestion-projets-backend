package com.gestionprojets.backend.config;

import com.gestionprojets.backend.model.*;
import com.gestionprojets.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final CategorieRepository categorieRepo;
    private final EmployeRepository employeRepo;
    private final ProjetRepository projetRepo;
    private final AffectationRepository affectationRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Catégories
        Categorie ouvrier = save(new Categorie(), "Ouvrier");
        Categorie technicien = save(new Categorie(), "Technicien");
        Categorie ingenieur = save(new Categorie(), "Ingénieur");
        Categorie manager = save(new Categorie(), "Manager");

        // Projets
        Projet p1 = saveProjet("Refonte Site Web", "Modernisation du portail client");
        Projet p2 = saveProjet("Application Mobile", "App iOS/Android pour les employés");
        Projet p3 = saveProjet("Infrastructure Cloud", "Migration vers AWS");
        Projet p4 = saveProjet("Système ERP", "Intégration ERP nouvelle génération");

        // Admin
        Employe admin = new Employe();
        admin.setNom("Kacem"); admin.setPrenom("Erij");
        admin.setEmail("admin@test.com");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole(Employe.Role.ADMIN);
        admin.setCategorie(manager);
        employeRepo.save(admin);

        // Employés
        Employe e1 = saveEmploye("Dupont", "Jean", "jean@test.com", "jean123", ingenieur);
        Employe e2 = saveEmploye("Martin", "Sophie", "sophie@test.com", "sophie123", technicien);
        Employe e3 = saveEmploye("Alami", "Youssef", "youssef@test.com", "youssef123", ouvrier);
        Employe e4 = saveEmploye("Leblanc", "Marie", "marie@test.com", "marie123", ingenieur);

        // Affectations
        saveAffectation(e1, p1, "2024-01-10", "2024-06-30");
        saveAffectation(e1, p3, "2024-03-01", "2024-12-31");
        saveAffectation(e2, p1, "2024-02-01", "2024-08-31");
        saveAffectation(e2, p2, "2024-04-01", "2024-10-31");
        saveAffectation(e3, p3, "2024-05-01", "2024-11-30");
        saveAffectation(e4, p4, "2024-01-15", "2024-09-30");
    }

    private Categorie save(Categorie c, String nom) { c.setNom(nom); return categorieRepo.save(c); }

    private Projet saveProjet(String nom, String desc) {
        Projet p = new Projet(); p.setNom(nom); p.setDescription(desc);
        return projetRepo.save(p);
    }

    private Employe saveEmploye(String nom, String prenom, String email, String pwd, Categorie cat) {
        Employe e = new Employe();
        e.setNom(nom); e.setPrenom(prenom); e.setEmail(email);
        e.setPassword(passwordEncoder.encode(pwd));
        e.setRole(Employe.Role.EMPLOYE); e.setCategorie(cat);
        return employeRepo.save(e);
    }

    private void saveAffectation(Employe e, Projet p, String debut, String fin) {
        Affectation a = new Affectation();
        a.setEmploye(e); a.setProjet(p);
        a.setDateDebut(LocalDate.parse(debut));
        a.setDateFin(LocalDate.parse(fin));
        affectationRepo.save(a);
    }
}