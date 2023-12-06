package com.example.s.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Document(value = "user")
public class User {
    @Id
    private String id;

    @Indexed(unique=true)
    private String username;
    @JsonIgnore
    private String password;
    @CreatedDate
    Instant createdAt;
    @LastModifiedDate
    Instant updatedAt;

    public User() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
}
