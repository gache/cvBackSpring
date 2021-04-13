package fr.erickfranco.cv.services.serviceinter;


import fr.erickfranco.cv.services.DTO.DiplomeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */

public interface DiplomeServiceInter {

    Page<DiplomeDTO> findAllDiplomes(Pageable pageable);

    List<DiplomeDTO> findAllAsList();

    Optional<DiplomeDTO> findDiplomeById(Long id);

    DiplomeDTO saveDiplome(DiplomeDTO diplomeDTO);

    void deleteDiplomeById(Long id);
}
