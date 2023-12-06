package com.example.s.core.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document(value = "dashboard")
public class Dashboard {
    @Id
    private String id;

    private JSONPObject data;

    private String teamId;

    private List<String> commentIds;

    @CreatedDate
    Instant createdAt;
    @LastModifiedDate
    Instant updatedAt;

    public Dashboard() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
}
