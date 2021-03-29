package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Langage;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface LangageServiceInter {
    List<Langage> findAllLangage();

    Optional<Langage> findLangageById(Integer id);

    Langage saveLangage(Langage langage);

    void deleteLangageById(Integer id);
}