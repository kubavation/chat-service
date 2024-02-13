package com.durys.jakub.chatservice.message;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Table
public class Message {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Long channelId;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Long id;

    private Long messageFrom;
    private Long messageTo;

    private String content;
    private Instant createdAt;

}
