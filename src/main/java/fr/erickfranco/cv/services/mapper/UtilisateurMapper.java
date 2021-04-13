package fr.erickfranco.cv.services.mapper;

import fr.erickfranco.cv.models.Utilisateur;
import fr.erickfranco.cv.services.DTO.CreateOrEditUtilisateurDTO;
import fr.erickfranco.cv.services.DTO.UtilisateurDTO;
import org.mapstruct.Mapper;

/**
 * @author Erick Franco
 */
@Mapper(componentModel = "spring")
public interface UtilisateurMapper extends EntityMapper<UtilisateurDTO, Utilisateur> {

    UtilisateurDTO toDTO(Utilisateur entity);

    Utilisateur toEntity(UtilisateurDTO dto);

    Utilisateur toEntity(CreateOrEditUtilisateurDTO utilisateurDto);

    default Utilisateur fromId(Long id) {
        if (id == null) {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(id);
        return utilisateur;
    }
}
