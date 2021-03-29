package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Projet;
import fr.erickfranco.cv.services.serviceinter.ProjetServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class ProjetServiceImpl implements ProjetServiceInter {
    @Override
    public List<Projet> findAllProjet() {
        return null;
    }

    @Override
    public Optional<Projet> findProjetById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Projet saveProjet(Projet projet) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
