package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Langage;
import fr.erickfranco.cv.repositories.LangageRepository;
import fr.erickfranco.cv.services.DTO.LangageDTO;
import fr.erickfranco.cv.services.mapper.LangageMapper;
import fr.erickfranco.cv.services.serviceinter.LangageServiceInter;
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
public class LangageServiceImpl implements LangageServiceInter {

    private final LangageRepository langageRepository;
    private final LangageMapper langageMapper;

    public LangageServiceImpl(LangageRepository langageRepository, LangageMapper langageMapper) {
        this.langageRepository = langageRepository;
        this.langageMapper = langageMapper;
    }

    @Override
    public Page<LangageDTO> findAllLangage(Pageable pageable) {
        return langageRepository.findAll(pageable)
                .map(langageMapper::toDTO);
    }

    @Override
    public List<LangageDTO> findAllAsList() {
        return langageRepository.findAll()
                .stream()
                .map(langageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LangageDTO> findLangageById(Long id) {
        return langageRepository.findById(id).map(langageMapper::toDTO);
    }

    @Override
    public LangageDTO saveLangage(LangageDTO langageDTO) {
        Langage langage = langageMapper.toEntity(langageDTO);
        langage = langageRepository.save(langage);
        return langageMapper.toDTO(langage);
    }

    @Override
    public void deleteLangageById(Long id) {
        langageRepository.deleteById(id);
    }
}