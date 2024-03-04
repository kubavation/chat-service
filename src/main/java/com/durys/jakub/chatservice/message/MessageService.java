package com.durys.jakub.chatservice.message;

import com.durys.jakub.chatservice.shared.IdentifierGenerator;
import com.durys.jakub.chatservice.ws.WsUri;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
class MessageService {

    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate messagingTemplate;
    private final MessagePersistenceService messagePersistenceService;


    MessageService(MessageRepository messageRepository, SimpMessagingTemplate messagingTemplate,
                   MessagePersistenceService messagePersistenceService) {
        this.messageRepository = messageRepository;
        this.messagingTemplate = messagingTemplate;
        this.messagePersistenceService = messagePersistenceService;
    }

    void handleMessage(Long channelId, MessageDTO message) {
        messagingTemplate.convertAndSend(WsUri.CHAT.uri().formatted(channelId), message);
        messagePersistenceService.saveMessage(channelId, message);
    }




    void retrieveMessages() {

        List<Message> messages = messageRepository.channelMessages(1L);

        messages
                .stream()
                .map(message -> new MessageDTO(message.getContent(), "from"))
                .forEach(message -> messagingTemplate.convertAndSend("/topic/messages", message));
    }

}
