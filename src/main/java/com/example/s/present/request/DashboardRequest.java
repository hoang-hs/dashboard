package com.example.s.present.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardRequest {
    @NotBlank
    Object data;
    @NotBlank
    String teamId;
}
