package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.services.DTO.ProjetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface ProjetServiceInter {

    Page<ProjetDTO> findAllMessage(Pageable pageable);

    List<ProjetDTO> findAllAsList();

    Optional<ProjetDTO> findProjetById(Long id);

    ProjetDTO saveProjet(ProjetDTO projetDTO);

    void deleteById(Long id);
}
