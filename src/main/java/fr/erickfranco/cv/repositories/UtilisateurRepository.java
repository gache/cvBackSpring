package fr.erickfranco.cv.repositories;

import fr.erickfranco.cv.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Erick Franco
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
