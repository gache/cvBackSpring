package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Experience;
import fr.erickfranco.cv.services.serviceinter.ExperienceServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createExperience")
    public ResponseEntity<Experience> saveDiplome(@RequestBody Experience experience) {
        return ResponseEntity.status(HttpStatus.CREATED).body(experienceServiceInter.saveExperience(experience));
    }

    @PutMapping("/updateExperience")
    public ResponseEntity<Experience> updateExperience(@RequestBody Experience experience) {
        return ResponseEntity.status(HttpStatus.OK).body(experienceServiceInter.saveExperience(experience));
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        experienceServiceInter.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
