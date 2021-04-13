package fr.erickfranco.cv.services.serviceimpl;


import fr.erickfranco.cv.models.Diplome;
import fr.erickfranco.cv.repositories.DiplomeRepository;
import fr.erickfranco.cv.services.DTO.DiplomeDTO;
import fr.erickfranco.cv.services.mapper.DiplomeMapper;
import fr.erickfranco.cv.services.serviceinter.DiplomeServiceInter;
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
public class DiplomeServiceImpl implements DiplomeServiceInter {

    private final DiplomeRepository diplomeRepository;
    private final DiplomeMapper diplomeMapper;

    public DiplomeServiceImpl(DiplomeRepository diplomeRepository, DiplomeMapper diplomeMapper) {
        this.diplomeRepository = diplomeRepository;
        this.diplomeMapper = diplomeMapper;
    }


    @Override
    public Page<DiplomeDTO> findAllDiplomes(Pageable pageable) {
        return diplomeRepository.findAll(pageable)
                .map(diplomeMapper::toDto);
    }

    @Override
    public List<DiplomeDTO> findAllAsList() {
        return diplomeRepository.findAll()
                .stream()
                .map(diplomeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DiplomeDTO> findDiplomeById(Long id) {
        return diplomeRepository.findById(id).map(diplomeMapper::toDTO);
    }

    @Override
    public DiplomeDTO saveDiplome(DiplomeDTO diplomeDTO) {
        Diplome diplome = diplomeMapper.toEntity(diplomeDTO);
        diplome = diplomeRepository.save(diplome);
        return diplomeMapper.toDTO(diplome);
    }

    @Override
    public void deleteDiplomeById(Long id) {
        diplomeRepository.deleteById(id);
    }
}
