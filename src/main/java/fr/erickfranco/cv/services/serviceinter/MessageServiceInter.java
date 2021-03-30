package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Message;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface MessageServiceInter {

    List<Message> findAllMessage();

    Optional<Message> findMessageById(Long id);

    Message saveMessage(Message message);

    void deleteMessageById(Long id);
}
