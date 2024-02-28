package com.durys.jakub.chatservice.presence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
class PresenceService {

    private final PresenceRepository presenceRepository;


    public void notifyAboutPresence(Long userId) {

        Instant now = Instant.now();

        List<Presence> presences = presenceRepository.findAllByUserId(userId)
                .stream()
                .map(presence -> presence.markAsActive(now))
                .toList();

        presenceRepository.saveAll(presences);
        //todo notification
    }

}
