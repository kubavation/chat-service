package com.durys.jakub.chatservice.message;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MessageRepository extends CassandraRepository<Message, Long> {
}
