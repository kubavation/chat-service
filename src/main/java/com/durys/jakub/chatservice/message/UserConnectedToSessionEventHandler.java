package com.durys.jakub.chatservice.message;

import com.durys.jakub.chatservice.ws.WsURI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.util.Objects;

@Component
@Slf4j
class UserConnectedToSessionEventHandler {


    @EventListener(condition = "@userConnectedToSessionEventHandler.isChatSession(#event)")
    public void handleSessionConnected(SessionSubscribeEvent event) {
        log.info("in handleSessionConnected");
    }


    public static boolean isChatSession(SessionSubscribeEvent event) {

        final String destination = SimpMessageHeaderAccessor.wrap(event.getMessage()).getDestination();

        log.info(destination);

        if (Objects.isNull(destination)) {
            return false;
        }

        return destination.startsWith(WsURI.CHAT.endpoint());
    }

}
