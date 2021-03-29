package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Langage;
import fr.erickfranco.cv.services.serviceinter.LangageServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class LangageServiceImpl implements LangageServiceInter {

    @Override
    public List<Langage> findAllLangage() {
        return null;
    }

    @Override
    public Optional<Langage> findLangageById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Langage saveLangage(Langage langage) {
        return null;
    }

    @Override
    public void deleteLangageById(Integer id) {

    }
}
