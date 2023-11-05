package com.example.springsecurity.controllers;

import com.example.springsecurity.models.AuthenticationRequest;
import com.example.springsecurity.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/home")
    public String home() {
        return "Home!";
    }

    @GetMapping("/user")
    public String user() {
        return "User!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin!";
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> register(@RequestBody AuthenticationRequest request) {
        return applicationService.register(request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) throws Exception {
        return applicationService.createAuthenticationToken(request);
    }

}
