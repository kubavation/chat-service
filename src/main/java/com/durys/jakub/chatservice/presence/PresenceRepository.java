package com.durys.jakub.chatservice.presence;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface PresenceRepository extends CassandraRepository<Presence, Long> {

    @Query("select * from presence where userid = :userId")
    List<Presence> findAllByUserId(Long userId);
}
