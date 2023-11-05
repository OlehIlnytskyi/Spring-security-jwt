package com.example.springsecurity.services;

import com.example.springsecurity.entities.UserEntity;
import com.example.springsecurity.models.AuthenticationRequest;
import com.example.springsecurity.models.AuthenticationResponse;
import com.example.springsecurity.models.Role;
import com.example.springsecurity.repositories.UserRepository;
import com.example.springsecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> register(AuthenticationRequest request) {
        UserEntity newUser = UserEntity.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .roles(Role.valueOf(request.role()))
                .isActive(true)
                .build();

        return ResponseEntity.ok(userRepository.save(newUser));
    }

    public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest request) {

        // Перевірка на пароль?
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        // Отримуємо користувача за username
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.username());

        // Генеруємо jwt токен
        final String jwt = JwtUtil.generateToken(userDetails);

        // Повертаємо обгорнувши в щось
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
