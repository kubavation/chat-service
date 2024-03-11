package com.durys.jakub.chatservice.presence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Component
@Slf4j
@RequiredArgsConstructor
class UserConnectedEventHandler {

    private static final String USER_ID = "user-id";

    private final PresenceService presenceService;

    @EventListener
    public void handleSessionConnected(SessionConnectEvent event) {

        Long userId = Long.valueOf(retrieveUserId(event));

        log.info("{} connected", userId);

        presenceService.notifyAboutPresence(userId);
    }

    private static String retrieveUserId(SessionConnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        return headerAccessor.getFirstNativeHeader(USER_ID);
    }

}
