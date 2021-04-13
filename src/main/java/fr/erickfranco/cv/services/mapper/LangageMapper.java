package fr.erickfranco.cv.services.mapper;

import fr.erickfranco.cv.models.Langage;
import fr.erickfranco.cv.services.DTO.LangageDTO;
import org.mapstruct.Mapper;
/**
 * @author Erick Franco
 */
@Mapper(componentModel = "spring")
public interface LangageMapper extends EntityMapper<LangageDTO, Langage> {
    LangageDTO toDTO(Langage entity);

    Langage toEntity(LangageDTO dto);

    default Langage fromId(Long id) {
        if (id == null) {
            return null;
        }
        Langage langage = new Langage();
        langage.setId(id);
        return langage;
    }
}
