package fr.erickfranco.cv.services.serviceinter;

import fr.erickfranco.cv.services.DTO.MessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface MessageServiceInter {

    Page<MessageDTO> findAllMessage(Pageable pageable);

    List<MessageDTO> findAllAsList();

    Optional<MessageDTO> findMessageById(Long id);

    MessageDTO saveMessage(MessageDTO messageDTO);

    void deleteMessageById(Long id);
}
