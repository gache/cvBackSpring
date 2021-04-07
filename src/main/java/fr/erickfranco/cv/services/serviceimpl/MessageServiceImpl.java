package fr.erickfranco.cv.services.serviceimpl;

import fr.erickfranco.cv.models.Message;
import fr.erickfranco.cv.repositories.MessageRepository;
import fr.erickfranco.cv.services.DTO.MessageDTO;
import fr.erickfranco.cv.services.mapper.MessageMapper;
import fr.erickfranco.cv.services.serviceinter.MessageServiceInter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Erick Franco
 */
@Service
public class MessageServiceImpl implements MessageServiceInter {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageServiceImpl(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }


    @Override
    public Page<MessageDTO> findAllMessage(Pageable pageable) {
        return messageRepository.findAll(pageable)
                .map(messageMapper::toDTO);
    }

    @Override
    public List<MessageDTO> findAllAsList() {
        return messageRepository.findAll()
                .stream()
                .map(messageMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<MessageDTO> findMessageById(Long id) {
        return messageRepository.findById(id).map(messageMapper::toDTO);
    }

    @Override
    public MessageDTO saveMessage(MessageDTO messageDTO) {
        Message message = messageMapper.toEntity(messageDTO);
        message = messageRepository.save(message);
        return messageMapper.toDTO(message);
    }

    @Override
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }
}
