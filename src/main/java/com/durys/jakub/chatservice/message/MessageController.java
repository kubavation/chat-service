package com.durys.jakub.chatservice.message;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MessageController {

    private final SimpMessagingTemplate messagingTemplate;

    MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/messages")
    void handleMessage(@Payload String message) {
        messagingTemplate.convertAndSend("/queue", message);
    }

}
