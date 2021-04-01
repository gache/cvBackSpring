package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Utilisateur;
import fr.erickfranco.cv.services.serviceinter.UtilisateurServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Erick Franco
 */
@RestController
@RequestMapping("/api")
public class UtilisateurController {

    private final UtilisateurServiceInter utilisateurServiceInter;

    public UtilisateurController(UtilisateurServiceInter utilisateurServiceInter) {
        this.utilisateurServiceInter = utilisateurServiceInter;
    }

    @GetMapping("/utilisateurs")
    public ResponseEntity <List<Utilisateur>> getAllUtilisateur(){
        return ResponseEntity.status(HttpStatus.OK).body(utilisateurServiceInter.findAllUser());
    }


    @PostMapping("/login")
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur) {
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurServiceInter.createUtilisateur(utilisateur));
    }
}
