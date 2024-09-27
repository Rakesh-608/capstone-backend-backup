package com.example.user_management.dto;

public record LoginRequest(
        String email,
        String password
) {
}
