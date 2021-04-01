package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Utilisateur;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface UtilisateurServiceInter extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    List<Utilisateur> findAllUser();

    Utilisateur findUserById(Long id);

    Utilisateur saveUser(Utilisateur utilisateur);

    void deleteById(Long id);
}
