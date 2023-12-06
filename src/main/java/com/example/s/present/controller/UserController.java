package com.example.s.present.controller;

import com.example.s.core.domain.User;
import com.example.s.core.service.UserService;
import com.example.s.present.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;

    @PostMapping("")
    User save(@RequestBody LoginRequest req) {
        return userService.save(req);
    }

    @GetMapping("/{id}")
    User get(@PathVariable String id) {
        return userService.get(id);
    }

}
