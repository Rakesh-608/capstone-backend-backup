package com.example.user_management.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Builder
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Document(collection = "users")
public class Person {

    @Id
    private String id;
    private String name;
    private String role;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String phone;
    private String address;
    private String gender;
    private int age;
    private String emergencyContact;

    @CreatedDate
    @Field("registeredDate")
    private LocalDateTime registeredDate;

}
