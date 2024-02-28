package com.durys.jakub.chatservice.participant;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ParticipantRepository extends CassandraRepository<Participant, Long> {
}
