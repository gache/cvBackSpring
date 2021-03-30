package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Projet;
import fr.erickfranco.cv.services.serviceinter.ProjetServiceInter;
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
public class ProjetController {

    private final ProjetServiceInter projetServiceInter;

    public ProjetController(ProjetServiceInter projetServiceInter) {
        this.projetServiceInter = projetServiceInter;
    }

    @GetMapping("/projets")
    public ResponseEntity<List<Projet>> getProjets() {
        return ResponseEntity.status(HttpStatus.OK).body(projetServiceInter.findAllProjet());
    }

}
