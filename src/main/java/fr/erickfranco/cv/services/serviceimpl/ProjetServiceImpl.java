package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Projet;
import fr.erickfranco.cv.repositories.ProjetRepository;
import fr.erickfranco.cv.services.serviceinter.ProjetServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class ProjetServiceImpl implements ProjetServiceInter {

    private final ProjetRepository projetRepository;

    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Override
    public List<Projet> findAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Optional<Projet> findProjetById(Long id) {
        if (!projetRepository.existsById(id)) {
            System.out.println("Le projet avec l'id " + id + " n'existe pas ");
        }
        return Optional.of(projetRepository.getOne(id));
    }

    @Override
    public Projet saveProjet(Projet projet) {
        if (projet.getNom() == null || projet.getNom().isEmpty()) {
            System.out.println("Le champ du Nom est obligatoire");
        }
        projetRepository.save(projet);
        return projet;
    }

    @Override
    public void deleteById(Long id) {
        if (!projetRepository.existsById(id)) {
            System.out.println("Le Projet que vous souhaitez l'eliminer avec l'id numéro " + id + " n'existe pas ");
        }
        projetRepository.deleteById(id);
    }
}
