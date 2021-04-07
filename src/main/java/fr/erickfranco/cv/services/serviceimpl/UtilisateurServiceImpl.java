package fr.erickfranco.cv.services.serviceimpl;


import fr.erickfranco.cv.configurations.security.SecurityUtils;
import fr.erickfranco.cv.models.Utilisateur;
import fr.erickfranco.cv.repositories.UtilisateurRepository;
import fr.erickfranco.cv.services.DTO.CreateOrEditUtilisateurDTO;
import fr.erickfranco.cv.services.DTO.UtilisateurDTO;
import fr.erickfranco.cv.services.mapper.UtilisateurMapper;
import fr.erickfranco.cv.services.serviceinter.UtilisateurServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author Erick Franco
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurServiceInter {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }


    @Override
    public Page<UtilisateurDTO> findAll(Pageable pageable) {
        return utilisateurRepository.findAll(pageable)
                .map(utilisateurMapper::toDto);
    }

    @Override
    public List<UtilisateurDTO> findAllAsList() {
        return utilisateurRepository.findAll()
                .stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Utilisateur> findByLogin(String login) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByLogin(login);
        return utilisateur;
    }

    @Override
    public Optional<UtilisateurDTO> findOne(Long id) {
        return utilisateurRepository.findById(id)
                .map(utilisateurMapper::toDto);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByLogin(login);
        return new Utilisateur(utilisateur.get().getUsername(), utilisateur.get().getPassword(), AuthorityUtils.NO_AUTHORITIES);
    }

    @Override
    public Optional<Utilisateur> getCurrentUserLogin() {
        Optional<Utilisateur> result = SecurityUtils.getCurrentUserLogin()
                .flatMap(utilisateurRepository::findByLogin);
        return result;
    }

    @Override
    public UtilisateurDTO save(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);
        utilisateur.setPassword(passwordEncoder().encode(utilisateurDTO.getPassword()));
        try {

            utilisateur = utilisateurRepository.save(utilisateur);
        } catch (Exception e) {
            Object exception = e;
        }
        return utilisateurMapper.toDto(utilisateur);
    }

    @Override
    public UtilisateurDTO save(CreateOrEditUtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);
        utilisateur.setPassword(passwordEncoder().encode(utilisateurDTO.getPassword()));
        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDto(utilisateur);
    }

    @Override
    public void delete(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
