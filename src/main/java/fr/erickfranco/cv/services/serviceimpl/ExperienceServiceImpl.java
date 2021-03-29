package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Experience;
import fr.erickfranco.cv.repositories.ExperienceRepository;
import fr.erickfranco.cv.services.serviceinter.ExperienceServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class ExperienceServiceImpl implements ExperienceServiceInter {

    public final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }


    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Optional<Experience> findById(Long id) {
        if (!experienceRepository.existsById(id)) {
            System.out.println("L'experience avec l'id " + id + " n'existe pas ");
        }
        return Optional.of(experienceRepository.getOne(id));
    }

    @Override
    public Experience saveExperience(Experience experience) {
        if (experience.getTitrePoste().isEmpty()) {
            System.out.println("Le titre de l'experience est obligatoire");
        }

        return experienceRepository.save(experience);
    }

    @Override
    public void deleteById(Long id) {
        if (!experienceRepository.existsById(id)) {
            System.out.println("L'experience que vous souhaitez l'eliminer avec l'id numéro: " + id + " n'existe pas ");
        }
        experienceRepository.deleteById(id);
    }
}
