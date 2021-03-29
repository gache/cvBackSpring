package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Message;
import fr.erickfranco.cv.services.serviceinter.MessageServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * @author Erick Franco
 */
@Service
public class MessageServiceImpl implements MessageServiceInter {
    @Override
    public List<Message> findAllMessage() {
        return null;
    }

    @Override
    public void deleteMessageById(Integer id) {

    }

    @Override
    public Optional<Message> findMessageById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Message saveMessage(Message message) {
        return null;
    }
}
