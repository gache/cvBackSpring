package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.controllers.utils.RestUtils;
import fr.erickfranco.cv.services.DTO.DiplomeDTO;
import fr.erickfranco.cv.services.DTO.ExperienceDTO;
import fr.erickfranco.cv.services.serviceinter.ExperienceServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@RestController
@RequestMapping("/api")
public class ExperienceController {

    private final ExperienceServiceInter experienceServiceInter;

    @Autowired
    public ExperienceController(ExperienceServiceInter experienceServiceInter) {
        this.experienceServiceInter = experienceServiceInter;
    }

    @GetMapping("/experiences")
    public ResponseEntity<List<ExperienceDTO>> getExperiences(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        Page<ExperienceDTO> page = experienceServiceInter.findAllExperiences(pageable);
        HttpHeaders headers = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/experiences/{id}")
    public ResponseEntity<ExperienceDTO> getExperience(@PathVariable Long id) {
        Optional<ExperienceDTO> experienceDTO = experienceServiceInter.findById(id);
        return RestUtils.wrapOrNotFound(experienceDTO, null);
    }


    @PostMapping("/createExperience")
    public ResponseEntity<ExperienceDTO> createExperience(@Valid @RequestBody ExperienceDTO experienceDTO) throws URISyntaxException {
        ExperienceDTO result = experienceServiceInter.saveExperience(experienceDTO);
        return ResponseEntity.created(new URI("/api/type-paiements" + result.getId()))
                .body(result);
    }


    @PutMapping("/updateExperience")
    public ResponseEntity<ExperienceDTO> updateExperience(@Valid @RequestBody ExperienceDTO experienceDTO) throws URISyntaxException {
        if (experienceDTO.getId() == null) {
            return null;
        }
        ExperienceDTO result = experienceServiceInter.saveExperience(experienceDTO);
        return ResponseEntity.created(new URI("/api/type-paiements" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/experience/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) throws URISyntaxException {
        try {
            experienceServiceInter.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/experiences/all")
    public ResponseEntity<List<ExperienceDTO>> getAllExperience() {
        List<ExperienceDTO> experienceDTOList = experienceServiceInter.findAllAsList();
        return ResponseEntity.ok().body(experienceDTOList);
    }


}
