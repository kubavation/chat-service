package com.durys.jakub.chatservice.message;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface MessageRepository extends CassandraRepository<Message, Long> {

    @Query("select * from message where channelid = :channelId")
    List<Message> channelMessages(Long channelId);

}
