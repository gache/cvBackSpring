package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Diplome;


import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */

public interface DiplomeServiceInter {

    List<Diplome> findAllDiplome();

    Diplome saveDiplome(Diplome diplome);

    Optional<Diplome> findDiplomeById(Long id);

    void deleteDiplomeById(Long id);
}
