package com.durys.jakub.chatservice.presence;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Table
@Data
@AllArgsConstructor
public class Presence {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Long userId;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Long friendId;

    private String status;
    private Instant lastActiveAt;


    Presence markAsActive(Instant at) {
        status = "ONLINE";
        lastActiveAt = at;
        return this;
    }
}
