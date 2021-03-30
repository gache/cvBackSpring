package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Message;
import fr.erickfranco.cv.repositories.MessageRepository;
import fr.erickfranco.cv.services.serviceinter.MessageServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class MessageServiceImpl implements MessageServiceInter {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> findAllMessage() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> findMessageById(Long id) {
        if (!messageRepository.existsById(id)) {
            System.out.println("Le Message que vous souhaitez l'eliminer avec l'id numéro " + id + " n'existe pas ");
        }
        return Optional.of(messageRepository.getOne(id));
    }

    @Override
    public Message saveMessage(Message message) {
        if (message.getEmail().isEmpty() || message.getEmail() == null) {
            System.out.println("Le champ Email est obligatoire");
        }
        messageRepository.save(message);
        return message;
    }

    @Override
    public void deleteMessageById(Long id) {
        if (!messageRepository.existsById(id)) {
            System.out.println("Le Message que vous souhaitez l'eliminer avec l'id numéro " + id + " n'existe pas ");
        }
        messageRepository.deleteById(id);

    }
}
