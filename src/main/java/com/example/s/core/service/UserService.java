package com.example.s.core.service;

import com.example.s.core.domain.User;
import com.example.s.core.domain.repository.UserRepository;
import com.example.s.exception.BadRequestException;
import com.example.s.exception.ResourceNotFoundException;
import com.example.s.present.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(LoginRequest req) {
        Optional<User> optionalUser = userRepository.findByUsername(req.getUsername());
        if (optionalUser.isPresent()) {
            throw BadRequestException.WithMessage("username already exist");
        }
        User user = new User();
        String password = passwordEncoder.encode(req.getPassword());
        user.setPassword(password);
        user.setUsername(req.getUsername());
        return userRepository.save(user);
    }

    public User getById(String id) {
        return userRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::Default);
    }

    public User get() {
        String userId = MDC.get("user_id");
        return userRepository.findById(userId)
                .orElseThrow(ResourceNotFoundException::Default);
    }

}
