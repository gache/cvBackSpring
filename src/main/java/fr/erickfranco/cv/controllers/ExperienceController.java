package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Experience;
import fr.erickfranco.cv.services.serviceinter.ExperienceServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@RestController
@RequestMapping("/api")
public class ExperienceController {

    private final ExperienceServiceInter experienceServiceInter;

    public ExperienceController(ExperienceServiceInter experienceServiceInter) {
        this.experienceServiceInter = experienceServiceInter;
    }

    @GetMapping("/experiences")
    public ResponseEntity<List<Experience>> getDiplomes() {
        return ResponseEntity.status(HttpStatus.OK).body(experienceServiceInter.findAll());
    }

    @GetMapping("/experienceId/{id}")
    public ResponseEntity<Optional<Experience>> experienceById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(experienceServiceInter.findById(id));
    }












}
