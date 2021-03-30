package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Diplome;
import fr.erickfranco.cv.services.serviceinter.DiplomeServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DiplomeController {

    private final DiplomeServiceInter diplomeServiceInter;

    @Autowired
    public DiplomeController(DiplomeServiceInter diplomeServiceInter) {
        this.diplomeServiceInter = diplomeServiceInter;
    }

    @GetMapping("/diplomes")
    public ResponseEntity<List<Diplome>> getDiplomes() {
        return ResponseEntity.status(HttpStatus.OK).body(diplomeServiceInter.findAllDiplome());
    }

    @GetMapping("/diplome/{id}")
    public ResponseEntity<Optional<Diplome>> getDiplomeById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(diplomeServiceInter.findDiplomeById(id));
    }

    @PostMapping("/createDiplome")
    public ResponseEntity<Diplome> createDiplome(@RequestBody Diplome diplome) {
        return ResponseEntity.status(HttpStatus.CREATED).body(diplomeServiceInter.saveDiplome(diplome));
    }

    @PutMapping("/updateDiplome")
    public ResponseEntity<Diplome> updateDiplome(@RequestBody Diplome diplome) {
        return ResponseEntity.status(HttpStatus.CREATED).body(diplomeServiceInter.saveDiplome(diplome));
    }


}
