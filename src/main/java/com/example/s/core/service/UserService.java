package com.example.s.core.service;

import com.example.s.core.domain.User;
import com.example.s.core.domain.repository.UserRepository;
import com.example.s.exception.BadRequestException;
import com.example.s.exception.ResourceNotFoundException;
import com.example.s.present.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

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

    public User get(String id) {
        return userRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::Default);
    }

}
