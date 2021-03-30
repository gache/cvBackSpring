package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Message;
import fr.erickfranco.cv.services.serviceinter.MessageServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Erick Franco
 */
@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageServiceInter messageServiceInter;

    public MessageController(MessageServiceInter messageServiceInter) {
        this.messageServiceInter = messageServiceInter;
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.status(HttpStatus.OK).body(messageServiceInter.findAllMessage());
    }


}
