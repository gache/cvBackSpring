package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Diplome;
import fr.erickfranco.cv.services.serviceinter.DiplomeServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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



}
