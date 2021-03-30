package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Langage;
import fr.erickfranco.cv.services.serviceinter.LangageServiceInter;
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
public class LangageController {

    private final LangageServiceInter langageServiceInter;

    public LangageController(LangageServiceInter langageServiceInter) {
        this.langageServiceInter = langageServiceInter;
    }

    @GetMapping("/langages")
    public ResponseEntity<List<Langage>> getLangages() {
        return ResponseEntity.status(HttpStatus.OK).body(langageServiceInter.findAllLangage());
    }

    @GetMapping("/langageId/{id}")
    public ResponseEntity<Optional<Langage>> getLangageById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(langageServiceInter.findLangageById(id));
    }

    @PostMapping("/createLangage")
    public ResponseEntity<Langage> createLangage(@RequestBody Langage langage) {
        return ResponseEntity.status(HttpStatus.CREATED).body(langageServiceInter.saveLangage(langage));
    }

    @PutMapping("/updateLangage")
    public ResponseEntity<Langage> updateLangage(@RequestBody Langage langage) {
        return ResponseEntity.status(HttpStatus.CREATED).body(langageServiceInter.saveLangage(langage));
    }


}
