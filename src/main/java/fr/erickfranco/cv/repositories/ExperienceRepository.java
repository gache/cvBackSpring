package fr.erickfranco.cv.repositories;

import fr.erickfranco.cv.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Erick Franco
 */
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
