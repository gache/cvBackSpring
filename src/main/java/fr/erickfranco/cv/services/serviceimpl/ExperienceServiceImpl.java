package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Experience;
import fr.erickfranco.cv.services.serviceinter.ExperienceServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class ExperienceServiceImpl implements ExperienceServiceInter {
    @Override
    public List<Experience> findAll() {
        return null;
    }

    @Override
    public Optional<Experience> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Experience saveExperience(Experience experience) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
