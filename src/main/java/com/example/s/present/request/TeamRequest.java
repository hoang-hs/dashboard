package com.example.s.present.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequest {
    @NotBlank
    String userId;
    @NotBlank
    String name;
}
