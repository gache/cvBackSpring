package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Langage;
import fr.erickfranco.cv.services.serviceinter.LangageServiceInter;
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
public class LangageController {

    private final LangageServiceInter langageServiceInter;

    public LangageController(LangageServiceInter langageServiceInter) {
        this.langageServiceInter = langageServiceInter;
    }

    @GetMapping("/langages")
    public ResponseEntity<List<Langage>> getLangages() {
        return ResponseEntity.status(HttpStatus.OK).body(langageServiceInter.findAllLangage());
    }


}
