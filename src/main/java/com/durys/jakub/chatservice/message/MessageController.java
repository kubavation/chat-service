package com.durys.jakub.chatservice.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
class MessageController {

    private final MessageService messageService;

    MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/messages")
    void handleMessage(@Payload MessageDTO message) {
        log.info(message.toString());
        messageService.handleMessage(message);
    }

}
