package com.example.s.present.controller;

import com.example.s.core.domain.User;
import com.example.s.core.dto.Token;
import com.example.s.core.service.AuthService;
import com.example.s.core.service.UserService;
import com.example.s.present.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/register")
    User save(@RequestBody LoginRequest req) {
        return userService.save(req);
    }

    @PostMapping("/login")
    Token login(@RequestBody LoginRequest req) {
        return authService.login(req);
    }

}
