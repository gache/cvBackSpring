package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Projet;
import fr.erickfranco.cv.services.serviceinter.ProjetServiceInter;
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
public class ProjetController {

    private final ProjetServiceInter projetServiceInter;

    public ProjetController(ProjetServiceInter projetServiceInter) {
        this.projetServiceInter = projetServiceInter;
    }

    @GetMapping("/projets")
    public ResponseEntity<List<Projet>> getProjets() {
        return ResponseEntity.status(HttpStatus.OK).body(projetServiceInter.findAllProjet());
    }

    @GetMapping("projetId/{id}")
    public ResponseEntity<Optional<Projet>> projetById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(projetServiceInter.findProjetById(id));
    }

    @PostMapping("/createProjet")
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projetServiceInter.saveProjet(projet));
    }

    @PutMapping("/updateProjet")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet) {
        return ResponseEntity.status(HttpStatus.OK).body(projetServiceInter.saveProjet(projet));
    }

    @DeleteMapping("/deleteProjet/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        projetServiceInter.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
