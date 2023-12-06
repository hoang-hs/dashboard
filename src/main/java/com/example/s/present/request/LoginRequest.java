package com.example.s.present.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    String username;
    @NotBlank
    String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

