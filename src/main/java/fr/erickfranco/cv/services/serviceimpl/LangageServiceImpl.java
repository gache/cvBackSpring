package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Langage;
import fr.erickfranco.cv.repositories.LangageRepository;
import fr.erickfranco.cv.services.serviceinter.LangageServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class LangageServiceImpl implements LangageServiceInter {

    public final LangageRepository langageRepository;

    public LangageServiceImpl(LangageRepository langageRepository) {
        this.langageRepository = langageRepository;
    }

    @Override
    public List<Langage> findAllLangage() {
        return langageRepository.findAll();
    }

    @Override
    public Optional<Langage> findLangageById(Long id) {
        if (!langageRepository.existsById(id)) {
            System.out.println("Le langage avec l'id " + id + " n'existe pas ");
        }
        return Optional.of(langageRepository.getOne(id));
    }

    @Override
    public Langage saveLangage(Langage langage) {
        if (langage.getLangageInformatique().isEmpty()) {
            System.out.println("Le lanagage est est obligatoire");
        }
        return langageRepository.save(langage);
    }

    @Override
    public void deleteLangageById(Long id) {
        if (!langageRepository.existsById(id)) {
            System.out.println("Le langage que vous souhaitez l'eliminer avec l'id numéro: " + id + " n'existe pas ");
        }
        langageRepository.deleteById(id);

    }
}
