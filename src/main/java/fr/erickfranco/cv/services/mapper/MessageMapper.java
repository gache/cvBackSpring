package fr.erickfranco.cv.services.mapper;


import fr.erickfranco.cv.models.Message;
import fr.erickfranco.cv.services.DTO.MessageDTO;
import org.mapstruct.Mapper;

/**
 * @author Erick Franco
 */
@Mapper(componentModel = "spring")
public interface MessageMapper extends EntityMapper<MessageDTO, Message> {

    MessageDTO toDTO(Message entity);

    Message toEntity(MessageDTO dto);

    default Message fromId(Long id) {
        if (id == null) {
            return null;
        }
        Message message = new Message();
        message.setId(id);
        return message;
    }
}
