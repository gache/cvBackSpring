package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Diplome;


import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */

public interface DiplomeServiceInter {

    List<Diplome> findAllDiplome();

    Optional<Diplome> findDiplomeById(Long id);

    Diplome saveDiplome(Diplome diplome);

    void deleteDiplomeById(Long id);
}
