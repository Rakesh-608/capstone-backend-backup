package com.example.user_management.dto;

import java.time.LocalDateTime;

public record PersonDto(

        String id,
        String name,
        String role,
        String email,
        String password,
        String phone,
        String address,
        String gender,
        int age,
        String emergencyContact

//        String id,
//        String name,
//        String role,
//        String email,
//        String password,
//        String phone,
//        String address,
//        String gender,
//        int age,
//        String emergencyContact
) {
}
