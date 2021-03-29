package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Experience;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface ExperienceServiceInter {
    List<Experience> findAll();

    Optional<Experience> findById(Long id);

    Experience saveExperience(Experience experience);

    void deleteById(Long id);
}
