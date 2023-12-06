package com.example.s.core.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document(value = "team")
public class Team {
    @Id
    private String id;
    @Indexed(unique=true)
    private String name;

    @CreatedDate
    Instant createdAt;
    @LastModifiedDate
    Instant updatedAt;

    public Team() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
}
