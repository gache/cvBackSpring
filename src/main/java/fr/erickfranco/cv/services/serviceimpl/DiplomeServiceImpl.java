package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Diplome;
import fr.erickfranco.cv.services.serviceinter.DiplomeServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class DiplomeServiceImpl implements DiplomeServiceInter {

    @Override
    public List<Diplome> findAllDiplome() {
        return null;
    }

    @Override
    public Diplome saveDiplome(Diplome diplome) {
        return null;
    }

    @Override
    public Optional<Diplome> findDiplomeById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteDiplomeById(Integer id) {

    }
}
