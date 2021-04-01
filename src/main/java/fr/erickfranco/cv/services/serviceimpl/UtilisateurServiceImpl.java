package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Utilisateur;
import fr.erickfranco.cv.repositories.UtilisateurRepository;
import fr.erickfranco.cv.services.serviceinter.UtilisateurServiceInter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Erick Franco
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurServiceInter {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nomUtilisateur) throws UsernameNotFoundException {
        Objects.requireNonNull(nomUtilisateur);
        Utilisateur utilisateur = utilisateurRepository.findUserWithName(nomUtilisateur).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return utilisateur;
    }

    @Override
    public List<Utilisateur> findAllUser() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur findUserById(Long id) {
        return null;
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        utilisateur.setMdp(passwordEncoder().encode(utilisateur.getPassword()));
        return utilisateurRepository.save(utilisateur);
    }
    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
