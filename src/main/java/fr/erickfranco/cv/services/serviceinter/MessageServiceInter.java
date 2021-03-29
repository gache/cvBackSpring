package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.models.Message;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface MessageServiceInter {

    List<Message> findAllMessage();

    void deleteMessageById(Integer id);

    Optional<Message> findMessageById(Integer id);

    Message saveMessage(Message message);
}
