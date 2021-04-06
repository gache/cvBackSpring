package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Experience;
import fr.erickfranco.cv.services.DTO.DiplomeDTO;
import fr.erickfranco.cv.services.DTO.ExperienceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface ExperienceServiceInter {

    Page<ExperienceDTO> findAllExperiences(Pageable pageable);

    List<ExperienceDTO> findAllAsList();

    Optional<ExperienceDTO> findById(Long id);

    ExperienceDTO saveExperience(ExperienceDTO experienceDTO);

    void deleteById(Long id);
}
