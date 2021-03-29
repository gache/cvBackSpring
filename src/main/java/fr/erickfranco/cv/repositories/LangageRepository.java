package fr.erickfranco.cv.repositories;

import fr.erickfranco.cv.models.Langage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Erick Franco
 */
@Repository
public interface LangageRepository extends JpaRepository<Langage, Long> {
}
