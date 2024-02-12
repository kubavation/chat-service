package com.durys.jakub.chatservice.message;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Table
public class Message {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Long id;

    private Long messageFrom;
    private Long messageTo;

    private String content;
    private Instant createdAt;

}
