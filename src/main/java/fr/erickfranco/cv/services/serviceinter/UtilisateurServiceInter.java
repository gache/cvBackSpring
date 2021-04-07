package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Utilisateur;
import fr.erickfranco.cv.services.DTO.CreateOrEditUtilisateurDTO;
import fr.erickfranco.cv.services.DTO.UtilisateurDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface UtilisateurServiceInter extends UserDetailsService {

    Page<UtilisateurDTO> findAll(Pageable pageable);

    List<UtilisateurDTO> findAllAsList();

    Optional<Utilisateur> findByLogin(String login);

    Optional<UtilisateurDTO> findOne(Long id);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    Optional<Utilisateur> getCurrentUserLogin();

    UtilisateurDTO save(UtilisateurDTO clientDTO);

    UtilisateurDTO save(CreateOrEditUtilisateurDTO clientDTO);

    void delete(Long id);

}
