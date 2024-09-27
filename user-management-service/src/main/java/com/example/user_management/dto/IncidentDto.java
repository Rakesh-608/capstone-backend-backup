package com.example.user_management.dto;

import java.time.LocalDateTime;
import java.util.Date;

public record IncidentDto(
        String id,
        String userId,
        String location,
        LocalDateTime time,
        String description,
        String incidentType,
        boolean reviewStatus,
        LocalDateTime dateOfPosted
) {}
