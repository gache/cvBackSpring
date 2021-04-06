package fr.erickfranco.cv.services.mapper;


import fr.erickfranco.cv.models.Experience;
import fr.erickfranco.cv.services.DTO.ExperienceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceMapper extends EntityMapper<ExperienceDTO, Experience> {

    ExperienceDTO toDTO(Experience entity);

    Experience toEntity(ExperienceDTO dto);

    default Experience fromId(Long id) {
        if (id == null) {
            return null;
        }
        Experience experience = new Experience();
        experience.setId(id);
        return experience;
    }

}
