package com.durys.jakub.chatservice.message;

import com.durys.jakub.chatservice.shared.IdentifierGenerator;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
class MessageService {

    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate messagingTemplate;
    private final IdentifierGenerator identifierGenerator;

    MessageService(MessageRepository messageRepository, SimpMessagingTemplate messagingTemplate,
                   IdentifierGenerator identifierGenerator) {
        this.messageRepository = messageRepository;
        this.messagingTemplate = messagingTemplate;
        this.identifierGenerator = identifierGenerator;
    }

    void handleMessage(MessageDTO message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
        saveMessage(message);
    }


    void saveMessage(MessageDTO message) {
        var entity = new Message(1L, identifierGenerator.next(), 1L, 2L, message.getText(), Instant.now());
        messageRepository.save(entity);
    }

    void retrieveMessages() {

        List<Message> messages = messageRepository.channelMessages(1L);

        messages
                .stream()
                .map(message -> new MessageDTO(message.getContent(), "from"))
                .forEach(message -> messagingTemplate.convertAndSend("/topic/messages", message));
    }

}
