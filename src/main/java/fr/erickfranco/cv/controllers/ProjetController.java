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


}
