package com.durys.jakub.chatservice.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.util.Objects;

@RestController
@Slf4j
class MessageController {

    private static final String USER_ID = "user-id";
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

        log.info("{} connected", retrieveUsername(event));
    }

    private static String retrieveUsername(SessionConnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        return headerAccessor.getFirstNativeHeader(USER_ID);
    }

    @EventListener
    public void handleSessionConnected(SessionSubscribeEvent event) {

        final String destination = SimpMessageHeaderAccessor.wrap(event.getMessage()).getDestination();
        log.info(destination);
    }

    @EventListener
    public void handleSessionDisconnect(SessionDisconnectEvent event) {
        log.info(event.toString());
    }

}
