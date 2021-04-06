package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Experience;
import fr.erickfranco.cv.repositories.ExperienceRepository;
import fr.erickfranco.cv.services.DTO.ExperienceDTO;
import fr.erickfranco.cv.services.mapper.ExperienceMapper;
import fr.erickfranco.cv.services.serviceinter.ExperienceServiceInter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Erick Franco
 */
@Service
public class ExperienceServiceImpl implements ExperienceServiceInter {

    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;

    public ExperienceServiceImpl(ExperienceRepository experienceRepository, ExperienceMapper experienceMapper) {
        this.experienceRepository = experienceRepository;
        this.experienceMapper = experienceMapper;
    }

    @Override
    public Page<ExperienceDTO> findAllExperiences(Pageable pageable) {
        return experienceRepository.findAll(pageable)
                .map(experienceMapper::toDTO);
    }

    @Override
    public List<ExperienceDTO> findAllAsList() {
        return experienceRepository.findAll()
                .stream()
                .map(experienceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ExperienceDTO> findById(Long id) {
        return experienceRepository.findById(id).map(experienceMapper::toDTO);
    }

    @Override
    public ExperienceDTO saveExperience(ExperienceDTO experienceDTO) {
        Experience experience = experienceMapper.toEntity(experienceDTO);
        experience = experienceRepository.save(experience);
        return experienceMapper.toDTO(experience);
    }

    @Override
    public void deleteById(Long id) {
        experienceRepository.deleteById(id);
    }
}
