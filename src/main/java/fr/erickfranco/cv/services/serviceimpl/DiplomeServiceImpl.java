package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Diplome;
import fr.erickfranco.cv.repositories.DiplomeRepository;
import fr.erickfranco.cv.services.serviceinter.DiplomeServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class DiplomeServiceImpl implements DiplomeServiceInter {

    public final DiplomeRepository diplomeRepository;

    @Autowired
    public DiplomeServiceImpl(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }

    @Override
    public List<Diplome> findAllDiplome() {
        return diplomeRepository.findAll();
    }

    @Override
    public Diplome saveDiplome(Diplome diplome) {
        if (diplome.getNomDiplome().isEmpty()) {
            System.out.println("Le nom du diplome est obligatoire");
        }
        return diplomeRepository.save(diplome);
    }

    @Override
    public Optional<Diplome> findDiplomeById(Long id) {
        if (!diplomeRepository.existsById(id)){
            System.out.println("Le Diplôme avec l'id " + id + " n'existe pas ");
        }
        return Optional.of(diplomeRepository.getOne(id));
    }

    @Override
    public void deleteDiplomeById(Long id) {
        if (!diplomeRepository.existsById(id)){
            System.out.println("Le Diplome que vous souhaitez l'eliminer avec l'id numéro: " + id + " n'existe pas ");
        }
        diplomeRepository.deleteById(id);
    }
}
