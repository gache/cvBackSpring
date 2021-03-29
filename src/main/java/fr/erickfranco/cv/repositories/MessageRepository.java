package fr.erickfranco.cv.repositories;

import fr.erickfranco.cv.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Erick Franco
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
