package fr.erickfranco.cv.services.mapper;

import fr.erickfranco.cv.models.Diplome;
import fr.erickfranco.cv.services.DTO.DiplomeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiplomeMapper extends EntityMapper<DiplomeDTO, Diplome> {

    DiplomeDTO toDTO(Diplome entity);

    Diplome toEntity(DiplomeDTO dto);

    default Diplome fromId(Long id) {
        if (id == null) {
            return null;
        }
        Diplome diplome = new Diplome();
        diplome.setId(id);
        return diplome;
    }

}
