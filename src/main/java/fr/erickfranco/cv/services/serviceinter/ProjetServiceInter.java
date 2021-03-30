package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Projet;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface ProjetServiceInter {

    List<Projet> findAllProjet();

    Optional<Projet> findProjetById(Long id);

    Projet saveProjet(Projet projet);

    void deleteById(Long id);
}
