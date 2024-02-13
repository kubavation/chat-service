package com.durys.jakub.chatservice.participant;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
public class Participant {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Long id;

    private String name;
}
