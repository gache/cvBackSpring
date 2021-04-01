package fr.erickfranco.cv.controllers;

import fr.erickfranco.cv.models.Message;
import fr.erickfranco.cv.services.serviceinter.MessageServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @GetMapping("/messages/messageId/{id}")
    public ResponseEntity<Optional<Message>> getMessageById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(messageServiceInter.findMessageById(id));
    }

    @PostMapping("/createMessage")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageServiceInter.saveMessage(message));
    }

    @PutMapping("/updateMessage")
    public ResponseEntity<Message> updateMessage(@RequestBody Message message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageServiceInter.saveMessage(message));
    }

    @DeleteMapping("/deleteMessagesId/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageServiceInter.deleteMessageById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
