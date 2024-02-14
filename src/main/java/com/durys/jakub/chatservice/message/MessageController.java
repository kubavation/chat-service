package com.durys.jakub.chatservice.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
class MessageController {

    private final SimpMessagingTemplate messagingTemplate;

    MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/messages")
    void handleMessage(@Payload String message) {

        log.info(message);

        messagingTemplate.convertAndSend("/topic/messages", message);
    }

}
