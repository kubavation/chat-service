package com.durys.jakub.chatservice.presence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Component
@Slf4j
class UserConnectedEventHandler {

    private static final String USER_ID = "user-id";

    @EventListener
    public void handleSessionConnected(SessionConnectEvent event) {

        log.info("{} connected", retrieveUserId(event));
    }

    private static String retrieveUserId(SessionConnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        return headerAccessor.getFirstNativeHeader(USER_ID);
    }

}
