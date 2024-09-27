package com.example.user_management.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "incidents")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Incident {

    @Id
    private String id;

    private String userId;

    private String location;

    private LocalDateTime time;

    private String description;

    private String incidentType;

    private boolean reviewStatus;

    private LocalDateTime dateOfPosted;

}
