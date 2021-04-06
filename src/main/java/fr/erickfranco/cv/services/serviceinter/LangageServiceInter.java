package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.services.DTO.LangageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface LangageServiceInter {

    Page<LangageDTO> findAllLangage(Pageable pageable);

    List<LangageDTO> findAllAsList();

    Optional<LangageDTO> findLangageById(Long id);

    LangageDTO saveLangage(LangageDTO langageDTO);

    void deleteLangageById(Long id);
}
