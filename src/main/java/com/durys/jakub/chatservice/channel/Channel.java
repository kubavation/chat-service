package com.durys.jakub.chatservice.channel;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Table
@Data
public class Channel {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Long userId;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Long id;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Long with;

    private String status;
    private Instant lastAccessedAt;
}
