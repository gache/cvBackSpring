package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.controllers.utils.RestUtils;
import fr.erickfranco.cv.services.DTO.DiplomeDTO;
import fr.erickfranco.cv.services.serviceinter.DiplomeServiceInter;
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
public class DiplomeController {

    private final DiplomeServiceInter diplomeServiceInter;

    public DiplomeController(DiplomeServiceInter diplomeServiceInter) {
        this.diplomeServiceInter = diplomeServiceInter;
    }


    @GetMapping("/diplomes")
    public ResponseEntity<List<DiplomeDTO>> getDiplomes(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        Page<DiplomeDTO> page = diplomeServiceInter.findAllDiplomes(pageable);
        HttpHeaders headers = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    @GetMapping("/diplomes/{id}")
    public ResponseEntity<DiplomeDTO> getDiplome(@PathVariable Long id) {
        Optional<DiplomeDTO> diplomeDTO = diplomeServiceInter.findDiplomeById(id);
        return RestUtils.wrapOrNotFound(diplomeDTO, null);
    }


    @PostMapping("/createDiplome")
    public ResponseEntity<DiplomeDTO> createDiplome(@Valid @RequestBody DiplomeDTO diplomeDTO) throws URISyntaxException {
        DiplomeDTO result = diplomeServiceInter.saveDiplome(diplomeDTO);
        return ResponseEntity.created(new URI("/api/type-paiements" + result.getId()))
                .body(result);
    }


    @PutMapping("/updateDiplome")
    public ResponseEntity<DiplomeDTO> updateDiplome(@Valid @RequestBody DiplomeDTO diplomeDTO) throws URISyntaxException {
        if (diplomeDTO.getId() == null) {
            return null;
        }
        DiplomeDTO result = diplomeServiceInter.saveDiplome(diplomeDTO);
        return ResponseEntity.created(new URI("/api/type-paiements" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/diplome/{id}")
    public ResponseEntity<Void> deleteDiplome(@PathVariable Long id) throws URISyntaxException {
        try {
            diplomeServiceInter.deleteDiplomeById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/diplomes/all")
    public ResponseEntity<List<DiplomeDTO>> getAllDiplome() {
        List<DiplomeDTO> diplomeDTOList = diplomeServiceInter.findAllAsList();
        return ResponseEntity.ok().body(diplomeDTOList);
    }


}
