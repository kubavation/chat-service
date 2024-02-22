package com.durys.jakub.chatservice.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@RestController
@Slf4j
class MessageController {

    private final MessageService messageService;

    MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/messages/{channelId}")
    void handleMessage(@Payload MessageDTO message, @DestinationVariable Long channelId) {
        log.info(message.toString());
        messageService.handleMessage(channelId, message);
    }


    @EventListener
    public void handleSessionConnected(SessionConnectEvent event) {
        log.info(event.toString());
    }

    @EventListener
    public void handleSessionConnected(SessionSubscribeEvent event) {
        log.info(event.toString());
        messageService.retrieveMessages();
    }

    @EventListener
    public void handleSessionDisconnect(SessionDisconnectEvent event) {
        log.info(event.toString());
    }

}
