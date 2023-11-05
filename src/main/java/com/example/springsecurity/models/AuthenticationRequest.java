package com.example.springsecurity.models;

public record AuthenticationRequest(String username, String password, String role) {
}
