package fr.erickfranco.cv.repositories;

import fr.erickfranco.cv.models.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Erick Franco
 */
@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
}
