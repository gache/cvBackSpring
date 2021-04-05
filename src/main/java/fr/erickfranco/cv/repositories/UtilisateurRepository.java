package fr.erickfranco.cv.repositories;

import fr.erickfranco.cv.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Erick Franco
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query(" select u from Utilisateur u " +
            " where u.nomUtilisateur = ?1")
    Optional<Utilisateur> findUserWithName(String username);
}
