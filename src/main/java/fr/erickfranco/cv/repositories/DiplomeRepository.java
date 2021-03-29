package fr.erickfranco.cv.repositories;

import fr.erickfranco.cv.models.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Erick Franco
 */
@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
}
