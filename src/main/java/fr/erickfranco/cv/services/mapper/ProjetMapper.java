package fr.erickfranco.cv.services.mapper;


import fr.erickfranco.cv.models.Projet;
import fr.erickfranco.cv.services.DTO.ProjetDTO;
import org.mapstruct.Mapper;

/**
 * @author Erick Franco
 */
@Mapper(componentModel = "spring")
public interface ProjetMapper extends EntityMapper<ProjetDTO, Projet> {

    ProjetDTO toDTO(Projet entity);

    Projet toEntity(ProjetDTO dto);

    default Projet fromId(Long id) {
        if (id == null) {
            return null;
        }
        Projet projet = new Projet();
        projet.setId(id);
        return projet;
    }

}
