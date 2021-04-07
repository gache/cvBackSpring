package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Projet;
import fr.erickfranco.cv.repositories.ProjetRepository;
import fr.erickfranco.cv.services.DTO.ProjetDTO;
import fr.erickfranco.cv.services.mapper.ProjetMapper;
import fr.erickfranco.cv.services.serviceinter.ProjetServiceInter;
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
public class ProjetServiceImpl implements ProjetServiceInter {

    private final ProjetRepository projetRepository;
    private final ProjetMapper projetMapper;

    public ProjetServiceImpl(ProjetRepository projetRepository, ProjetMapper projetMapper) {
        this.projetRepository = projetRepository;
        this.projetMapper = projetMapper;
    }


    @Override
    public Page<ProjetDTO> findAllMessage(Pageable pageable) {
        return projetRepository.findAll(pageable)
                .map(projetMapper::toDTO);
    }

    @Override
    public List<ProjetDTO> findAllAsList() {
        return projetRepository.findAll()
                .stream()
                .map(projetMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProjetDTO> findProjetById(Long id) {
        return projetRepository.findById(id).map(projetMapper::toDTO);
    }

    @Override
    public ProjetDTO saveProjet(ProjetDTO projetDTO) {
        Projet projet = projetMapper.toEntity(projetDTO);
        projet = projetRepository.save(projet);
        return projetMapper.toDTO(projet);
    }

    @Override
    public void deleteById(Long id) {
        projetRepository.deleteById(id);
    }
}
