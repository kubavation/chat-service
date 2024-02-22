package com.durys.jakub.chatservice.message;

import com.durys.jakub.chatservice.shared.IdentifierGenerator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
class MessagePersistenceService {

    private final MessageRepository messageRepository;
    private final IdentifierGenerator identifierGenerator;

    MessagePersistenceService(MessageRepository messageRepository, IdentifierGenerator identifierGenerator) {
        this.messageRepository = messageRepository;
        this.identifierGenerator = identifierGenerator;
    }

    @Async
    public void saveMessage(Long channelId, MessageDTO message) {
        var entity = new Message(channelId, identifierGenerator.next(), 1L, 2L, message.getText(), Instant.now());
        messageRepository.save(entity);
    }
}
