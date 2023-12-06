package com.example.s.core.domain;

import com.example.s.core.enums.Role;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document(value = "permission")
public class Permission {
    @Id
    private String id;

    @DBRef
    private User user;

    @DBRef
    private Team team;

    private Role role;

    @CreatedDate
    Instant createdAt;
    @LastModifiedDate
    Instant updatedAt;

    public Permission() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

}
