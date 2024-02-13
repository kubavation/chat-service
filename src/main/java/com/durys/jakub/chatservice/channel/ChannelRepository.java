package com.durys.jakub.chatservice.channel;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ChannelRepository extends CassandraRepository<Channel, Long> {
}
